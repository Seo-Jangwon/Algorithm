import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static boolean[][] check;
	static char[] str1, str2, str3;

	public static void main(String[] args) throws IOException {

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			String[] in = br.readLine().split(" ");
			str1 = in[0].toCharArray();
			str2 = in[1].toCharArray();
			str3 = in[2].toCharArray();
			
			if(bfs()) {
				System.out.println("Data set "+tc+": yes");
			}else {
				System.out.println("Data set "+tc+": no");
			}
		}
	}

	private static boolean bfs() {
		Queue<Point> queue = new ArrayDeque<Point>();
		check = new boolean[201][201];
		queue.offer(new Point(0, 0, 0));
		check[0][0] = true;

		while (!queue.isEmpty()) {
			Point curr = queue.poll();
			int i1 = curr.y;
			int i2 = curr.x;
			int idx = curr.idx;

			if (idx == str3.length) {
				return true;
			}

			if (i1 < str1.length && !check[i1 + 1][i2] && str1[i1] == str3[idx]) {
				queue.add(new Point(i1 + 1, i2, idx + 1));
				check[i1 + 1][i2] = true;
			}

			if (i2 < str2.length && !check[i1][i2 + 1] && str2[i2] == str3[idx]) {
				queue.add(new Point(i1, i2 + 1, idx + 1));
				check[i1][i2 + 1] = true;
			}
		}
		return false;
	}

	static class Point {
		int y, x, idx;

		public Point(int y, int x, int idx) {
			super();
			this.y = y;
			this.x = x;
			this.idx = idx;
		}

	}
}