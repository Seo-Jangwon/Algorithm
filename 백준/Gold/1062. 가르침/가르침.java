import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n, k;
    static int alphabet;

    public static void main(String[] args) throws IOException {
        String[] in1 = br.readLine().split(" ");
        n = Integer.parseInt(in1[0]);
        k = Integer.parseInt(in1[1]);

        alphabet = 0;
        alphabet |= (1 << (0)); // a
        alphabet |= (1 << ('n' - 'a')); // n
        alphabet |= (1 << ('t' - 'a')); // t
        alphabet |= (1 << ('i' - 'a')); // i
        alphabet |= (1 << ('c' - 'a')); // c

        int[] words = new int[n];

        // 여기 단어 입력 받기
        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            for (char c : word.toCharArray()) {
                words[i] |= (1 << (c - 'a'));
            }
        }

        if (k < 5) {
            bw.write("0");
            bw.flush();
            bw.close();
            return;
        }

        int answer = getAnswer(words);

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }

    private static int getAnswer(int[] words) {
        int answer = 0;
        for (int i = 0; i < (1 << 26); i++) {
            // 선택된 비트의 개수가 remain개인지
            if (Integer.bitCount(i) != k) {
                continue;
            }

            // 기본 알파벳(anta, tica)이 포함되어 있는지
            if ((i & alphabet) != alphabet) {
                continue;
            }

            // 이 조합으로 읽을 수 있는 단어의 개수 계산
            int count = 0;
            for (int word : words) {
                if ((word & i) == word) {  // 현재 알고 있는 알파벳으로 이 단어를 읽을 수 있는지
                    count++;
                }
            }
            answer = Math.max(answer, count);
        }
        return answer;
    }
}
