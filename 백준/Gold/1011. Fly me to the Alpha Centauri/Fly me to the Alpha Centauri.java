import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < t; tc++) {

            int x, y;
            String[] in = br.readLine().split(" ");
            x = Integer.parseInt(in[0]);
            y = Integer.parseInt(in[1]);

            bw.write(String.valueOf(findMin(x, y)));
            bw.newLine();
            bw.flush();

        }//end tc
    }//end main


    static long findMin(int x, int y) {
        long diff = y - x;
        long n = (long)Math.sqrt(diff);

        if(diff <= n * n) {
            return 2 * n - 1;
        } else if(diff <= n * (n + 1)) {
            return 2 * n;
        } else {
            return 2 * n + 1;
        }
    }

}