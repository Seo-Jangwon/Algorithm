import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static String input;

    public static void main(String[] args) throws IOException {

        input = br.readLine();

        int ans = 0;
        int left = 1;
        int right = input.length();

        while (left <= right) {
            int window = (left + right) / 2;
            if (check(window)) {
                ans = window;
                left = window + 1;
            } else {
                right = window - 1;
            }
        }

        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();

    }

    public static boolean check(int window) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i <= input.length() - window; i++) {
            String sub = input.substring(i, i + window);
            map.put(sub, map.getOrDefault(sub, 0) + 1);
            if (map.get(sub) >= 2) {
                return true;
            }
        }
        return false;
    }

}
