import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int[] a, b, c, d;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        a = new int[n];
        b = new int[n];
        c = new int[n];
        d = new int[n];

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            a[i] = Integer.parseInt(input[0]);
            b[i] = Integer.parseInt(input[1]);
            c[i] = Integer.parseInt(input[2]);
            d[i] = Integer.parseInt(input[3]);
        }

        int size = n * n;
        long[] ab = new long[size];
        long[] cd = new long[size];

        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ab[idx] = (long) a[i] + b[j];
                cd[idx] = (long) c[i] + d[j];
                idx++;
            }
        }

        Arrays.sort(ab);
        Arrays.sort(cd);

        long ans = 0;
        int start = 0;
        int end = size - 1;

        while (start < size && end >= 0) {
            long sum = ab[start] + cd[end];
            if (sum == 0) {
                long abCount = 1;
                long cdCount = 1;
                int s = start + 1;
                int e = end - 1;

                while (s < size && ab[s] == ab[start]) {
                    abCount++;
                    s++;
                }
                while (e >= 0 && cd[e] == cd[end]) {
                    cdCount++;
                    e--;
                }

                ans += abCount * cdCount;
                start = s;
                end = e;
            } else if (sum > 0) {
                end--;
            } else {
                start++;
            }
        }

        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
    }
}