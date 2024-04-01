import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int MOD = 1234567891;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tcCnt=  Integer.parseInt(br.readLine());

        fac[0] = 1;

        for (int t= 1; t<tcCnt+1; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            System.out.println("#" + t + " " + nCr(n, r));
        }
    }

    static long[] fac = new long[1000001];
    static int idx= 1;

    private static long nCr(int n, int r) {
        int upper = n + 1;
        for (int i = idx; i< upper; i++) {
            fac[i] = (fac[i-1] * i) % MOD;
            idx++;
        }

        long result = fac[n] * customPow((fac[n-r] * fac[r] % MOD), MOD-2) % MOD;

        return result;
    }

    private static long customPow(long n, int expo) {
        if (expo == 1)
            return n;

        long tmp = customPow(n, expo/2);

        if (expo % 2 == 1)
            return ((tmp * tmp) % MOD) * n % MOD;

        return (tmp * tmp) % MOD;
    }
}