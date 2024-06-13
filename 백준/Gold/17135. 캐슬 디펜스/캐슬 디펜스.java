import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int n, m, d, max;
    static int[][] map;

    public static void main(String[] args) throws NumberFormatException, IOException {
        String[] in1 = br.readLine().split(" ");
        n = Integer.parseInt(in1[0]);
        m = Integer.parseInt(in1[1]);
        d = Integer.parseInt(in1[2]);

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] in2 = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(in2[j]);
            }
        }

        max = 0;
        dfs(0, 0, new int[3]);

        System.out.println(max);
    }

    public static void dfs(int start, int cnt, int[] archers) {
        if (cnt == 3) {
            int[][] newMap = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    newMap[i][j] = map[i][j];
                }
            }

            int result = simulate(newMap, archers);
            if (max < result) {
                max = result;
            }
            return;
        }

        for (int i = start; i < m; i++) {
            archers[cnt] = i;
            dfs(i + 1, cnt + 1, archers);
        }
    }

    public static int simulate(int[][] newMap, int[] archers) {
        int killCount = 0;

        while (true) {
            Set<Point> targets = new HashSet<>();

            for (int archer : archers) {
                Point target = findTarget(newMap, archer);
                if (target != null) {
                    targets.add(target);
                }
            }

            for (Point target : targets) {
                if (newMap[target.x][target.y] == 1) {
                    newMap[target.x][target.y] = 0;
                    killCount++;
                }
            }

            boolean allClear = true;
            for (int i = n - 1; i >= 0; i--) {
                for (int j = 0; j < m; j++) {
                    if (newMap[i][j] == 1) {
                        allClear = false;
                        if (i == n - 1) {
                            newMap[i][j] = 0;
                        } else {
                            newMap[i + 1][j] = newMap[i][j];
                            newMap[i][j] = 0;
                        }
                    }
                }
            }

            if (allClear) {
                break;
            }
        }

        return killCount;
    }

    public static Point findTarget(int[][] map, int archer) {
        Point target = null;
        int minDistance = Integer.MAX_VALUE;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1) {
                    int distance = Math.abs(n - i) + Math.abs(archer - j);
                    if (distance <= d) {
                        if (distance < minDistance || (distance == minDistance && j < target.y)) {
                            minDistance = distance;
                            target = new Point(i, j);
                        }
                    }
                }
            }
        }

        return target;
    }

    public static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}