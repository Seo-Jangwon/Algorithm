
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n;
    static long[] arr;
    static long min = Long.MAX_VALUE;
    static long[] ans = new long[3];

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        arr = new long[n];
        min = Long.MAX_VALUE;
        ans = new long[3];

        String[] in = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(in[i]);
        }

        Arrays.sort(arr);

        for (int i = 0; i < n - 2; i++) {
            put1(i);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            sb.append(ans[i]);
            sb.append(" ");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static void put1(int idx) {
        int start = idx + 1;
        int end = n - 1;

        while (start < end) {
            long sum = arr[start] + arr[end] + arr[idx];
            long absSum = Math.abs(sum);
            if (absSum < min) {
                min = absSum;
                ans[0] = arr[idx];
                ans[1] = arr[start];
                ans[2] = arr[end];
            }
            if(sum==0){
                return;
            }
            if (sum > 0) {
                end--;
            } else {
                start++;
            }
        }

    }

}
