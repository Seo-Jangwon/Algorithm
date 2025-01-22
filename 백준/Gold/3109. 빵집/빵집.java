import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int R, C, ans;
    static char[][] map;

    static int[] di = {-1, 0, 1};
    static int[] dj = {1, 1, 1};

    public static void main(String[] args) throws IOException {
        String[] in1 = br.readLine().split(" ");
        R = Integer.parseInt(in1[0]);
        C = Integer.parseInt(in1[1]);
        ans = 0;

        map = new char[R][C];

        for (int i = 0; i < R; i++) {
            String[] in2 = br.readLine().split("");
            for (int j = 0; j < C; j++) {
                map[i][j] = in2[j].charAt(0);
            }
        }

        for (int i = 0; i < R; i++) {
            if (map[i][0] == '.') {
                dfs(i, 0);
            }
        }

        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();

    }

    static boolean dfs(int i, int j) {
        if (j == C - 1) {
            ans++;
            return true;
        }

        for (int d = 0; d < 3; d++) {
            int newi = i + di[d];
            int newj = j + dj[d];
            if (newi >= 0 && newj >= 0 && newi < R && newj < C && map[newi][newj] == '.') {
                map[newi][newj] = 'X';
                if (dfs(newi, newj)) {
                    return true;
                }
            }
        }
        return false;
    }
}
