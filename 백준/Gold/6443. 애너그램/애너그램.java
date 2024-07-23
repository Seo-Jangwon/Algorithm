import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static String str;
    static Set<String> set;

    public static void main(String[] args) throws IOException {

        int TC = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= TC; tc++) {

            set = new HashSet<>();

            str = br.readLine();
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            StringBuilder sb = new StringBuilder();
            boolean[] used = new boolean[chars.length];
            permutation(chars, sb, used, chars.length, 0);

            List<String> results = new ArrayList<>(set);
            Collections.sort(results);  // 결과를 정렬

            for (String result : results) {
                System.out.println(result);
            }
        }


    }

    public static void permutation(char[] chars,  StringBuilder sb, boolean[] used, int len, int index) {
        if (index == len) {
            set.add(sb.toString());
            return;
        }

        for (int i = 0; i < len; i++) {

            if (used[i] || (i > 0 && chars[i] == chars[i - 1] && !used[i - 1])) {
                continue;
            }

            used[i] = true;
            sb.append(chars[i]);
            permutation(chars, sb, used, len, index + 1);
            sb.deleteCharAt(sb.length() - 1);
            used[i] = false;

        }
    }
}