import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class Solution {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	
	static final int INF = 999_999_999;
	static int N;
	static int[][] map;
	static int[][] dijk;
	static int[] dy= {1,-1,0,0};
	static int[] dx= {0,0,-1,1};
	
	static class Point implements Comparable<Point>{
		int y;
		int x;
		int minus;
		public Point(int y, int x, int minus) {
			super();
			this.y = y;
			this.x = x;
			this.minus = minus;
		}//end constructor Point
		@Override
		public int compareTo(Point o) {
			// TODO Auto-generated method stub
			return minus-o.minus;
		}
	}//end Point
	
	public static void main(String args[]) throws Exception
	{
		
		int T;
		T=Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++)
		{
			N=Integer.parseInt(br.readLine());
			map=new int[N][N];
			dijk=new int[N][N];
			
			for(int i=0;i<N;i++) {
				String[] str= br.readLine().split("");
				for(int j=0;j<N;j++) {
					map[i][j]=Integer.parseInt(str[j]);
					dijk[i][j]=INF;
				}
			}//end for i
			
			PriorityQueue<Point>pq=new PriorityQueue<>();
			dijk[0][0]=0;
			pq.offer(new Point(0, 0, map[0][0]));
			
			while(!pq.isEmpty()) {
				
				Point curr=pq.poll();
				
				for(int d=0;d<4;d++) {
					int ny=curr.y+dy[d];
					int nx=curr.x+dx[d];
					
					if(ny>=0&&nx>=0&&ny<N&&nx<N) {
						if(dijk[ny][nx]>curr.minus+map[ny][nx]) {
							dijk[ny][nx]=curr.minus+map[ny][nx];
							pq.offer(new Point(ny, nx, dijk[ny][nx]));
						}
					}
				}
				
			}
			
			System.out.println("#"+tc+" "+dijk[N-1][N-1]);
		}
		
	}
}