import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N, K;
    static int[][] arr;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N + 1][2];
        dp = new int[N + 1][K + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken()); // 무게
            arr[i][1] = Integer.parseInt(st.nextToken()); // 가치
        }

        for (int i = 1; i <= N; i++) {
            for (int w = 1; w <= K; w++) {
                int weight = arr[i][0];
                if (w >= weight) {
                    dp[i][w] = Math.max(dp[i - 1][w], arr[i][1] + dp[i - 1][w - weight]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        bw.write(dp[N][K] + "\n");
        bw.flush();
        bw.close();

    }

}
