import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int[][] map;
    static int[] dy = {-1, 0, 0, 1};
    static int[] dx = {0, -1, 1, 0};
    static Shark shark;

    public static void main(String[] args) throws NumberFormatException, IOException {
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        shark = null;
        for (int i = 0; i < N; i++) {
            String in = br.readLine();
            st = new StringTokenizer(in);
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    shark = new Shark(i, j, 0, 2);
                    map[i][j] = 0; // 초기 위치를 빈 칸으로 설정
                }
            }
        }

        System.out.println(play());
    }

    static int play() {
        int time = 0;
        while (true) {
            Point fish = findFish();
            if (fish == null) {
                return time;
            }

            // 물고기를 먹으러 가는 시간
            time += fish.dist;
            shark.y = fish.y;
            shark.x = fish.x;
            shark.eatenFish++;
            map[fish.y][fish.x] = 0;

            // 상어 크기 증가
            if (shark.eatenFish == shark.size) {
                shark.size++;
                shark.eatenFish = 0;
            }
        }
    }

    static Point findFish() {
        Queue<Point> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][N];
        PriorityQueue<Point> pq = new PriorityQueue<>();
        q.offer(new Point(shark.y, shark.x, 0));
        visited[shark.y][shark.x] = true;

        while (!q.isEmpty()) {
            Point curr = q.poll();

            for (int d = 0; d < 4; d++) {
                int ny = curr.y + dy[d];
                int nx = curr.x + dx[d];
                if (ny >= 0 && nx >= 0 && ny < N && nx < N && !visited[ny][nx]) {
                    if (map[ny][nx] <= shark.size) {
                        visited[ny][nx] = true;
                        q.offer(new Point(ny, nx, curr.dist + 1));
                        if (map[ny][nx] > 0 && map[ny][nx] < shark.size) {
                            pq.offer(new Point(ny, nx, curr.dist + 1));
                        }
                    }
                }
            }
        }
        return pq.poll();
    }

    static class Point implements Comparable<Point> {
        int y;
        int x;
        int dist;

        public Point(int y, int x, int dist) {
            this.y = y;
            this.x = x;
            this.dist = dist;
        }

        @Override
        public int compareTo(Point o) {
            if (this.dist == o.dist) {
                if (this.y == o.y) {
                    return this.x - o.x;
                }
                return this.y - o.y;
            }
            return this.dist - o.dist;
        }
    }

    static class Shark {
        int y;
        int x;
        int eatenFish;
        int size;

        public Shark(int y, int x, int eatenFish, int size) {
            this.y = y;
            this.x = x;
            this.eatenFish = eatenFish;
            this.size = size;
        }
    }
}