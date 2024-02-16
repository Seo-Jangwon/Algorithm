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
	static int M,N;
	static int startY,startX;
	static int days;
	static int[] dy= {0,0,-1,1};
	static int[] dx= {-1,1,0,0};
	static int [][]map;
	static Queue<Tomato> queue; 
	
	
	static class Tomato{
		int x;
		int y;
		int day;
		public Tomato(int x, int y, int day) {
			super();
			this.x = x;
			this.y = y;
			this.day=day;
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		queue=new ArrayDeque<Tomato>();
		String[] input1=br.readLine().split(" ");
		M=Integer.parseInt(input1[0]);//가로 칸 수
		N=Integer.parseInt(input1[1]);//세로 칸 수
		startY=startX=0;
		days=0;
		
		map=new int[N][M];
		for(int i=0;i<N;i++) {
			String[]input2=br.readLine().split(" ");
			for(int j=0;j<M;j++) {
				map[i][j]=Integer.parseInt(input2[j]);
				if(map[i][j]==1) {startY=i;startX=j;queue.offer(new Tomato(startX, startY, 0));}
			}//end for j
		}//end for i
		
		bfs();
		bw.write(Integer.toString(days));
		bw.flush();
		
	}//end main
	static void bfs() {
		
		boolean[][] v=new boolean[N][M];
		
		int nowX,nowY, day;
		while(!queue.isEmpty()) {
			Tomato curr=queue.poll();
			nowX=curr.x;
			nowY=curr.y;
			day=curr.day;
			for(int i=0;i<4;i++) {
				int ny=nowY+dy[i];
				int nx=nowX+dx[i];
				
				if(0<=ny&&ny<N&&0<=nx&&nx<M) {
					if(map[ny][nx]==0) {
						queue.offer(new Tomato(nx, ny, day+1));
						map[ny][nx]=day+1;
						days=map[ny][nx];
					}//end if
				}//end if
			}//end for i
		}//while
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]==0) {
					days=-1;
					return;
				}
			}
		}
		
	}//end bfs 
}