import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n, m, start, end;
    static ArrayList<ArrayList<Point>> graph;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        StringTokenizer st;
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            graph.get(start).add(new Point(end, value));
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        int[] dist, prev;
        dist = new int[n + 1];
        prev = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(prev, -1);

        PriorityQueue<Point> pq = new PriorityQueue<>(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return o1.value - o2.value;
            }
        });

        dist[start] = 0;

        pq.offer(new Point(start, 0));

        while (!pq.isEmpty()) {
            Point curr = pq.poll();

            if (curr.value > dist[curr.to]) {
                continue;
            }
            for (Point next : graph.get(curr.to)) {
                if (dist[next.to] > dist[curr.to] + next.value) {
                    dist[next.to] = dist[curr.to] + next.value;
                    prev[next.to] = curr.to;
                    pq.offer(new Point(next.to, dist[next.to]));
                }
            }

        }

        bw.write(dist[end] + "\n");
        ArrayList<Integer> path = new ArrayList<>();
        for (int at = end; at != -1; at = prev[at]) {
            path.add(at);
        }
        Collections.reverse(path);
        bw.write(path.size() + "\n");
        for (int city : path) {
            bw.write(city + " ");
        }
        bw.flush();
        bw.close();

    }

    static class Point {

        int to; // 담에 갈곳
        int value; // 거리


        Point(int to, int value) {
            this.to = to;
            this.value = value;
        }
    }
}
