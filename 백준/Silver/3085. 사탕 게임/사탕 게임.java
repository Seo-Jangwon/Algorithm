import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n;
    static int ans;
    static String[][] arr;

    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(br.readLine());

        ans = 0;
        arr = new String[n][n];

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                arr[i][j] = input[j];
            }
        }// end for

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                // 1. 아래로 뒤집기
                int newy = i + 1;
                int newx = j;

                if (newy < n) {
                    String s = arr[i][j];
                    String s1 = arr[newy][newx];
                    arr[i][j] = s1;
                    arr[newy][newx] = s;

                    // 2. 연속되는 곳 검사
                    check();

                    // 3. 원상복구
                    arr[newy][newx] = s1;
                    arr[i][j] = s;
                }

                //----------

                // 1. 우측으로 뒤집기
                newy = i;
                newx = j + 1;

                if (newx < n) {
                    String s = arr[i][j];
                    String s1 = arr[newy][newx];
                    arr[i][j] = s1;
                    arr[newy][newx] = s;

                    // 2. 연속되는 곳 검사
                    check();

                    // 3. 원상복구
                    arr[newy][newx] = s1;
                    arr[i][j] = s;
                }

            }
        }// end for

        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();

    }// end main

    static void check() {
        for (int i = 0; i < n; i++) {
            int count = 1; // 현재 연속된 개수
            for (int j = 1; j < n; j++) {
                if (arr[i][j].equals(arr[i][j - 1])) {
                    count++;
                } else {
                    ans = Math.max(ans, count);
                    count = 1;
                }
            }
            ans = Math.max(ans, count);
        }

        for (int j = 0; j < n; j++) {
            int count = 1;
            for (int i = 1; i < n; i++) {
                if (arr[i][j].equals(arr[i - 1][j])) {
                    count++;
                } else {
                    ans = Math.max(ans, count);
                    count = 1;
                }
            }
            ans = Math.max(ans, count);
        }
    }// end check function

}
