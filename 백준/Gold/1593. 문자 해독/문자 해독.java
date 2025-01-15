import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int g; // 찾으려는 문자열 W의 길이
        int s; // 긴 문자열 길이

        String[] in1 = br.readLine().split(" ");
        g = Integer.parseInt(in1[0]);
        s = Integer.parseInt(in1[1]);

        String strW;
        String strS;
        strW = br.readLine(); // 찾으려는 문자열 배열
        strS = br.readLine(); // 긴 문자열

        HashMap<Character, Integer> wCount = new HashMap<>(); // w 문자 구성 저장
        HashMap<Character, Integer> window = new HashMap<>(); // 슬라이딩 윈도우
        for (int i = 0; i < g; i++) {
            wCount.put(strW.charAt(i), wCount.getOrDefault(strW.charAt(i), 0) + 1);
            window.put(strS.charAt(i), window.getOrDefault(strS.charAt(i), 0) + 1);
        }

        int ans = 0;
        if (wCount.equals(window)) {
            ans++;
        }

        for (int i = g; i < s; i++) {
            char oldChar = strS.charAt(i - g);
            window.put(oldChar, window.getOrDefault(oldChar, 0) - 1);
            if (window.get(oldChar) == 0) {
                window.remove(oldChar);
            }

            char newChar = strS.charAt(i);
            window.put(newChar, window.getOrDefault(newChar, 0) + 1);

            if (window.equals(wCount)) {
                ans++;
            }

        }

        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();

    }
}
