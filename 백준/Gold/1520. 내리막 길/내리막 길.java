import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int m, n;
    static int[][] arr;
    static int[][] dp;

    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        String[] in1 = br.readLine().split(" ");

        m = Integer.parseInt(in1[0]);
        n = Integer.parseInt(in1[1]);

        arr = new int[m][n];
        dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            String[] in2 = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(in2[j]);
            }
        }

        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }

        bw.write(String.valueOf(dfs(0, 0)));
        bw.flush();
        bw.close();
    }

    static int dfs(int i, int j) {

        if (i == m - 1 && j == n - 1) {
            return 1;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        dp[i][j] = 0;

        for (int d = 0; d < 4; d++) {
            int newI = i + dy[d];
            int newJ = j + dx[d];
            if (newI >= 0 && newJ >= 0 && newI < m && newJ < n && arr[newI][newJ] < arr[i][j]) {
                dp[i][j] += dfs(newI, newJ);
            }
        }
        return dp[i][j];
    }
}
