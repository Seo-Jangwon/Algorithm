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

    static int T;
    static int M, N, K;
    static int[][] map;
    static boolean[][] visited;
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {

        T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {

            String[] in1 = br.readLine().split(" ");
            M = Integer.parseInt(in1[0]);
            N = Integer.parseInt(in1[1]);
            K = Integer.parseInt(in1[2]);

            map = new int[N][M];
            visited = new boolean[N][M];

            for (int i = 0; i < K; i++) {
                String[] in2 = br.readLine().split(" ");
                int X = Integer.parseInt(in2[0]);
                int Y = Integer.parseInt(in2[1]);

                map[Y][X] = 1;

            }

            int count = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {

                    Queue<Point> q = new ArrayDeque<>();
                    if (map[i][j] == 1 && !visited[i][j]) {
                        count++;
                        q.offer(new Point(i, j));

                        visited[i][j] = true;
                        while (!q.isEmpty()) {

                            Point curr = q.poll();

                            for (int d = 0; d < 4; d++) {

                                int nx = curr.x + dx[d];
                                int ny = curr.y + dy[d];

                                if (nx >= 0 && ny >= 0 && nx < M && ny < N && map[ny][nx] == 1
                                    && !visited[ny][nx]) {

                                    visited[ny][nx] = true;
                                    q.offer(new Point(ny, nx));

                                }

                            }

                        }
                    }

                }
            }

            bw.write(count + "\n");
            bw.flush();

        }
        bw.close();

    }

    public static class Point {

        int y;
        int x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }

    }
}
