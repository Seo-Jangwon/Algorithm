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

    static int n, m;
    static int one, two, three;
    static int sharkY, sharkX;

    static int[][] arr;
    static int[][] indexMap; //시간 터져서 급히 배열 추가
    static List<MapPoint> maps; // 얘는 지도 역할
    static List<ValPoint> values; // 얘는 무슨 값이 저장되어있는지

    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    static int[] di; // 방향
    static int[] si; // 거리


    public static void main(String[] args) throws IOException {

        String[] in1 = br.readLine().split(" ");
        n = Integer.parseInt(in1[0]);
        m = Integer.parseInt(in1[1]);

        sharkY = sharkX = n / 2;

        maps = new ArrayList<>();
        values = new ArrayList<>();

        indexMap = new int[n][n];

        arr = new int[n][n];
        di = new int[m];
        si = new int[m];

        for (int i = 0; i < n; i++) {
            String[] in2 = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(in2[j]);
            }
        }

        for (int i = 0; i < m; i++) {
            String[] in3 = br.readLine().split(" ");
            di[i] = Integer.parseInt(in3[0]);
            si[i] = Integer.parseInt(in3[1]);
        }

        makeLine(); // 배열을 리스트로 담아서 펴기
//        print();

        for (int i = 0; i < m; i++) {
            throwBead(di[i], si[i]);
//            print();
            bomb();
//            print();
            changeBead();
//            print();
        }

        int ans = one + (2 * two) + (3 * three);
        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();

    }// end main func

    // 배열 펴기
    static void makeLine() {
        int[][] dirs = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};
        int y = sharkY, x = sharkX;

        int dir = 0; // 이동 거리
        int moveCount = 1; // 방향당 이동 거리
        int totalCount = 1; // 총 이동 거리
        int dirCount = 0; // 몇번 방향 바꿨는지(두 번 바꿀때 마다 이동 거리+1)
        while (totalCount < n * n) {

            for (int i = 0; i < moveCount; i++) {
                int newY = y + dirs[dir][0];
                int newX = x + dirs[dir][1];
                y = newY;
                x = newX;
                if (y >= 0 && y < n && x >= 0 && x < n) {
                    maps.add(new MapPoint(y, x));
                    values.add(new ValPoint(arr[y][x]));
                    indexMap[y][x] = maps.size() - 1; // 시간 터져서 급히 배열 추가
                    totalCount++;
                }
            }

            dir = (dir + 1) % 4;
            dirCount++;

            if (dirCount % 2 == 0) {
                moveCount++;
            }

        }//end while
    }//end makeLine function

    // 구슬 던지기
    static void throwBead(int d, int s) {
        int y = sharkY, x = sharkX;
        List<Integer> temp = new ArrayList<>();

        for (int i = 0; i < s; i++) {
            y += dy[d - 1];
            x += dx[d - 1];

            if (y >= 0 && y < n && x >= 0 && x < n && indexMap[y][x] < values.size()) {
                temp.add(indexMap[y][x]);
            }
        }

        temp.sort((a, b) -> b - a);
        for(int idx : temp) {
            if(idx < values.size()) {
                values.remove(idx);
            }
        }
    }

    // 구슬 터뜨리기
    static void bomb() {
        // 더 이상 폭발할 구슬이 없을 때까지 반복
        while (explodeBead()) {
            // 계속 폭발 진행
        }
    }

    // 구슬 터뜨리기(터뜨릴 게 있다면 부수고 true, 없다면 false)
    static boolean explodeBead() {
        boolean isExploded = false;
        int start = 0;
        boolean[] toRemove = new boolean[values.size()];

        while (start < values.size()) {
            int count = 1;
            int current = values.get(start).val;
            if (current == 0) {  // 0인 경우 스킵
                start++;
                continue;
            }

            int end = start + 1;
            while (end < values.size() && values.get(end).val == current) {
                count++;
                end++;
            }

            if (count >= 4) {
                isExploded = true;
                for (int i = start; i < end; i++) {
                    toRemove[i] = true;
                    countExlodeBead(values.get(i).val);
                }
            }
            start = end;
        }

        List<ValPoint> newValues = new ArrayList<>();
        for (int i = 0; i < values.size(); i++) {
            if (!toRemove[i]) {
                newValues.add(values.get(i));
            }
        }
        values = newValues;

        return isExploded;
    }

    static void countExlodeBead(int num) {
        switch (num) {
            case 1:
                one++;
                break;
            case 2:
                two++;
                break;
            case 3:
                three++;
                break;
        }
    }

    static void changeBead() {

        int start = 0;
        List<ValPoint> newValues = new ArrayList<>();

        while (start < values.size()) {
            int count = 1;
            int current = values.get(start).val;

            // 값이 0이면 스킵
            if(current == 0) {
                start++;
                continue;
            }

            // 연속된 같은 구슬 찾기
            int end = start + 1;
            while (end < values.size() && values.get(end).val == current) {
                count++;
                end++;
            }

            newValues.add(new ValPoint(count));
            newValues.add(new ValPoint(current));

            start = end;
        }

        values.clear();
        values.addAll(newValues);
        if (values.size() > maps.size()) {
            int diff = values.size() - maps.size();
            for (int i = 0; i < diff; i++) {
                values.remove(values.size() - 1);
            }
        }

    }

    static void print() {
        System.out.println("=====================================");
        for (ValPoint p : values) {
            System.out.print(p.toString());
        }
        System.out.println();
        for (MapPoint m : maps) {
            System.out.print(m.toString());
        }
        System.out.println("=====================================");
    }

    static class ValPoint {

        int val;

        ValPoint(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "ValPoint{" +
                "val=" + val +
                '}';
        }
    }

    static class MapPoint {

        int y, x;

        MapPoint(int y, int x) {
            this.y = y;
            this.x = x;
        }

        @Override
        public String toString() {
            return "mapPoint{" +
                " y=" + y +
                ", x=" + x +
                '}';
        }
    }

}
