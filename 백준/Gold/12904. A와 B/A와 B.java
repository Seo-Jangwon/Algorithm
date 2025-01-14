import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {

        String str1, str2;
        str1 = br.readLine();
        str2 = br.readLine();

        while (str2.length() > str1.length()) {

            if (str2.charAt(str2.length() - 1) == 'A') {
                str2 = str2.substring(0, str2.length() - 1);
            } else {
                str2 = str2.substring(0, str2.length() - 1);
                StringBuilder temp = new StringBuilder();
                for (int i = str2.length() - 1; i >= 0; i--) {
                    temp.append(str2.charAt(i));
                }
                str2 = temp.toString();
            }
        }

        bw.write(String.valueOf(str1.equals(str2) ? 1 : 0));
        bw.flush();
        bw.close();

    }

}
