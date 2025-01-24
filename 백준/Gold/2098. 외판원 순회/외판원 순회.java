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
    static int fullBit;
    static final int inf = 999999999;
    static int[][] arr;
    static int[][] dp;

    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }

        fullBit = (1 << n) - 1;
        dp = new int[n][fullBit];
        for(int i=0; i<n; i++) {
            Arrays.fill(dp[i], -1);
        }

        int ans = tsp(0, 1);
        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
    }

    private static int tsp(int x, int check) {
        if (check == fullBit) {// 모든 도시 방문 완료
            if (arr[x][0] == 0) {
                return inf;// 경로 없는 경우는 탐색 무요화
            } else {
                return arr[x][0];
            }
        }

        if (dp[x][check] != -1) {
            return dp[x][check]; //방문한 경우
        }

        dp[x][check] = inf;

        //방문하지 않은 도시 탐색
        for (int i = 0; i < n; i++) {

            int nextCity = check | (1 << i);

            if (arr[x][i] == 0 || (check & (1 << i)) != 0) {
                continue; // 경로가 없거나 i 도시 방문 시
            }

            dp[x][check] = Math.min(dp[x][check], tsp(i, nextCity) + arr[x][i]);
        }

        return dp[x][check];
    }
}
