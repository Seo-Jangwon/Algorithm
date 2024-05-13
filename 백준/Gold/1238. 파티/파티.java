import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static final int inf = 999_999_999;
	static int n, m, x;
	static int[] dijk;
	static int[] rDijk;
	static ArrayList<Point>[] list;
	static ArrayList<Point>[] rList;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String[] in1 = br.readLine().split(" ");

		n = Integer.parseInt(in1[0]);// 마을 개수
		m = Integer.parseInt(in1[1]);// 도로 개수
		x = Integer.parseInt(in1[2]);// 파티 마을

		list = new ArrayList[n + 1];
		rList = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			list[i] = new ArrayList<Point>();
			rList[i] = new ArrayList<Point>();
		}

		for (int i = 0; i < m; i++) {
			String[] in2 = br.readLine().split(" ");
			int from = Integer.parseInt(in2[0]);
			int to = Integer.parseInt(in2[1]);
			int weight = Integer.parseInt(in2[2]);

			list[from].add(new Point(to, weight));
			rList[to].add(new Point(from, weight));
		}
		dijk();
		rDijk();

		int ans = 0;
		for (int i = 1; i <= n; i++) {
			if (dijk[i] == inf || rDijk[i] == inf)
				continue;
			if (dijk[i] + rDijk[i] > ans) {
				ans = dijk[i] + rDijk[i];
			}
		}

		System.out.println(ans);
	}

	static void dijk() {
		boolean[] visited = new boolean[n + 1];
		dijk = new int[n + 1];
		Arrays.fill(dijk, inf);
		PriorityQueue<Point> pq = new PriorityQueue<>();

		dijk[x] = 0;
		pq.add(new Point(x, 0));

		while (!pq.isEmpty()) {
			Point curr = pq.poll();

			if (visited[curr.to])
				continue;
			else
				visited[curr.to] = true;

			for (int i = 0; i < list[curr.to].size(); i++) {
				Point next = list[curr.to].get(i);
				if (!visited[next.to] && dijk[next.to] > dijk[curr.to] + next.weight) {
					dijk[next.to] = dijk[curr.to] + next.weight;
					pq.add(new Point(next.to, dijk[next.to]));
				}
			}
		}
	}

	static void rDijk() {
		boolean[] visited = new boolean[n + 1];
		rDijk = new int[n + 1];
		Arrays.fill(rDijk, inf);
		PriorityQueue<Point> pq = new PriorityQueue<>();

		rDijk[x] = 0;
		pq.add(new Point(x, 0));

		while (!pq.isEmpty()) {
			Point curr = pq.poll();

			if (visited[curr.to])
				continue;
			else
				visited[curr.to] = true;

			for (int i = 0; i < rList[curr.to].size(); i++) {
				Point next = rList[curr.to].get(i);
				if (!visited[next.to] && rDijk[next.to] > rDijk[curr.to] + next.weight) {
					rDijk[next.to] = rDijk[curr.to] + next.weight;
					pq.add(new Point(next.to, rDijk[next.to]));
				}
			}
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