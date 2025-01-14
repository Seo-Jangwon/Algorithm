import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static String str1, str2;
    static int[][] dp;

    public static void main(String[] args) throws IOException {

        str1 = br.readLine();
        str2 = br.readLine();

        dp = new int[str1.length()+1][str2.length()+1];

        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;  // 같으면 대각선+1
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);  // 다르면 위쪽,왼쪽 중 큰 값
                }
            }
        }

        bw.write(String.valueOf(dp[str1.length()][str2.length()]));
        bw.flush();
        bw.close();

    }

}
