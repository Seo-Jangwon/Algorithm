import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int t;

    public static void main(String[] args) throws IOException {

        t = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < t; tc++) {

            String ans = "NO";
            String input = br.readLine();
            String vega = "(100+1+|01)+";
            if (input.matches(vega)) {
                ans = "YES";
            }

            bw.write(ans);
            bw.newLine();
            bw.flush();

        }
        bw.close();
    }

}
