

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

    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    static int n, k;
    static int rowEnd, colEnd;
    static Point[][] arr;

    public static void main(String[] args) throws IOException {

        String[] in1 = br.readLine().split(" ");
        n = Integer.parseInt(in1[0]);
        k = Integer.parseInt(in1[1]);

        arr = new Point[n][n];
        String[] in2 = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            arr[0][i] = new Point(Integer.parseInt(in2[i]));
        }// 입력 끝

        int count = 0;
        while (true) {

            int max = 0;
            int min = Integer.MAX_VALUE;

            firstMethod();
            secondMethod();
            thirdMethod();
            fourthMethod();
            fifthMethod();
            thirdMethod();
            fourthMethod();

            for (int i = 0; i < n; i++) {
                int val = arr[0][i].val;
                if (max < val) {
                    max = val;
                }
                if (min > val) {
                    min = val;
                }
            }
            count++;

            if (max - min <= k) {
                break;
            }

        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();

    }//end main

    /**
     * 1. 물고기의 수가 최소인 어항 모두에 한 마리씩 넣는다.
     */
    static void firstMethod() {
        int min = Integer.MAX_VALUE;

        // 최소값 찾기
        for (int i = 0; i < n; i++) {
            int val = arr[0][i].val;
            if (val < min) {
                min = val;
            }
        }// end for

        // 최소값들에 1씩 더하기
        for (int i = 0; i < n; i++) {
            if (arr[0][i].val == min) {
                arr[0][i].val += 1;
            }
        }

    }// end method

    /**
     * 2. 이제 어항을 쌓는다.
     */
    static void secondMethod() {

        int idx = 0;
        int startIdx = 0;// 옮기는 지점이 시작하는 좌표
        int bottomLength = n; // 바닥 길이
        while (bottomLength > 0) {
            int height = (idx + 3) / 2;
            int width = (idx + 2) / 2;

            bottomLength -= width; //바닥 길이 width만큼 줄어든다면
            if (bottomLength - height < 0) {// 옮길 수 있는지 확인하고
                break;
            }

            int tempIdx = 0;
            Point[][] temp = new Point[width][height];

            // 임시 배열로 옮기기
            for (int i = startIdx + width - 1; i >= startIdx; i--) {
                for (int j = 0; j < height; j++) {
                    int y = tempIdx / height;
                    int x = tempIdx % height;
                    temp[y][x] = arr[j][i];
                    arr[j][i] = null;
                    tempIdx++;
                }
            }

            for (int i = 0; i < width; i++) {
                for (int j = 0; j < height; j++) {
                    arr[i + 1][j + width + startIdx] = temp[i][j];
                }
            }

            startIdx += width;
//            printArr();

            idx++;

        }

    }// end method

    /**
     * 3. 공중 부양 작업이 모두 끝나면, 어항에 있는 물고기의 수를 조절한다. 모든 인접한 두 어항에 대해서, 물고기 수의 차이를 구한다. 이 차이를 5로 나눈 몫을
     * d라고 하자. d가 0보다 크면, 두 어항 중 물고기의 수가 많은 곳에 있는 물고기 d 마리를 적은 곳에 있는 곳으로 보낸다.
     */
    static void thirdMethod() {

        int[][] tempArr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] != null) {
                    for (int d = 0; d < 4; d++) {
                        int ny = i + dy[d];
                        int nx = j + dx[d];
                        if (ny >= 0 && ny < n && nx >= 0 && nx < n && arr[ny][nx] != null) {
                            int diff = arr[i][j].val - arr[ny][nx].val;
                            diff /= 5;
                            if (diff > 0) {
                                tempArr[ny][nx] += diff;
                                tempArr[i][j] -= diff;
                            }
//                            else {
//                                tempArr[ny][nx] -= diff;
//                                tempArr[i][j] += diff;
//                            }
                        }
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] != null) {
                    arr[i][j].val += tempArr[i][j];
                }
            }
        }

//        printArr();
    }// end regulatefish

    /**
     * 4. 어항을 바닥에 일렬로 놓아야 한다. 가장 왼쪽에 있는 어항부터, 그리고 아래에 있는 어항부터 가장 위에 있는 어항까지 순서대로 바닥에 놓아야 한다.
     */
    static void fourthMethod() {
        List<Integer> points = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (arr[0][i] != null) {
                for (int j = 0; j < n; j++) {
                    if (arr[j][i] == null) {
                        break;
                    }
                    points.add(arr[j][i].val);
                    arr[j][i] = null;
                }// end for
            }// end if not null
        }// end for

        int idx = 0;
        for (Integer p : points) {
            arr[0][idx] = new Point(p);
            idx++;
        }
//        printArr();
    }

    /**
     * 5. 공중 부양 작업을 해야 한다. 이번에는 가운데를 중심으로 왼쪽 N/2개를 공중 부양시켜 전체를 시계 방향으로 180도 회전 시킨 다음, 오른쪽 N/2개의 위에
     * 놓아야 한다. 이 작업은 두 번 반복해야한다. 두 번 반복하면 바닥에 있는 어항의 수는 N/4개가 된다.
     */
    static void fifthMethod() {

        ArrayList<ArrayList<Integer>> tempList = new ArrayList<>();

        tempList.add(new ArrayList<>());
        tempList.add(new ArrayList<>());
        tempList.add(new ArrayList<>());
        tempList.add(new ArrayList<>());

        for (int i = 0; i < n; i++) {
            tempList.get(0).add(arr[0][i].val);
            arr[0][i] = null;
        }
        for (int i = 0; i < n / 2; i++) {
            tempList.get(1).add(tempList.get(0).remove((n / 2) - 1 - i));
        }
        for (int i = 0; i < n / 4; i++) {
            tempList.get(2).add(tempList.get(1).remove((n / 4) - 1 - i));
            tempList.get(3).add(tempList.get(0).remove((n / 4) - 1 - i));
        }

        for (int i = 0; i < tempList.size(); i++) {
            for (int j = 0; j < tempList.get(i).size(); j++) {
                arr[i][j] = new Point(tempList.get(i).get(j));
            }
        }
//        printArr();
    }

//    static void printArr() {
//        System.out.println("================");
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                if (arr[i][j] == null) {
//                    System.out.print("." + "\t");
//                } else {
//                    System.out.print(arr[i][j].val + "\t");
//                }
//            }
//            System.out.println();
//        }
//        System.out.println("================");
//    }

    static class Point {

        int val;
        int right, left, up, down;

        public Point(int val) {
            this.val = val;
        }

        Point(int val, int right, int left, int up, int down) {
            this.val = val;
            this.right = right;
            this.left = left;
            this.up = up;
            this.down = down;
        }
    }

}
