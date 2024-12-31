import static java.lang.System.exit;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    // 북, 동, 남, 서 순서
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static int ans;
    static int n, m;
    static int r, c, d;
    static int[][] arr; // 청소안함: 0, 벽: 1, 청소함: 2

    public static void main(String[] args) throws IOException {

        String[] in1 = br.readLine().split(" ");

        n = Integer.parseInt(in1[0]);
        m = Integer.parseInt(in1[1]);

        String[] in2 = br.readLine().split(" ");
        r = Integer.parseInt(in2[0]);// 로봇 칸 y좌표
        c = Integer.parseInt(in2[1]);// 로봇 칸 x좌표
        d = Integer.parseInt(in2[2]);// 로봇이 바라보는 방향

        Point pos = new Point(r, c, d);

        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] in3 = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(in3[j]);
            }
        }

//        System.out.println("dfs 호출. y: " + r + " x: " + c + " dir: " + d);
        if (arr[r][c] != 1) {
            dfs(pos, 1);
        }

    }

    static void dfs(Point pos, int cleaned) throws IOException {
//        System.out.println(
//            "1. dfs 호출. y: " + pos.y + " x: " + pos.x + " dir: " + pos.dir + " cleaned: "
//                + cleaned);
        arr[pos.y][pos.x] = 2;// 청소함

        int nowDir = pos.dir;
        for (int d = nowDir + 3; d >= nowDir; d--) {
            int dir = (d + 4) % 4;

            int newy = pos.y + dy[dir];
            int newx = pos.x + dx[dir];

            // 바라보는 곳이 유효한 좌표
            if (newy >= 0 && newy < n && newx >= 0 && newx < m) {

                // 청소 안한 곳이라면
                if (arr[newy][newx] == 0) {
//                    System.out.println(
//                        "2. 청소 해야함. newy: " + newy + " newx: " + newx + " dir: " + dir);
                    dfs(new Point(newy, newx, dir), cleaned + 1);// 한칸 들어가기
                    break;
                }

            }
        }

        // 청소할 곳 없다면

//        System.out.println("3. 청소할 곳 없음");
        int newDir = (nowDir + 2) % 4;
        int newnewy = pos.y + dy[newDir];
        int newnewx = pos.x + dx[newDir];
        if (newnewy >= 0 && newnewy < n && newnewx >= 0 && newnewx < m) {
            // 바라보는 방향 유지하고 한 칸 후진
            if (arr[newnewy][newnewx] != 1) {
//                System.out.println(
//                    "  3.1. 바라보는 방향 유지하고 한 칸 후진. newy: " + pos.y + " newx: " + pos.x + " dir: "
//                        + pos.dir);
                dfs(new Point(newnewy, newnewx, pos.dir), cleaned);
            }

            //뒤에가 벽이라면 작동 끝
            else {
//                System.out.println("  3.2. 벽 만남. cleaned: " + cleaned);
                ans = cleaned;
                bw.write(String.valueOf(ans));
                bw.flush();
                bw.close();
                exit(0);
            }
        }

    }

    static class Point {

        int y, x, dir;

        public Point() {
        }

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }

        public Point(int y, int x, int dir) {
            this.y = y;
            this.x = x;
            this.dir = dir;
        }
    }
}
