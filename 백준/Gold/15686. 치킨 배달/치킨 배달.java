import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int ans;
    static int n, m;

    static List<Point> chicken;
    static List<Point> choosedList;
    static List<Point> house;

    public static void main(String[] args) throws IOException {

        String[] in1 = br.readLine().split(" ");
        n = Integer.parseInt(in1[0]);
        m = Integer.parseInt(in1[1]);

        chicken = new ArrayList<>();
        choosedList = new ArrayList<>();
        house = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] in2 = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(in2[j]);
                if (num == 1) {
                    house.add(new Point(i, j));
                } else if (num == 2) {
                    chicken.add(new Point(i, j));
                }
            }
        }// end for

        ans = Integer.MAX_VALUE;
        dfs(0, 0);

        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
    }

    static void dfs(int idx, int dep) {
        if (dep == m) {// 치킨거리 구해서 거리 최신화

            int totalChickenDistance = 0;// 전체 치킨 거리
            for (Point house : house) {// 치킨집 뽑아서

                int chickenDistPerHouse = Integer.MAX_VALUE;

                for (Point chicken : choosedList) {// 집마다 치킨거리 구하기
                    int dist = Math.abs(house.x - chicken.x) + Math.abs(house.y - chicken.y);

                    if (dist < chickenDistPerHouse) {
                        chickenDistPerHouse = dist;// 집마다 치킨거리
                    }
                }// end for house
                totalChickenDistance += chickenDistPerHouse;
            }

            if (ans > totalChickenDistance) {
                ans = totalChickenDistance;
            }
            return;
        }// end 종료조건

        for (int i = idx; i < chicken.size(); i++) {

            Point p = chicken.get(i);
            choosedList.add(p);
            dfs(i + 1, dep + 1);
            choosedList.remove(p);

        }// end for
    }

    static class Point {

        int y, x;

        Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }// end point
}
