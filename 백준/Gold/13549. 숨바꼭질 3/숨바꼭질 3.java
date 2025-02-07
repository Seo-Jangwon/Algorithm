import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int arrLen = 100001;

    static int n, k;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 수빈이
        k = Integer.parseInt(st.nextToken()); // 동생 위치

        dist = new int[arrLen];

        Arrays.fill(dist, Integer.MAX_VALUE);

        Queue<Point> q = new PriorityQueue<>();
        q.offer(new Point(n, 0));
        dist[n] = 0;

        while (!q.isEmpty()) {
            Point curr = q.poll();

            if (dist[curr.pos] < curr.cost) {
                continue;
            }

            int next, nextCost;
            nextCost = curr.cost + 1;

            // curr.pos + 1
            next = curr.pos + 1;
            if (next < arrLen && dist[next] > nextCost) {
                dist[next] = nextCost;
                q.offer(new Point(next, nextCost));
            }

            // curr.pos - 1
            next = curr.pos - 1;
            if (next > -1 && dist[next] > nextCost) {
                dist[next] = nextCost;
                q.offer(new Point(next, nextCost));
            }

            // curr.pos * 2
            next = curr.pos * 2;
            if (next < arrLen && dist[next] > curr.cost) {
                dist[next] = curr.cost;
                q.offer(new Point(next, curr.cost));
            }
        }

        bw.write(String.valueOf(dist[k]));
        bw.flush();
        bw.close();

    }

    static class Point implements Comparable<Point> {

        int pos;
        int cost;

        Point(int pos, int cost) {
            this.pos = pos;
            this.cost = cost;
        }

        @Override
        public int compareTo(Point other) {
            return this.cost - other.cost;
        }
    }

}
