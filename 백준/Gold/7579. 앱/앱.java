import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n, m; // n개의 앱, m 바이트 이상의 메모리를 추가로 확보해야 함
    static int[] memory; // 현재 활성화 되어 있는 앱 A1, ..., AN이 사용 중인 메모리의 바이트 수
    static int[] cost; // 각 앱을 비활성화 했을 경우의 비용
    static int[][] dp; // dp[i][j] = i번째 앱까지 고려, 비용 j로 확보할 수 있는 최대 메모리 량

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        memory = new int[n + 1];
        cost = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            memory[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }

        int maxCost = 0;
        for (int i = 1; i <= n; i++) {
            maxCost += cost[i];
        }

        dp = new int[n + 1][maxCost + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= maxCost; j++) {
                dp[i][j] = dp[i - 1][j]; // 비활성화 하지 않는 경우
                if (j >= cost[i]) { // 비활성화 하는 경우
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - cost[i]] + memory[i]);
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int j = 0; j <= maxCost; j++) {
            if (dp[n][j] >= m) {
                answer = Math.min(answer, j);
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }

}
