import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int[] arr;
    static List<Integer> list;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        arr = new int[n];
        String[] in = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(in[i]);
        }

        list = new ArrayList<>();
        list.add(arr[0]);
        for (int i = 0; i < n; i++) {
            put(arr[i]);
        }

        bw.write(String.valueOf(list.size()));
        bw.flush();
        bw.close();

    }

    static void put(int val) {
        int start = 0;
        int end = list.size() - 1;

        if (list.get(end) < val) {
            list.add(val);
        } else {
            while (start <= end) {
                int mid = (start + end) / 2;
                if (list.get(mid) < val) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
list.set(start, val);
        }
       
    }
}
