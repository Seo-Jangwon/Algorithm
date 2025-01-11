import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static long t;
    static int n, m;
    static int[] a, b;
    static ArrayList<Integer> listA;
    static HashMap<Long, Integer> mapB;

    public static void main(String[] args) throws IOException {
        t = Long.parseLong(br.readLine());
        n = Integer.parseInt(br.readLine());
        a = new int[n];
        String[] in2 = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(in2[i]);
        }
        m = Integer.parseInt(br.readLine());

        b = new int[m];
        String[] in3 = br.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            b[i] = Integer.parseInt(in3[i]);
        }

        listA = new ArrayList<>();
        mapB = new HashMap<>();

        getSubArrayA();
        getSubArrayB();
        Collections.sort(listA);

        long ans = 0;
        for (int i = 0; i < listA.size(); i++) {
            long diff = t - listA.get(i);
            ans += mapB.getOrDefault(diff, 0);
        }

        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
    }

    static void getSubArrayA() {

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += a[j];
                listA.add(sum);
            }
        }
    }

    static void getSubArrayB() {
        for (int i = 0; i < m; i++) {
            long sum = 0;
            for (int j = i; j < m; j++) {
                sum += b[j];
                mapB.put(sum, mapB.getOrDefault(sum, 0) + 1);
            }
        }
    }
}
