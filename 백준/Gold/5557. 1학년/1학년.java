import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int arr[];
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];

        String input[] = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        long dp[][] = new long[n][21];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], 0);
        }
        dp[0][arr[0]] = 1;

        for (int i = 1; i < n-1; i++) {
            for (int j = 0; j <= 20; j++) {
                if(dp[i-1][j] > 0){
                    int plus=j+arr[i];
                    int minus=j-arr[i];
                    if(plus>=0&&plus<=20){
                        dp[i][plus]+=dp[i-1][j];
                    }
                    if(minus>=0&&minus<=20){
                        dp[i][minus]+=dp[i-1][j];
                    }
                }
            }
        }
        System.out.println(dp[n-2][arr[n-1]]);
    }
}
