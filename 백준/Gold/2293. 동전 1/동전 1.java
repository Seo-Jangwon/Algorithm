import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n, k;
    static int[] coins;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        String[] in = br.readLine().split(" ");

        n = Integer.parseInt(in[0]);
        k = Integer.parseInt(in[1]);

        coins = new int[n + 1];
        dp = new int[k + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
            for (int j = coins[i]; j <= k; j++) {
                dp[j] += dp[j - coins[i]]; // 현재 동전을 하나 사용하고 남은 금액을 만들 수 있는 경우의 수
            }
        }

        bw.write(String.valueOf(dp[k]));
        bw.flush();
        bw.close();

    }
}
