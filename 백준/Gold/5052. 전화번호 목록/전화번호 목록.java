import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static ArrayList<String> tell;
    static HashSet<String> set;

    public static void main(String[] args) throws IOException {

        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            int n = Integer.parseInt(br.readLine());
            tell = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                tell.add(br.readLine());
            }
            Collections.sort(tell);

            set = new HashSet<>();

            String ans = check() ? "YES" : "NO";

            bw.write(ans);
            bw.newLine();
            bw.flush();

        }// end tc
        bw.close();
    }

    static boolean check() {
        for (int i = 0; i < tell.size() - 1; i++) {
            if (tell.get(i + 1).startsWith(tell.get(i))) {
                return false;
            }
        }
        return true;
    }
}
