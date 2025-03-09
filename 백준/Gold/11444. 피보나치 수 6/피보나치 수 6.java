import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static final long mod = 1000000007;

    public static void main(String[] args) throws IOException {
        // f(n) = f(n-1) + f(n-2)
        // f(n+1) = f(n) + f(n-1)
        // [f(n+1), f(n)] = [f(n) + f(n-1), f(n)]

        // -> [f(n+1), f(n)] = [[1, 1], [1, 0]] * [f(n), f(n-1)]
        // -> [f(n), f(n-1)] = [[1, 1], [1, 0]]^(n-1) * [1, 0]

        long n = Long.parseLong(br.readLine());
        long ans = fibo(n);

        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
    }

    public static long fibo(long n) {
        if (n == 0) {
            return 0;
        }

        long[][] matrix = {{1, 1}, {1, 0}};
        long[][] result = power(matrix, n - 1);

        return result[0][0];
    }

    public static long[][] power(long[][] matrix, long n) {

        if (n == 0) {
            long[][] identity = new long[2][2];
            identity[0][0] = 1;
            identity[1][1] = 1;
            return identity;
        }

        if (n == 1) {
            return matrix;
        }

        if (n % 2 == 0) {
            long[][] mid = power(matrix, n / 2);
            return square(mid, mid);
        } else {
            long[][] half = power(matrix, n / 2);
            long[][] halfSquared = square(half, half);
            return square(matrix, halfSquared);
        }
    }

    public static long[][] square(long[][] A, long[][] B) {
        long[][] C = new long[2][2];

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    C[i][j] = (C[i][j] + A[i][k] * B[k][j]) % mod;
                }
            }
        }
        return C;
    }

}
