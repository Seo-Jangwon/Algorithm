import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	
	static int N, ans;
	
	static int[] dy= {-1,1,0,0};
	static int[] dx= {0,0,1,-1};
	
	static int[][] map;
	
	static Point startPoint;
	static Point endPoint;
	
	static class Point{
		int y;
		int x;
		public Point(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T;
		T=Integer.parseInt(br.readLine());

		for(int tc = 1; tc <= T; tc++)
		{
			N=Integer.parseInt(br.readLine());
			
			map=new int[N][N];
			
			for(int i=0;i<N;i++) {
				String[] in1=br.readLine().split(" ");
				for(int j=0;j<N;j++) {
					map[i][j]=Integer.parseInt(in1[j]);
				}
			}//end for
			
			String[] in2=br.readLine().split(" ");
			String[] in3=br.readLine().split(" ");
			
			startPoint=new Point(Integer.parseInt(in2[0]), Integer.parseInt(in2[1]));
			endPoint=new Point(Integer.parseInt(in3[0]), Integer.parseInt(in3[1]));
			ans=-1;
			bfs();
			
			bw.write("#"+Integer.toString(tc)+" "+Integer.toString(ans));
			bw.newLine();
			bw.flush();
			
		}//end for tc

	}//end main
	
	static void bfs(){
		Queue<Point> q=new ArrayDeque<Point>();
		boolean[][] visited=new boolean[N][N];
		int level=0;
		
		q.offer(startPoint);
		visited[startPoint.y][startPoint.x]=true;
		
		while(!q.isEmpty()) {
			
			int qSize=q.size();
			boolean existSwirm=true;
			if((level+1)%3==0)existSwirm=false;
//			System.out.println("1: level : "+level+" swirm? : "+existSwirm);
			
			for(int i=0;i<qSize;i++) {
				Point curr=q.poll();
				
				for(int d=0;d<4;d++) {
					int ny=curr.y+dy[d];
					int nx=curr.x+dx[d];
					if(ny>=0&&nx>=0&&ny<N&&nx<N&&!visited[ny][nx]&&map[ny][nx]!=1) {
						if((map[ny][nx]==2&&!existSwirm)||map[ny][nx]==0) {
//							System.out.println("2: level : "+level+" ny : "+ny+" nx : "+nx);
							
							if(ny==endPoint.y&&nx==endPoint.x) {
								ans=level+1;
								return;
							}
							q.add(new Point(ny, nx));
							visited[ny][nx]=true;							
						}//방문 가능 조건
						if(map[ny][nx]==2&&existSwirm) {
//							System.out.println("못 들어간 곳 insert : "+curr.y+" "+curr.x);
							q.add(curr);
						}
					}
				}//end for d
			}//end for qSize
			level++;
		}//end queue
	}//end bfs
	
}
