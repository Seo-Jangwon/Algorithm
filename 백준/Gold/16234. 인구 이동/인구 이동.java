import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static int[] dy = { 1, -1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	static int n, l, r;
	static int date;
	static int[][] arr;
	static ArrayList<Point> list;
	static Queue<Point> queue;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		String[] in1 = br.readLine().split(" ");
		n = Integer.parseInt(in1[0]);
		l = Integer.parseInt(in1[1]);
		r = Integer.parseInt(in1[2]);

		date = 0;
		arr = new int[n][n];

		for (int i = 0; i < n; i++) {
			String[] in2 = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(in2[j]);
			}
		}

		while (true) {
			visited = new boolean[n][n];
			boolean isMove = false;
			for (int y = 0; y < n; y++) {
				for (int x = 0; x < n; x++) {
					if (!visited[y][x]) {
						queue = new ArrayDeque<Point>();
						list = new ArrayList<Point>();

						queue.offer(new Point(y, x));
						list.add(new Point(y, x));
						visited[y][x] = true;

						while (!queue.isEmpty()) {
							Point curr = queue.poll();

							for (int d = 0; d < 4; d++) {
								int ny = curr.y + dy[d];
								int nx = curr.x + dx[d];
								if (ny >= 0 && nx >= 0 && ny < n && nx < n && !visited[ny][nx]
										&& (l <= Math.abs(arr[curr.y][curr.x] - arr[ny][nx])
												&& Math.abs(arr[curr.y][curr.x] - arr[ny][nx]) <= r)) {
									isMove = true;
									queue.add(new Point(ny, nx));
									list.add(new Point(ny, nx));
									visited[ny][nx] = true;
								}
							} // end for d

						}

						int sum = 0;
						for (int i = 0; i < list.size(); i++) {
							Point p = list.get(i);
							sum += arr[p.y][p.x];
						}

						int avg = sum / list.size();
						for (int i = 0; i < list.size(); i++) {
							Point p = list.get(i);
							arr[p.y][p.x] = avg;
						}

					}
				}
			}
			if (isMove)
				date += 1;
			else
				break;
		}

		System.out.println(date);
	}

	private static class Point {
		int y;
		int x;

		public Point(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}

}
