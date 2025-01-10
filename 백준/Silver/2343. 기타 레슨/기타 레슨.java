import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n, m, ans;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        String[] in = br.readLine().split(" ");
        n = Integer.parseInt(in[0]);
        m = Integer.parseInt(in[1]);
        ans = Integer.MAX_VALUE;

        arr = new int[n];
        String[] in2 = br.readLine().split(" ");
        int max = 0;
        int min = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(in2[i]);
            max += arr[i];
            min = Math.max(min, arr[i]);
        }

        while (min <= max) {
            int limit = (min + max) / 2;
            if (isOk(limit)) {//범위 줄여도 되면
                max = limit - 1;
            } else {
                min = limit + 1;
            }
        }

        bw.write(String.valueOf(min));
        bw.flush();
        bw.close();

    }

    static boolean isOk(int limit) {
        int sum = 0;
        int count = 1;
        for (int i = 0; i < n; i++) {
            if (sum + arr[i] > limit) {
                count++;
                sum = arr[i];
            } else {
                sum += arr[i];
            }
        }
        return count <= m;
    }
}
