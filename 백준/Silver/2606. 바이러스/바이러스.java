import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n; // 컴퓨터 수
    static int m; // 네트워크 상에서 직접 연결되어 있는 컴퓨터 쌍의 수

    static int[][] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        visited = new boolean[n + 1];

        arr = new int[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            String[] input = br.readLine().split(" ");
            int in1 = Integer.parseInt(input[0]);
            int in2 = Integer.parseInt(input[1]);

            arr[in1][in2] = 1;
            arr[in2][in1] = 1;

        }

        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        visited[1] = true;

        while (!q.isEmpty()) {

            int now = q.poll();
            for (int i = 1; i < n + 1; i++) {
                if (arr[now][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    q.add(i);
                }

            }

        }

        int count = 0;
        for (int i = 1; i < n + 1; i++) {
            if (visited[i]) {
                count++;
            }
        }
        count -= 1; // 1번 컴터 빼기
        bw.write(count + "\n");
        bw.flush();
        bw.close();

    }
}
