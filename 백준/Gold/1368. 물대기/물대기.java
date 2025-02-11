import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n;
    static int[] parent;
    static ArrayList<Point> points;

    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(br.readLine());

        parent = new int[n + 1];
        points = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            int digMe = Integer.parseInt(br.readLine());
            points.add(new Point(0, i, digMe));
            parent[i] = i;
        }

        for (int i = 1; i <= n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 1; j <= n; j++) {
                if (i < j) {
                    points.add(new Point(i, j, Integer.parseInt(input[j - 1])));
                }
            }
        }

        Collections.sort(points);

        int totalCost = 0;
        for (Point p : points) {
            if (find(p.from) != find(p.to)) { // 사이클이 생기지 않는 경우라면
                union(p.from, p.to);
                totalCost += p.cost;
            }
        }

        bw.write(totalCost + "");
        bw.flush();
        bw.close();

    }

    static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    static void union(int x, int y) {
        int xRoot = find(x);
        int yRoot = find(y);
        if (xRoot != yRoot) {
            parent[yRoot] = xRoot;
        }
    }

    static class Point implements Comparable<Point> {

        int to;
        int from;
        int cost;

        Point(int to, int from, int cost) {
            this.to = to;
            this.from = from;
            this.cost = cost;
        }

        @Override
        public int compareTo(Point other) {
            return this.cost - other.cost;
        }
    }

}
