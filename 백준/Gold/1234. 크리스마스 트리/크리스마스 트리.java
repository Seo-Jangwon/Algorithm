import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");

        int n, red, green, blue;

        n = Integer.parseInt(input[0]);
        red = Integer.parseInt(input[1]);
        green = Integer.parseInt(input[2]);
        blue = Integer.parseInt(input[3]);

        int totalRequired = n * (n + 1) / 2;

        if (red + green + blue < totalRequired) {
            bw.write("0");
            bw.flush();
            bw.close();
            return;
        }

        long ans = 0;

        if (red >= 1) {
            ans += dfs(2, red - 1, green, blue, n);
        }

        if (green >= 1) {
            ans += dfs(2, red, green - 1, blue, n);
        }

        if (blue >= 1) {
            ans += dfs(2, red, green, blue - 1, n);
        }

        bw.write("" + ans);
        bw.flush();
        bw.close();

    }

    static long dfs(int dep, int r, int g, int b, int n) {
        if (dep > n) {
            return 1;
        }

        long ways = 0;

        // 한 가지 색만 사용
        if (r >= dep) {
            ways += dfs(dep + 1, r - dep, g, b, n);
        }
        if (g >= dep) {
            ways += dfs(dep + 1, r, g - dep, b, n);
        }
        if (b >= dep) {
            ways += dfs(dep + 1, r, g, b - dep, n);
        }

        // 두 가지 색 사용
        if (dep % 2 == 0) {
            int half = dep / 2;
            // 빨강 + 초록
            if (r >= half && g >= half) {
                ways += combination(dep, half) * dfs(dep + 1, r - half, g - half, b, n);
            }
            // 빨강 + 파랑
            if (r >= half && b >= half) {
                ways += combination(dep, half) * dfs(dep + 1, r - half, g, b - half, n);
            }
            // 초록 + 파랑
            if (g >= half && b >= half) {
                ways += combination(dep, half) * dfs(dep + 1, r, g - half, b - half, n);
            }
        }

        // 세 가지 색 사용
        if (dep % 3 == 0) {
            int third = dep / 3;
            if (r >= third && g >= third && b >= third) {
                ways += threeways(dep, third, third) *
                    dfs(dep + 1, r - third, g - third, b - third, n);
            }
        }

        return ways;

    }

    static long threeways(int n, int r1, int r2) {
        return combination(n, r1) * combination(n - r1, r2);
    }

    static long combination(int n, int r) {
        if (r > n - r) {
            r = n - r;
        }

        long result = 1;
        for (int i = 0; i < r; i++) {
            result *= (n - i);
            result /= (i + 1);
        }
        return result;
    }

}
