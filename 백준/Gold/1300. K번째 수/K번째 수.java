import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n, k;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        int start = 1; // 가능한 최소값(b[0])
        int end = k; // 가능한 최대값(b[머시기])

        while (start <= end) {
            int mid = (start + end) / 2;
            int count = 0; // mid 보다 작은 수 개수

            for (int i = 1; i <= n; i++) {
                count += Math.min(mid / i, n); // 2중 for문 대신 그냥 mid를 n으로 나누기. mid보다 작은 수 갱신
            }

            if (count >= k) {// k개 이상 들어있다면
                // 범위 줄이기
                end = mid - 1;
            } else {// k개 보다 적게 들어있다면
                start = mid + 1; // 범위 늘리기
            }
        }
        bw.write(String.valueOf(start));
        bw.flush();
        bw.close();
    }
}
