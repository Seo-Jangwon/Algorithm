import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static int[] dy = { -1, 1, 0, 0 };// 위, 아래, 좌, 우
	static int[] dx = { 0, 0, -1, 1 };

	static int NContinent;
	static int N;
	static int ans;
	static int[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 1. 번호 달기
		// 2. 다른 번호끼리 최단경로 찾기

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			String[] in = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(in[j]);
				if (map[i][j] == 1)
					map[i][j] = -1;
			}
		} // end for

		NContinent = numbering();// 섬 번호 달기

		ans = Integer.MAX_VALUE;
		for (int i = 1; i <= NContinent; i++) {
			if(ans==1)continue;
			bridge(i);// 다리 놓기
		}

		System.out.println(ans);

	}// end main

	static int numbering() {// 번호 달기
		int num = 0;
		for (int i = 0; i < N; i++) {// 전체 돌며
			for (int j = 0; j < N; j++) {

				if (map[i][j] == -1) {// 방문하지 않았다면,

					num += 1;
					Queue<Point> q = new ArrayDeque<Point>();
					q.offer(new Point(i, j));
					map[i][j] = num;

					while (!q.isEmpty()) {
						Point curr = q.poll();
						for (int d = 0; d < 4; d++) {
							int ny = curr.y + dy[d];
							int nx = curr.x + dx[d];
							if (ny >= 0 && nx >= 0 && ny < N && nx < N && map[ny][nx] == -1) {
								map[ny][nx] = num;
								q.offer(new Point(ny, nx));
							}

						} // end for d

					} // end while
				} // end 방문하지 않았다면
			}
		} // end 전체 돌며
		return num;
	}// end numbering()

	static void bridge(int start) {// 다리 놓기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == start) {
					for (int d = 0; d < 4; d++) {
						int ny = i + dy[d];
						int nx = j + dx[d];
						if (ny >= 0 && nx >= 0 && ny < N && nx < N && map[ny][nx] != start) {
							if(ans==1)return;
							bfs(start, ny, nx);
						}
					}
				}
			}
		}
	}

	static void bfs(int start, int y, int x) {
		Queue<Point> q=new ArrayDeque<Point>();
		boolean[][] v=new boolean[N][N];
		q.offer(new Point(y, x));
		int cnt=1;
		
		while(!q.isEmpty()) {
			int qSize=q.size();
			
			for(int s=0;s<qSize;s++) {
				Point curr=q.poll();
				
				for(int d=0;d<4;d++) {
					int ny=curr.y+dy[d];
					int nx=curr.x+dx[d];
					if (ny >= 0 && nx >= 0 && ny < N && nx < N && map[ny][nx] != start && !v[ny][nx]) {
						if(cnt>ans)return;
						if(map[ny][nx]!=0) {
							if(ans>cnt)ans=cnt;
							return;
						}
						q.offer(new Point(ny, nx));
						v[ny][nx]=true;
					}
				}
			}
			cnt++;
		}
	}

	static class Point {
		int y;
		int x;

		public Point(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}// end Point
}