import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        String[] in1 = br.readLine().split("");
        String[] in2 = br.readLine().split("");

        int N = in1.length;
        char[] apple = new char[N];
        char[] lover = new char[N];

        for (int i = 0; i < N; i++) {
            apple[i] = in1[i].charAt(0);
            lover[i] = in2[i].charAt(0);
        }

        char[] company = new char[N];
        Arrays.sort(apple);
        Arrays.sort(lover);

        int count = 0;

        int start = 0;// 정답용 첨부터 채울 인덱스
        int end = N - 1; // 정답용 뒤에서부터 채울 인덱스

        int idxAppleFirst = 0;
        int idxAppleLast = (N / 2 + N % 2) - 1;

        int idxLoverFirst = idxAppleLast + 1;
        int idxLoverLast = N - 1;

        while (count < N) {
            if (count % 2 == 0) { // 사과 차례
                if (apple[idxAppleFirst] >= lover[idxLoverLast]) { // 사과의 가장 작은 게 러버의 가장 큰 것 이상이면
                    company[end--] = apple[idxAppleLast--];
                } else {
                    company[start++] = apple[idxAppleFirst++];
                }
            } else { // 러버 차례
                if (lover[idxLoverLast] <= apple[idxAppleFirst]) { // 러버의 가장 큰 문자가 애플의 가장 작은 문자 이하면
                    company[end--] = lover[idxLoverFirst++];
                } else {
                    company[start++] = lover[idxLoverLast--];
                }
            }
            count++;
        }

        StringBuilder ans = new StringBuilder();
        for (char c : company) {
            ans.append(c);
        }

        bw.write(ans.toString());
        bw.flush();
        bw.close();

    }
}
