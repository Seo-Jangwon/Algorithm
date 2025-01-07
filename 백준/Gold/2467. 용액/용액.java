import java.io.*;
import java.util.Arrays;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N;
    static long trees[];

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        trees = new long[N];

        String[] in1 = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            trees[i] = Long.parseLong(in1[i]);
        }

        Arrays.sort(trees);

        int left = 0;
        int right = N - 1;

        long dif = Long.MAX_VALUE;
        int ansLeft = 0;
        int ansRight = 0;

        while (left < right) {

            long tempDif = trees[left] + trees[right]; // 차를 계산
            long absTempDif = Math.abs(tempDif);

            if (absTempDif < dif) { // 차가 dif보다 작다면
                dif = absTempDif;
                ansLeft = left;
                ansRight = right;
            }

            if (tempDif < 0) {
                left += 1;
            }
            else {
                right -= 1;
            }
        }

        bw.write(trees[ansLeft] + " " + trees[ansRight] + "\n");
        bw.flush();
        bw.close();
    }
}
