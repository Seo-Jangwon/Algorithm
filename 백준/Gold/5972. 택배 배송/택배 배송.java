import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static final int inf = 999_999_999;
	static ArrayList<Point>[] list;

	public static void main(String[] args) throws IOException {

		String[] in1 = br.readLine().split(" ");
		int n = Integer.parseInt(in1[0]);
		int m = Integer.parseInt(in1[1]);

		list = new ArrayList[n + 1];

		for (int i = 1; i <= n; i++) {
			list[i] = new ArrayList<Point>();
		}

		for (int i = 0; i < m; i++) {
			String[] in2 = br.readLine().split(" ");
			int a = Integer.parseInt(in2[0]);
			int b = Integer.parseInt(in2[1]);
			int c = Integer.parseInt(in2[2]);

			list[a].add(new Point(b, c));
			list[b].add(new Point(a, c));
		}

		boolean[] v = new boolean[n + 1];
		int[] dijk = new int[n + 1];
		Arrays.fill(dijk, inf);

		PriorityQueue<Point> pq = new PriorityQueue<Point>();

		dijk[1] = 0;

		pq.offer(new Point(1, 0));

		while (!pq.isEmpty()) {
			Point curr = pq.poll();

			if (v[curr.to])
				continue;
			else
				v[curr.to] = true;

			for (int i = 0; i < list[curr.to].size(); i++) {
				Point p = list[curr.to].get(i);

				if (!v[p.to] && dijk[p.to] > dijk[curr.to] + p.val) {
					dijk[p.to] = dijk[curr.to] + p.val;
					pq.offer(new Point(p.to, dijk[p.to]));
				}
			}
		}
		System.out.println(dijk[n]);

	}

	static class Point implements Comparable<Point> {
		int to;
		int val;

		public Point(int to, int val) {
			super();
			this.to = to;
			this.val = val;
		}

		@Override
		public int compareTo(Point o) {
			return this.val - o.val;
		}
	}
}