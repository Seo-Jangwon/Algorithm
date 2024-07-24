import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int n;
    static Integer crains[];
    static int m;
    static Integer boxes[];
    static boolean used[];

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        crains = new Integer[n];
        String in1[] = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            crains[i] = Integer.parseInt(in1[i]);
        }
        Arrays.sort(crains, Collections.reverseOrder());

        m = Integer.parseInt(br.readLine());
        boxes = new Integer[m];
        String in2[] = br.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            boxes[i] = Integer.parseInt(in2[i]);
        }
        Arrays.sort(boxes, Collections.reverseOrder());

        used = new boolean[m];
        Arrays.fill(used, false);

        if (boxes[0] > crains[0]) {
            System.out.println(-1);
            return;
        }

        int time = 0;
        int pickedBox = 0;
        while (pickedBox < m) {
            int boxIdx = 0;
            for (int i = 0; i < n; i++) {
                while (boxIdx < m) {
                    if (!used[boxIdx] && boxes[boxIdx] <= crains[i]) {
                        pickedBox++;
                        used[boxIdx] = true;
                        boxIdx++;
                        break;
                    }
                    boxIdx++;
                }
            }
            time++;
        }
        System.out.println(time);
    }
}
