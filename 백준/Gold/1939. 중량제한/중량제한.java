import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Queue;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int maxWeight;
    static int n, m;
    static ArrayList<Bridge>[] bridges;
    static int start, end;

    public static void main(String[] args) throws IOException {

        String[] in1 = br.readLine().split(" ");
        n = Integer.parseInt(in1[0]);// 섬 개수
        m = Integer.parseInt(in1[1]);// 다리 개수

        bridges = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            bridges[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            String[] in2 = br.readLine().split(" ");
            int a = Integer.parseInt(in2[0]);// 다리 시작 점 A
            int b = Integer.parseInt(in2[1]);// 다리 시작 점 B
            int c = Integer.parseInt(in2[2]);// 최대 중량

            bridges[a].add(new Bridge(b, c));
            bridges[b].add(new Bridge(a, c)); // 양방향
            maxWeight = Math.max(maxWeight, c);

        }
        String[] in3 = br.readLine().split(" ");
        start = Integer.parseInt(in3[0]);
        end = Integer.parseInt(in3[1]);

        int ans = 0;
        int start = 1;
        int end = maxWeight;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isOkToGo(mid)) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();

    }

    static boolean isOkToGo(int limit) {
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n + 1];

        queue.offer(start);
        visited[start] = true;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (cur == end) {
                return true;
            }
            for (Bridge bridge : bridges[cur]) {
                if (!visited[bridge.to] && bridge.weight >= limit) {
                    visited[bridge.to] = true;
                    queue.offer(bridge.to);
                }
            }
        }

        return false;
    }

    static class Bridge {

        int to, weight;

        Bridge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

}
