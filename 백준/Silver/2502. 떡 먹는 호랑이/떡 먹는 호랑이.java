import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int D, K;

    public static void main(String[] args) throws IOException {
        String[] in = br.readLine().split(" ");
        D = Integer.parseInt(in[0]); // 할머니가 넘어온 날
        K = Integer.parseInt(in[1]); // 그 날 호랑이에게 준 떡의 개수

        for (int d1 = 1; d1 < K; d1++) {

            for (int d2 = d1; d2 < K; d2++) {
                int[] dp = new int[D + 1];
                dp[1] = d1;
                dp[2] = d2;
                if (fibonacci(3, dp)) {
                    System.out.println(d1);
                    System.out.println(d2);
                    return;
                }
            }
        }
    }

    public static boolean fibonacci(int day, int[] dp) {
        if (day > D) {
            if (dp[D] == K) {
                return true;
            }
            return false;
        }

        dp[day] = dp[day - 1] + dp[day - 2];
        return fibonacci(day + 1, dp);
    }
}