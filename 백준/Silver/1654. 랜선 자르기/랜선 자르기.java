import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int k, n, ans;
    static long[] arr;

    public static void main(String[] args) throws IOException {
        String[] in1 = br.readLine().split(" ");

        k = Integer.parseInt(in1[0]);
        n = Integer.parseInt(in1[1]);

        ans = 0;
        arr = new long[k];

        for (int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        long min = 1;
        long max = arr[k-1];

        while (min <= max) {
            long len = (min + max) / 2;
            if (isOk(len)) {
                min = len + 1;
            } else {
                max = len - 1;
            }
        }

        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();

    }

    static boolean isOk(long len) { // len으로 잘랐을 때 n개 이상 나오는지
        long cnt = 0;
        for (long wire : arr) {
            cnt += wire / len;
        }
        return cnt >= n;
    }
}
