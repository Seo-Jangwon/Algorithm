import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n;

    public static void main(String[] args) throws IOException {
//        S(0) = "m o o"
//        S(1) = "m o o  m o o o  m o o"
//        S(2) = "m o o  m o o o  m o o  m o o o o  m o o  m o o o m o o"

        n = Integer.parseInt(br.readLine());

        char ans = find(0);

        bw.write(ans + "");
        bw.flush();
        bw.close();

    }

    static char find(int dep) {
        int k = 0;
        while (getLen(k) < n) {
            k++;
        }
        return findAns(n, k);
    }

    private static char findAns(int n, int k) {
        if (k == 0) {
            if (n == 1) {
                return 'm';
            } else {
                return 'o';
            }
        }
        long prevLen = getLen(k - 1);

        if (n <= prevLen) {
            return findAns(n, k - 1);
        }

        long midLen = k + 3;
        if (n <= prevLen + midLen) {
            long postMid = n - prevLen;
            if (postMid == 1) {
                return 'm';
            }
            return 'o';
        }
        return findAns((int) (n - prevLen - midLen), k - 1);
    }

    static long getLen(int k) {
        if (k == 0) {
            return 3; // moo
        } else {
            return 2 * getLen(k - 1) + (k + 3);
        }
    }

}
