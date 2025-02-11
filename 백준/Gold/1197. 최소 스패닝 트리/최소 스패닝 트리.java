import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int v, e;
    static int[] parent;
    static ArrayList<Point> list;

    public static void main(String[] args) throws IOException {

        list = new ArrayList<>();

        String[] in1 = br.readLine().split(" ");
        v = Integer.parseInt(in1[0]);
        e = Integer.parseInt(in1[1]);

        parent = new int[v + 1];
        for (int i = 0; i <= v; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < e; i++) {
            String[] in2 = br.readLine().split(" ");
            int now = Integer.parseInt(in2[0]);
            int next = Integer.parseInt(in2[1]);
            int cost = Integer.parseInt(in2[2]);

            list.add(new Point(now, next, cost));
        }

        Collections.sort(list, Comparator.comparing(p -> p.cost));

        long cost = 0;
        for (Point p : list) {
            if (find(p.next) != find(p.now)) {
                union(p.next, p.now);
                cost += p.cost;
            }
        }

        bw.write(cost + "");
        bw.flush();
        bw.close();

    }

    static int find(int a) {
        if (a == parent[a]) {
            return a;
        }
        return parent[a] = find(parent[a]);
    }

    static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB) {
            parent[rootA] = rootB;
        }
    }

    static class Point {

        int now;
        int next;
        int cost;

        public Point(int now, int next, int cost) {
            this.now = now;
            this.next = next;
            this.cost = cost;
        }
    }
}
