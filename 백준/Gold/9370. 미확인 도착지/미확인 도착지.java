import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n, m, t; // n: 교차로, m: 도로, t: 목적지 후보의 개수
    static int s, g, h; // s는 예술가들의 출발지, 예술가가 g와 h 교차로 사이에 있는 도로를 지나갔다
    static ArrayList<Road>[] roads; // 각 포인트에서 어디로 갈 수 있는지 도로 저장. n+1개 사이즈
    static int[] arrT; // 목적지 후보들 t개

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            String[] in1 = br.readLine().split(" ");
            n = Integer.parseInt(in1[0]);
            m = Integer.parseInt(in1[1]);
            t = Integer.parseInt(in1[2]);

            String[] in2 = br.readLine().split(" ");
            s = Integer.parseInt(in2[0]);
            g = Integer.parseInt(in2[1]);
            h = Integer.parseInt(in2[2]);

            roads = new ArrayList[n + 1];
            for (int i = 0; i <= n; i++) {
                roads[i] = new ArrayList<>();
            }

            for (int i = 0; i < m; i++) {
                String[] in3 = br.readLine().split(" ");
                int a = Integer.parseInt(in3[0]); // 이거와
                int b = Integer.parseInt(in3[1]); // 이거 사이에
                int d = Integer.parseInt(in3[2]); // 걸리는 시간

                // g-h 도로는 홀수로, 나머지는 짝수로 변형
                if ((a == g && b == h) || (a == h && b == g)) {
                    roads[a].add(new Road(b, 2 * d - 1));
                    roads[b].add(new Road(a, 2 * d - 1));
                } else {
                    roads[a].add(new Road(b, 2 * d));
                    roads[b].add(new Road(a, 2 * d));
                }
            }

            arrT = new int[t];
            for (int i = 0; i < t; i++) {
                arrT[i] = Integer.parseInt(br.readLine());
            }

            int[] dist = new int[n + 1];
            Arrays.fill(dist, 100_000_000);

            Queue<Road> queue = new PriorityQueue<>();
            queue.offer(new Road(s, 0)); // 출발지로 초기화
            dist[s] = 0;

            while (!queue.isEmpty()) {
                Road currRoad = queue.poll();
                int here = currRoad.next;
                int cost = currRoad.cost;

                if (dist[here] < cost) {
                    continue;
                }

                for (Road road : roads[here]) {
                    int next = road.next;
                    int newCost = road.cost+dist[here];

                    if (dist[next] > newCost) {
                        dist[next] = newCost;
                        queue.offer(new Road(next, newCost));
                    }
                }
            }

            ArrayList<Integer> result = new ArrayList<>();
            for (int destination : arrT) {
                if (dist[destination] % 2 == 1) { // 도달 가능하면
                    result.add(destination);
                }
            }
            Collections.sort(result);
            StringBuilder sb = new StringBuilder();
            for (int ans : result) {
                sb.append(ans).append(" ");
            }

            bw.write(sb.toString() + "\n");
            bw.flush();
        }
        bw.close();
    }

    static class Road implements Comparable<Road> {

        int next;
        int cost;

        public Road(int next, int cost) {
            this.next = next;
            this.cost = cost;
        }

        @Override
        public int compareTo(Road o) {
            return this.cost - o.cost;
        }
    }
}
