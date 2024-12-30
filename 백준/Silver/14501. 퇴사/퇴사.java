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
    static int[][] arr;

    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(br.readLine());

        arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(input[0]);// 시간
            arr[i][1] = Integer.parseInt(input[1]);// 금액
        }

        ans = 0;
        dfs(0, 0, 0);

        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();

    }


    /**
     * @param nextDate: 다음 날짜
     * @param nowM:     지금까지 돈
     * @param toSum:    다음날짜 강의하면 받을 돈
     */
    static void dfs(int nextDate, int nowM, int toSum) {
//        System.out.println("next date: " + nextDate + " now m: " + nowM + " toSum: " + toSum);

        if (nextDate >= n) {
//            System.out.println("종료조건 들어옴");
            if (nextDate == n) { // 다음 날짜까지 상담했을 때 딱 맞아떨어지면
//                System.out.println("next date == n. n: " + nextDate);
                nowM += toSum;//다음 돈까지 받음
            }
            if (nowM > ans) {
                ans = nowM;
//                System.out.println("ans 갱신!! ans: " + ans);
            }
            return;
        }

        for (int i = nextDate; i < n; i++) {
            dfs(i + arr[i][0], nowM + toSum, arr[i][1]);
        }
    }
}
