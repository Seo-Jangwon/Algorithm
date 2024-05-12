import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		final int inf = 999_999_999;
		int v, e;// 정점의 개수 V, 간선의 개수 E
		int start;// 시작 정점
		int[] dijk;
		boolean[] visited;
		ArrayList<Point>[] list;

		String[] in1 = br.readLine().split(" ");
		v = Integer.parseInt(in1[0]);
		e = Integer.parseInt(in1[1]);

		visited = new boolean[v + 1];
		dijk = new int[v + 1];
		Arrays.fill(dijk, inf);

		start = Integer.parseInt(br.readLine());

		list = new ArrayList[v + 1];
		for (int i = 1; i <= v; i++) {
			list[i] = new ArrayList<Point>();
		}

		for (int i = 0; i < e; i++) {
			String[] in2 = br.readLine().split(" ");
			int from = Integer.parseInt(in2[0]);
			int to = Integer.parseInt(in2[1]);
			int weight = Integer.parseInt(in2[2]);

			list[from].add(new Point(to, weight));
		}

		dijk[start] = 0;
		PriorityQueue<Point> pq = new PriorityQueue<Point>();
		pq.offer(new Point(start, 0));

		while (!pq.isEmpty()) {
			Point curr = pq.poll();
			if (visited[curr.to])
				continue;
			else
				visited[curr.to] = true;

			for (int i = 0; i < list[curr.to].size(); i++) {
				Point now = list[curr.to].get(i);
				if (!visited[now.to] && dijk[now.to] > dijk[curr.to] + now.weight) {
					dijk[now.to] = dijk[curr.to] + now.weight;
					pq.add(new Point(now.to, dijk[now.to]));
				}
			}
		}

		for (int i = 1; i <= v; i++) {
			System.out.println(dijk[i] != inf ? dijk[i] : "INF");
		}

	}

	static class Point implements Comparable<Point> {
		int to;
		int weight;

		public Point(int to, int weight) {
			super();
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Point o) {
			// TODO Auto-generated method stub
			return this.weight - o.weight;
		}

	}
}