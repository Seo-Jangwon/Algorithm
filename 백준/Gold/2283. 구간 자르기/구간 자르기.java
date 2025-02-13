import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n, k;
    static int realEnd;
    static int[] line;

    public static void main(String[] args) throws IOException {
        String[] in1 = br.readLine().split(" ");
        n = Integer.parseInt(in1[0]);
        k = Integer.parseInt(in1[1]);

        line = new int[1_000_002];
        realEnd = 0;

        for (int i = 0; i < n; i++) {
            String[] in2 = br.readLine().split(" ");
            int s = Integer.parseInt(in2[0]);
            int e = Integer.parseInt(in2[1]);

            line[s] += 1;  // 구간 시작
            line[e] -= 1;  // 구간 끝

            realEnd = Math.max(realEnd, e);
        }

        // 누적합 
        for (int i = 1; i <= realEnd; i++) {
            line[i] += line[i - 1];
        }

        // 투 포인터
        int sum = 0, A = 0, B = 0;
        int start = 0, end = 0;
        boolean found = false;

        while (end <= realEnd) {
            if (sum < k) {
                sum += line[end];
                end++;
            } else if (sum > k) {
                sum -= line[start];
                start++;
            } else { // sum == K
                if (!found || (start < A) || (start == A && end < B)) {
                    A = start;
                    B = end;
                    found = true;
                }
                sum -= line[start];
                start++;
            }
        }

        if (!found) {
            bw.write("0 0");
        } else {
            bw.write(A + " " + B);
        }
        bw.flush();
        bw.close();
    }
}

