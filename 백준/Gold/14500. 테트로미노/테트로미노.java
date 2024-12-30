import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int ans;
    static int n, m;
    static int[][] arr;
    static boolean[][] visited;

    static int dy[] = {0, 0, 1, -1};
    static int dx[] = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {

        String[] in1 = br.readLine().split(" ");

        ans = 0;
        n = Integer.parseInt(in1[0]);
        m = Integer.parseInt(in1[1]);

        arr = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String[] in2 = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(in2[j]);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                visited[i][j] = true;
                dfs(i, j, 0, 1);
                checkOrthogonal(i, j);
                visited[i][j] = false;
            }// end for j
        }// end for i

        System.out.println(ans);

        bw.flush();
        bw.close();
        br.close();
    }

    // ㅗ 모양 제외 확인
    static void dfs(int i, int j, int sum, int dep) {
        sum += arr[i][j];

        if (dep == 4) {
            if (sum > ans) {
                ans = sum;
            }
            return;
        }

        for (int d = 0; d < 4; d++) {
            int ny = i + dy[d];
            int nx = j + dx[d];

            if (ny >= 0 && ny < n && nx >= 0 && nx < m && !visited[ny][nx]) {
                visited[ny][nx] = true;
                dfs(ny, nx, sum, dep + 1);
                visited[ny][nx] = false;
            }
        }

    }

    static void checkOrthogonal(int i, int j) {
        // ㅗ 모양
        if (i > 0 && j > 0 && j < m - 1) {
            int sum = arr[i][j] + arr[i - 1][j] + arr[i][j - 1] + arr[i][j + 1];
            ans = Math.max(ans, sum);
        }

        // ㅏ 모양
        if (i < n - 2 && j < m - 1) {
            int sum = arr[i][j] + arr[i + 1][j] + arr[i + 2][j] + arr[i + 1][j + 1];
            ans = Math.max(ans, sum);
        }

        // ㅜ 모양
        if (i < n - 1 && j > 0 && j < m - 1) {
            int sum = arr[i][j] + arr[i + 1][j] + arr[i][j - 1] + arr[i][j + 1];
            ans = Math.max(ans, sum);
        }

        // ㅓ 모양
        if (i < n - 2 && j > 0) {
            int sum = arr[i][j] + arr[i + 1][j] + arr[i + 2][j] + arr[i + 1][j - 1];
            ans = Math.max(ans, sum);
        }
    }
}
