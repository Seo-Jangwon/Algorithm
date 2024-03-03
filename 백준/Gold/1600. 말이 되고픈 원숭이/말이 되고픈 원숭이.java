import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static int[] hdy= {1,-1, 2,-2, 2,-2, 1,-1};
	static int[] hdx= {2, 2, 1, 1,-1,-1,-2,-2};
	static int[] dy= {1,-1, 0, 0};
	static int[] dx= {0, 0,-1, 1};
	static int[][] map;
	static int K, W, H;
	
	static class Point{
		int i;
		int j;
		int horseMove;
		int move;
		public Point(int i, int j, int horseMove, int move) {
			super();
			this.i = i;
			this.j = j;
			this.horseMove = horseMove;
			this.move = move;
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		K=Integer.parseInt(br.readLine());//K번만 말처럼 움직일 수 있다
		String[] in1=br.readLine().split(" ");
		W=Integer.parseInt(in1[0]);
		H=Integer.parseInt(in1[1]);
		map=new int[H][W];
		
		for(int i=0;i<H;i++) {
			String[] in2=br.readLine().split(" ");
			for(int j=0;j<W;j++) {
				map[i][j]=Integer.parseInt(in2[j]);
			}
		}//end for
		
		bw.write(Integer.toString(bfs()));
		bw.flush();
		
	}//end main
	
	static int bfs() {
		Queue<Point> q=new ArrayDeque<Point>();
		boolean[][][]visited=new boolean[H][W][K+1];
		q.offer(new Point(0, 0, K,0));
		visited[0][0][K]=true;
		
		while(!q.isEmpty()) {
			for(int i=0;i<q.size();i++) {
				Point curr=q.poll();
				if(curr.i==H-1&&curr.j==W-1) return curr.move;
				for(int d=0;d<4;d++) {
					int ny=curr.i+dy[d];
					int nx=curr.j+dx[d];
					if(ny>=0&&nx>=0&&ny<H&&nx<W&&map[ny][nx]!=1&&!visited[ny][nx][curr.horseMove]) {
						visited[ny][nx][curr.horseMove]=true;
						q.offer(new Point(ny, nx, curr.horseMove, curr.move+1));
					}//end if
				}//end for dy dx
				if(curr.horseMove>0) {
					for(int d=0;d<8;d++) {
						int ny=curr.i+hdy[d];
						int nx=curr.j+hdx[d];
						if(ny>=0&&nx>=0&&ny<H&&nx<W&&map[ny][nx]!=1&&!visited[ny][nx][curr.horseMove-1]) {
							visited[ny][nx][curr.horseMove-1]=true;
							q.offer(new Point(ny, nx, curr.horseMove-1, curr.move+1));
						}//end if
					}//end for dy dx
				}
			}//end for
		}//end while
		return -1;
	}//end bfs
}