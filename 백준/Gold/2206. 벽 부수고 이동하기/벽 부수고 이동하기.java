

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
        Queue<Point> queue = new ArrayDeque<>();
        queue.offer(new Point(0, 0, 1, 0));
        visited[0][0][0] = true;
        while (!queue.isEmpty()) {
            Point curr = queue.poll();
            if (curr.y == n - 1 && curr.x == m - 1) {
                ans = curr.dist;
                return ans;
            }
            for (int d = 0; d < 4; d++) {
                int newY = curr.y + dy[d];
                int newX = curr.x + dx[d];
                if (newY >= 0 && newX >= 0 && newY < n && newX < m) {

                    //블록을 안뿌쉈다면 그냥 가거나 뿌수거나.
                    //블록을 뿌순 상태라면 그냥 가야함
                    if (!visited[newY][newX][curr.isDestroyed] && map[newY][newX] == 0) {
                        visited[newY][newX][curr.isDestroyed] = true;
                        queue.offer(new Point(newY, newX, curr.dist + 1, curr.isDestroyed));
                    }

                    if (curr.isDestroyed == 0) {
                        if (map[newY][newX] == 1 && !visited[newY][newX][curr.isDestroyed]) {
                            visited[newY][newX][1] = true;
                            queue.offer(new Point(newY, newX, curr.dist + 1, 1));
                        }
                    }

                }
            }
        }

        return ans;
    }

    static class Point {

        int y, x, dist;
        int isDestroyed;

        public Point(int y, int x, int dist, int isDestroyed) {
            this.y = y;
            this.x = x;
            this.dist = dist;
            this.isDestroyed = isDestroyed;
        }
    }
}
