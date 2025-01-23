import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n, k, ans;
    static ArrayList<Integer> queue;
    static ArrayList<Integer> concent;

    public static void main(String[] args) throws IOException {

        String[] in1 = br.readLine().split(" ");

        n = Integer.parseInt(in1[0]);
        k = Integer.parseInt(in1[1]);
        concent = new ArrayList<>();
        queue = new ArrayList<>();

        String[] in2 = br.readLine().split(" ");
        for (int i = 0; i < k; i++) {
            int in = Integer.parseInt(in2[i]);
            queue.add(in);
        }

        ans = 0;
        if (n < k) {
             // 일단 꼽아놓고
                while (concent.size() < n && !queue.isEmpty()) {
                    int next = queue.get(0);
                    if (!concent.contains(next)) { // 안꼽혀있다면
                        concent.add(queue.get(0)); // 꼽기
                    }
                    queue.remove(0);
                }


            while (!queue.isEmpty()) {
                int next = queue.get(0); //다음에 쓸 것
                queue.remove(0);

                if (!concent.contains(next)) {// 다음에 쓸 것이 안꼽혀 있다면 다음에 안오거나 젤 나중에 올거 찾아서 빼기
                    int thingToRemoveIdx = -1; // 다음에 올 것 중 콘센트에서 제거할 것의 인덱스 (값 갱신을 위해 쓰임)
                    int thingToRemove = 0;// 콘센트에서 제거할 것

                    for (Integer thing : concent) {// 콘센트 돌면서
                        if (queue.contains(thing)) {
                            int idxOfThingInQueue = queue.indexOf(thing);
                            if (thingToRemoveIdx < idxOfThingInQueue) {
                                thingToRemoveIdx = idxOfThingInQueue;
                                thingToRemove = thing;
                            }
                        } else {
                            thingToRemove = thing;
                            break;
                        }

                    }//end for

                    int idxOfThingInConcent = concent.indexOf(thingToRemove);
                    concent.set(idxOfThingInConcent, next);
                    ans++;
                }//end if

            }
        }

        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
    }
}
