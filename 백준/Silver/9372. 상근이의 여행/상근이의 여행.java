import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n, m;
    static int[] parent;
    static ArrayList<Point> list;

    public static void main(String[] args) throws IOException {

        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            String[] in1 = br.readLine().split(" ");
            n = Integer.parseInt(in1[0]);
            m = Integer.parseInt(in1[1]);

            parent = new int[n + 1];
            list = new ArrayList<>();
            for (int i = 0; i < n + 1; i++) {
                parent[i] = i;
            }

            for (int i = 0; i < m; i++) {
                String[] in2 = br.readLine().split(" ");
                int now = Integer.parseInt(in2[0]);
                int next = Integer.parseInt(in2[1]);
                list.add(new Point(now, next));
            }

            int count = 0;
            for (Point p : list) {
                if (find(p.now) != find(p.next)) {
                    union(p.now, find(p.next));
                    count++;
                }

            }

            bw.write(count + "\n");
        }
        bw.flush();
        bw.close();
    }

    static int find(int a) {
        if (parent[a] == a) {
            return a;
        }
        return parent[a] = find(parent[a]);
    }

    static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA != rootB) {
            parent[rootB] = rootA;
        }
    }

    static class Point {

        int now;
        int next;

        Point(int now, int next) {
            this.now = now;
            this.next = next;
        }
    }

}
