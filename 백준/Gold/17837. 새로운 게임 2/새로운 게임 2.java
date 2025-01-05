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

    static int n, k;
    static Point[][] arr; //나중에 리스트로 바꾸던지....
    static List<Piece> pieces;

    static int[] dy = {0, 0, -1, 1}; // 우, 좌, 상, 하
    static int[] dx = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {

        String[] in1 = br.readLine().split(" ");
        n = Integer.parseInt(in1[0]);
        k = Integer.parseInt(in1[1]);

        arr = new Point[n][n];
        pieces = new ArrayList<>();

        for (int i = 0; i < n; i++) { // 체스판 정보 입력
            String[] in2 = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = new Point(i, j, Integer.parseInt(in2[j]));
            }
        }

        for (int i = 0; i < k; i++) {
            String[] in3 = br.readLine().split(" ");
            int y = Integer.parseInt(in3[0]) - 1;
            int x = Integer.parseInt(in3[1]) - 1;
            int dir = Integer.parseInt(in3[2]) - 1;

            Piece piece = new Piece(i, y, x, dir);
            pieces.add(piece);
            arr[y][x].pieces.add(piece);
        }

        int ans = -1;
        int count = 0;
        while (count <= 1000) {//게임 진행
            if (checkEnd()) { //종료조건. 종료조건 확인함수가 true
                ans = count;
                break;
            }//end exit condition

            for (int i = 0; i < k; i++) {

                // 1. 말의 번호로 말 찾아서
                Piece piece = pieces.get(i); //이동할 말

                // 2. 배열 인덱스 번호 확인 후
                int idxNum = piece.indexNum;
                int idxY = idxNum / n;
                int idxX = idxNum % n;

                // 3. 배열 인덱스에서 위에 말들을 임시배열로 옮기고 실린말들 제거
                Point point = arr[idxY][idxX];
                List<Piece> temp;// 말 실린것들

                // 3-1. 말 저장된 위치 찾아서
                int firstIdx = 0;
                for (Piece p : point.pieces) { //말이 저장된 곳 찾아서
                    if (p.num == i) {
                        break;
                    }
                    firstIdx++;
                }

                // 3-2. 임시 배열로 윗쪽말들 옮기고
                temp = new ArrayList<>(
                    point.pieces.subList(firstIdx, point.pieces.size()));// 임시 배열로 옮기고

                // 3-3. 말들 제거
                point.pieces.removeAll(temp);

                // 4. 임시 배열의 말들을 다른 인덱스로 조건에 맞게 이동
                changePoint(piece, idxY, idxX, temp);

                if (checkEnd()) { //종료조건. 종료조건 확인함수가 true
                    ans = count;
                    break;
                }//end exit condition
            }
            count++;
        }// end while

        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
    }

    static void changePoint(Piece piece, int idxY, int idxX, List<Piece> temp) {
        // 4. 임시 배열의 말들을 다음 인덱스로 조건에 맞게 이동
        //      조건 0: 흰 칸이라면 말들 그대로 이동
        //      조건 1: 빨간 칸이라면 말들 다 뒤집어서 기존 칸 뒤에 추가
        //      조건 3: 파란 칸이라면 반대로 이동하되 뒤에가 파란 칸이거나 막히는 곳이면 갇힘
        int dir = piece.dir;
        int newY = idxY + dy[dir];
        int newX = idxX + dx[dir];

        // 체스판 밖으로 나가는 경우 또는 파란색 칸인 경우
        if (newY < 0 || newY >= n || newX < 0 || newX >= n ||
            (newY >= 0 && newY < n && newX >= 0 && newX < n && arr[newY][newX].color == 2)) {

            // 방향 전환
            piece.dir = dir ^ 1;
            int revY = idxY + dy[piece.dir];
            int revX = idxX + dx[piece.dir];

            // 반대 방향도 체스판을 벗어나거나 파란색인 경우
            if (revY < 0 || revY >= n || revX < 0 || revX >= n ||
                (revY >= 0 && revY < n && revX >= 0 && revX < n && arr[revY][revX].color == 2)) {
                Point point = arr[idxY][idxX];
                point.pieces.addAll(temp);
                for (Piece p : temp) {
                    p.indexNum = point.indexNum;
                }
                return;
            }

            // 반대 방향이 가능한 경우
            Point newPoint = arr[revY][revX];
            if (newPoint.color == 0) {
                for (Piece p : temp) {
                    p.indexNum = newPoint.indexNum;
                    newPoint.pieces.add(p);
                }
            } else if (newPoint.color == 1) {
                for (int i = temp.size() - 1; i >= 0; i--) {
                    Piece p = temp.get(i);
                    p.indexNum = newPoint.indexNum;
                    newPoint.pieces.add(p);
                }
            }
            return;
        }

        Point newPoint = arr[newY][newX];
        int newPointColor = newPoint.color;
        switch (newPointColor) {
            case 0: // 흰 칸
                for (Piece p : temp) {
                    p.indexNum = newPoint.indexNum;
                    newPoint.pieces.add(p);
                }
                break;
            case 1: // 빨간 칸
                for (int i = temp.size() - 1; i >= 0; i--) {
                    Piece p = temp.get(i);
                    p.indexNum = newPoint.indexNum;
                    newPoint.pieces.add(p);
                }
                break;
        }

    }

    /**
     * 종료조건 확인 함수. 배열 돌며 말 사이즈가 4 이상 되는 곳이 있다면 참 반환 참: 게임 종료 거짓: 게임 계속
     */
    static boolean checkEnd() {
        // 말이 네 개 이상 쌓이면
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j].pieces.size() >= 4) {
                    return true;
                }
            }
        }
        return false;
    }

    static class Point {// 위치에 대한 정보 저장
        List<Piece> pieces; // 이 포인트에 있는 말들
        int indexNum; // 인덱스 번호
        int color; // 색상 번호, 0:흰, 1: 빨, 2: 파

        public Point(int y, int x, int color) {
            this.pieces = new ArrayList<>();
            this.indexNum = n * y + x;
            this.color = color;
        }
    }

    static class Piece { //말 정보 저장

        int num; // 말 번호
        int indexNum; //인덱스 번호
        int dir; // 이동 방향

        public Piece(int num, int y, int x, int dir) {
            this.num = num;
            this.indexNum = n * y + x;
            this.dir = dir;
        }
    }

}
