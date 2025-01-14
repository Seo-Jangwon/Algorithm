import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static ArrayList<String> alphabet;

    public static void main(String[] args) throws IOException {

        setAlphabet();

        int t = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < t; tc++) {
            String[] input = br.readLine().split("");

            int i = -1;
            for (int i1 = input.length - 2; i1 >= 0; i1--) {// i 찾기
                if (alphabet.indexOf(input[i1]) < alphabet.indexOf(input[i1 + 1])) {
                    i = i1;
                    break;
                }
            }

            if (i == -1) {
                StringBuilder ans = new StringBuilder();
                for (String s : input) {
                    ans.append(s);
                }
                bw.write(ans.toString());
                bw.newLine();
                bw.flush();
                continue;
            }
            
            int j = 0;// i보다 큰 값 중 가장 작은 값
            for (int i2 = input.length - 1; i2 >= i + 1; i2--) {
                if (alphabet.indexOf(input[i2]) >  alphabet.indexOf(input[i])) {
                    j = i2;
                    break;
                }
            }

            // i, j 뒤집기
            String temp1 = input[i];
            input[i] = input[j];
            input[j] = temp1;

            // i+1부터 오름차순 정렬
            int start = i + 1;
            int end = input.length - 1;
            while (start < end) {
                String temp2 = input[start];
                input[start] = input[end];
                input[end] = temp2;
                start++;
                end--;
            }

            StringBuilder ans = new StringBuilder();
            for (String s : input) {
                ans.append(s);
            }

            bw.write(ans.toString());
            bw.newLine();
            bw.flush();
        }
        bw.close();

    }

    static void setAlphabet() {
        alphabet = new ArrayList<>();
        alphabet.add("A");
        alphabet.add("B");
        alphabet.add("C");
        alphabet.add("D");
        alphabet.add("E");
        alphabet.add("F");
        alphabet.add("G");
        alphabet.add("H");
        alphabet.add("I");
        alphabet.add("J");
        alphabet.add("K");
        alphabet.add("L");
        alphabet.add("M");
        alphabet.add("N");
        alphabet.add("O");
        alphabet.add("P");
        alphabet.add("Q");
        alphabet.add("R");
        alphabet.add("S");
        alphabet.add("T");
        alphabet.add("U");
        alphabet.add("V");
        alphabet.add("W");
        alphabet.add("X");
        alphabet.add("Y");
        alphabet.add("Z");
    }
}
