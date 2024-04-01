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
	
	static int[] mRY= {1,-1};
	static int[] mRX= {0,0};
	
	static int[] mCY= {0,0};
	static int[] mCX= {1,-1};
	
	static Point sp;
	static Point ep;
	
	static int ans;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		
		
		int T;
		T=Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++)
		{
			String[] in=br.readLine().split(" ");
			sp=new Point(Integer.parseInt(in[1])+100, Integer.parseInt(in[0])+100);
			ep=new Point(Integer.parseInt(in[3])+100, Integer.parseInt(in[2])+100);
			
			ans=Integer.MAX_VALUE;
			
			bfs(true);
			bfs(false);
			if(ans==Integer.MAX_VALUE)ans=0;
			bw.write("#"+Integer.toString(tc)+" "+Integer.toString(ans));
			bw.newLine();
			bw.flush();
			
		}//end for tc
		
	}//end main

	static void bfs(boolean isCol) {
		
		Queue<Point> q=new ArrayDeque<Point>();
		boolean[][]visited=new boolean[201][201];
		
		q.add(sp);
		visited[sp.y][sp.x]=true;
		int level=0;
		
		while(!q.isEmpty()) {
			
			int qSize=q.size();
			for(int i=0;i<qSize;i++) {
				Point curr=q.poll();
				int ny1=curr.y;
				int nx1=curr.x;
				
				if(isCol) {
					for(int d=0;d<2;d++) {
						int ny2=ny1+mCY[d];
						int nx2=nx1+mCX[d];
						if(ny2>=0&&nx2>=0&&ny2<201&&nx2<201&&!visited[ny2][nx2]) {
							if(ny2==ep.y&&nx2==ep.x) {
								if(ans>level+1) {
									ans=level+1;
								}
								return;
							}
							
							q.offer(new Point(ny2, nx2));
							visited[ny2][nx2]=true;
						}
					}
					
				}//end isCol
				else {
					for(int d=0;d<2;d++) {
						int ny2=ny1+mRY[d];
						int nx2=nx1+mRX[d];
						if(ny2>=0&&nx2>=0&&ny2<201&&nx2<201&&!visited[ny2][nx2]) {
							if(ny2==ep.y&&nx2==ep.x) {
								if(ans>level+1) {
									ans=level+1;
								}
								return;
							}
							
							q.offer(new Point(ny2, nx2));
							visited[ny2][nx2]=true;
						}
					}
					
				}//end else
				
			}//end for qSize
			level++;
			if(level>=ans)return;
			if(isCol==true) {isCol=false;}
			else{isCol=true;}
		}//end while
	}
	
	static class Point{
		int y;
		int x;
		public Point(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}//end Point
}
