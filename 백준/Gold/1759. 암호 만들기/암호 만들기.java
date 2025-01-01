import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int l, c;
    static String[] str;
    static List<String> pwd;

    public static void main(String[] args) throws IOException {
        String[] in1 = br.readLine().split(" ");
        l = Integer.parseInt(in1[0]);
        c = Integer.parseInt(in1[1]);

        str = new String[c];
        pwd = new ArrayList<>();
        str = br.readLine().split(" ");
        Arrays.sort(str);

        dfs(0, 0);
        bw.close();

    }

    static void dfs(int idx, int dep) throws IOException {
        if (dep == l) {
            if (validVowls() && validConsonants()) {
                for (String str : pwd) {
                    bw.write(str);
                    bw.flush();
                }
                bw.newLine();
                bw.flush();
            }
            return;
        }// end for

        for (int i = idx; i < c; i++) {
            pwd.add(str[i]);
            dfs(i + 1, dep + 1);
            pwd.remove(str[i]);
        }

    }// end dfs func

    static boolean validVowls() {// 하나 이상의 모음이 포함되었는지 확인
        for (String str : pwd) {
            if (str.equals("a") || str.equals("e") || str.equals("i") || str.equals("o")
                || str.equals("u")) {
                return true;
            }
        }//end for
        return false;
    }// end valid func

    static boolean validConsonants() {// 두 개 이상의 자음이 들어가는지
        int cnt = 0;
        for (String str : pwd) {
            if (str.equals("a") || str.equals("e") || str.equals("i") || str.equals("o")
                || str.equals("u")) {

            } else {
                cnt++;
                if (cnt == 2) {
                    return true;
                }
            }
        }//end for
        return false;
    }// end valid func

}
