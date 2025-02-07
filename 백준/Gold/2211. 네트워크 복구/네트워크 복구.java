import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n, m; // n개의 컴퓨터, m개의 회선
    static ArrayList<Point>[] lists;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        lists = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            lists[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            lists[to].add(new Point(from, cost));
            lists[from].add(new Point(to, cost));
        }

        int[][] dist = new int[n + 1][3]; // 0: 거리, 1: from, 2: to
        for (int i = 0; i <= n; i++) {
            dist[i][0] = Integer.MAX_VALUE;
        }

        dist[1][0] = 0; // 거리
        Queue<Point> q = new PriorityQueue<>();
        q.add(new Point(1, 0));

        while (!q.isEmpty()) {
            Point curr = q.poll();

            int nowPos = curr.now;
            int nowCost = curr.cost;
            if (dist[nowPos][0] < nowCost) {
                continue;
            }

            for (Point next : lists[nowPos]) {

                int nextPos = next.now;
                int nextCost = next.cost;

                if (dist[nextPos][0] > nextCost + nowCost) {
                    dist[nextPos][0] = nextCost + nowCost;
                    dist[nextPos][1] = nowPos;
                    dist[nextPos][2] = nextPos;

                    q.add(new Point(nextPos, nextCost + nowCost));
                }
            }
        }

        System.out.println(n - 1);
        if (n > 1) {
            for (int i = 2; i <= n; i++) {
                System.out.println(dist[i][1] + " " + dist[i][2]);
            }
        }
    }

    static class Point implements Comparable<Point> {

        int now;
        int cost;

        Point(int now, int cost) {
            this.now = now;
            this.cost = cost;
        }

        @Override
        public int compareTo(Point other) {
            return this.cost - other.cost;
        }
    }
}
