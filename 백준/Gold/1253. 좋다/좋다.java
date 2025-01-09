import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int ans;
    static int n;
    static int[] arr;

    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        ans = 0;

        String[] in = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(in[i]);
        }

        Arrays.sort(arr);
        for (int idx = 0; idx < n; idx++) {
            check(idx);
        }

        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
    }

    static void check(int idx) {

        int start = 0;
        int end = n - 1;
        if (start == idx) {
            start++;
        }
        if (end == idx) {
            end--;
        }
        while (start < end) {
            int sum = arr[start] + arr[end];
            if (sum == arr[idx]) {
                ans++;
                return;
            } else if (sum < arr[idx]) {
                start++;
                if (start == idx) {
                    start++;
                    if (start >= n) {
                        return;
                    }
                }
            } else { // sum > arr[idx]
                end--;
                if (end == idx) {
                    end--;
                    if (end < 0) {
                        return;
                    }
                }
            }
        }

    }
}
