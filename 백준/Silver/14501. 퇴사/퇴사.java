import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n;
    static int ans;
    static int[][] arr;

    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(br.readLine());

        arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(input[0]);// 시간
            arr[i][1] = Integer.parseInt(input[1]);// 금액
        }

        ans = 0;

        int[] dp = new int[n + 1]; // 퇴사일 고려

        for (int i = n - 1; i >= 0; i--) {

            // arr[i][1]: 현재 상담 수익
            // dp[i + arr[i][0]]: 상담이 끝난 날짜(i + arr[i][0]) 부터의 최대 수익
            if (i + arr[i][0] <= n) {
                dp[i] = Math.max(arr[i][1] + dp[i + arr[i][0]], dp[i + 1]);
            } else {
                // dp[i + 1]: 다음날(i+1)부터의 최대 수익
                dp[i] = dp[i + 1];
            }

        }

        for (int i = n - 1; i >= 0; i--) {
            if(dp[i] > ans) {
                ans = dp[i];
            }
        }

        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();

    }
}