import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n, m;
    static ArrayList<Integer>[] map;
    static char[] check;
    static int ans;
    static boolean cantCatch;
    static int lionCount;
    static int rabbitCount;

    public static void main(String[] args) throws IOException {

        String[] in = br.readLine().split(" ");
        n = Integer.parseInt(in[0]);
        m = Integer.parseInt(in[1]);

        cantCatch = true;
        rabbitCount = 0;
        lionCount = 0;

        ans = 0;
        map = new ArrayList[n + 1];
        check = new char[n + 1];

        for (int i = 1; i <= n; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            String[] in2 = br.readLine().split(" ");
            int u = Integer.parseInt(in2[0]);
            int v = Integer.parseInt(in2[1]);
            map[u].add(v);
            map[v].add(u);
        }

        for (int i = 1; i <= n; i++) {
            if (check[i] == '\u0000') {
                dfs(i, 'R');
            }
        }

        long answer = 0;
        if (cantCatch) {
            answer = (long) lionCount * rabbitCount * 2;
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();

    }

    static void dfs(int point, char c) {
        check[point] = c;

        if (c == 'R') {
            rabbitCount++;
        } else {
            lionCount++;
        }

        for (int next : map[point]) {
            if (check[next] == '\u0000') {
                dfs(next, c == 'R' ? 'L' : 'R');
            } else if (check[next] == c) {
                cantCatch = false;
            }
        }
    }
}
