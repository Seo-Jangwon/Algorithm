import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;


class Solution {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static int[][] map;
	static int[] dy= {0,0,-1,1};
	static int[] dx= {-1,1,0,0};
	static int startX, startY;
	static int endX, endY;
	static int ans;
	static Queue<Point> queue; 
	
	static class Point{
		int x;
		int y;
		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		for(int test_case = 1; test_case < 11; test_case++)
		{
			int TC=Integer.parseInt(br.readLine());
			map=new int[100][100];
			queue=new ArrayDeque<Point>();
			
			for(int i=0;i<100;i++) {
				String[]input2=br.readLine().split("");
				for(int j=0;j<100;j++) {
					map[i][j]=Integer.parseInt(input2[j]);
					if(map[i][j]==2) {startY=i; startX=j; queue.offer(new Point(startX, startY));}
				}//end for j
			}//end for i
			
			ans=0;
			bfs();
			bw.write("#"+TC+" "+Integer.toString(ans));
			bw.newLine();
			bw.flush();
			
		}//end for TC
	}//end main
	
	static void bfs() {
		boolean[][] v=new boolean[100][100];
		
		while(!queue.isEmpty()) {
			Point curr=queue.poll();
//			System.out.print(map[curr.y][curr.x]+" ");
			
			
			
			for(int d=0;d<4;d++) {
				int ny=curr.y+dy[d];
				int nx=curr.x+dx[d];
				
				if(map[ny][nx]==3) {
					ans=1;
					return;
				}
				
				if(nx>=0&&nx<100&&ny>=0&&ny<100&&map[ny][nx]==0&&v[ny][nx]==false) {
					queue.offer(new Point(nx, ny));
					v[ny][nx]=true;
				}
				
			}//end for
		}//end while
	}//end bfs
	
}
