import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());
        int[] input = new int[n];
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(br.readLine());
        }

        long ans = 0;
        for (int bit = 0; bit < 20; bit++) {
            int count1 = 0;
            for (int i = 0; i < n; i++) {
                if ((input[i] & (1 << bit)) != 0) {
                    count1++;
                }
            }
            ans += ((long) count1 * (n - count1)) * (1 << bit);
        }

        bw.write(ans + "");
        bw.flush();
        bw.close();
    }
}
