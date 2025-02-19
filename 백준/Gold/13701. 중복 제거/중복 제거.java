import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        String[] input = br.readLine().split(" ");
        int[] seen = new int[33554432 / 32]; // int가 32비트

        StringBuilder sb = new StringBuilder();
        for (String s : input) {
            int num = Integer.parseInt(s);
            int index = num / 32;
            int bits = num % 32;

            if ((seen[index]&(1<<bits)) == 0 ) {
                seen[index] |= (1<<bits);
                sb.append(num).append(" ");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();

    }

}
