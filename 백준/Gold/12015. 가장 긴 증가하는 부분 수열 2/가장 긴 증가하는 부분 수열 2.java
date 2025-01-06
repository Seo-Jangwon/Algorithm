import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n;
    static int[] arr;
    static List<Integer> list;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        list = new ArrayList<Integer>();

        String[] in = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(in[i]);
        }

        list.add(arr[0]);
        for (int i = 0; i < n; i++) {
            putNum(arr[i]);
        }

        bw.write(String.valueOf(list.size()));
        bw.flush();
        bw.close();

    }//end main

    static void putNum(int num) {
        if (list.get(list.size() - 1) < num) {
            list.add(num);
        } else {
            int min = 0;
            int max = list.size() - 1;
            int mid = 0;
            while (min <= max) {
                mid = (min + max) / 2;
                if (list.get(mid) >= num) {
                    max = mid - 1;
                } else {
                    min = mid + 1;
                }
            }
            list.set(min, num);
        }
    }

}
