import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n, k; // n: 건물의 개수, k: 건설순서의 규칙
    static int[] d; // 건물당 건설에 걸리는 시간 n개
    static int[][] xy; // 건설 순서 xy (건물 X를 지은 다음에 건물 Y를 짓는 것이 가능)
    static int w; // 백준이가 승리하기 위해 건설해야 할 건물의 번호
    static int[] dp;

    public static void main(String[] args) throws IOException {

        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            StringTokenizer st = null;
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            d = new int[n + 1];
            for (int i = 1; i <= n; i++) { // 각 건물당 건설에 걸리는 시간
                d[i] = Integer.parseInt(st.nextToken());
            }
            dp = new int[n + 1];
            Arrays.fill(dp, -1);

            xy = new int[k][2];
            for (int i = 0; i < k; i++) { // 건설 순서 xy (건물 X를 지은 다음에 건물 Y를 짓는 것이 가능)
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                xy[i][0] = x;
                xy[i][1] = y;
            }
            w = Integer.parseInt(br.readLine());

            solve(w);

            bw.write(solve(w) + "\n");
            bw.flush();
        } // end tc
        bw.close();
    }

    static int solve(int target) {
        if (dp[target] == -1) {
            int targetConstruct = d[target];
            int weight = 0;
            for (int i = 0; i < k; i++) {
                if (xy[i][1] == target) {
                    int newWeight = solve(xy[i][0]);
                    if (weight < newWeight) {
                        weight = newWeight;
                    }
                }
            }
            dp[target] = targetConstruct + weight;
        }
        return dp[target];
    }

}
