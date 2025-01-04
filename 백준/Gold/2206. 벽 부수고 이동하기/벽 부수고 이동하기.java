

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static int n, m;
    static int[][] map;
    static boolean[][][] visited;

    public static void main(String[] args) throws IOException {

        String[] in1 = br.readLine().split(" ");

        n = Integer.parseInt(in1[0]);
        m = Integer.parseInt(in1[1]);
        map = new int[n][m];
        visited = new boolean[n][m][2];

        for (int i = 0; i < n; i++) {
            String[] in2 = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(in2[j]);
            }
        }

        int ans = bfs();

        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();

    }

    static int bfs() {
        int ans = -1;
        Point p = new Point(0, 0, 1, 0);
        Queue<Point> q = new ArrayDeque<>();
        q.add(p);
        visited[0][0][0] = true;

        while (!q.isEmpty()) {
            Point curr = q.poll();
            if (curr.y == n - 1 && curr.x == m - 1) {
                ans = curr.dist;
                return ans;
            }
            for (int d = 0; d < 4; d++) {
                int ny = curr.y + dy[d];
                int nx = curr.x + dx[d];

                if (ny >= 0 && nx >= 0 && ny < n && nx < m) {

                    if (!visited[ny][nx][curr.destroyed] && map[ny][nx] == 0) {
                        visited[ny][nx][curr.destroyed] = true;
                        q.add(new Point(ny, nx, curr.dist + 1, curr.destroyed));

                    }
                    if (curr.destroyed == 0 && !visited[ny][nx][curr.destroyed]
                        && map[ny][nx] == 1) {
                        visited[ny][nx][1] = true;
                        q.add(new Point(ny, nx, curr.dist + 1, 1));
                    }
                }
            }
        }
        return ans;
    }

    static class Point {

        int y, x;
        int dist;
        int destroyed;

        public Point(int y, int x, int dist, int destroyed) {
            this.y = y;
            this.x = x;
            this.dist = dist;
            this.destroyed = destroyed;
        }
    }
}
