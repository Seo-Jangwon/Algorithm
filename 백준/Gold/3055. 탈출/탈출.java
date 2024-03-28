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
	
	static int R,C;
	static String[][] map;
	
	static int[] dy= {1,-1,0,0};
	static int[] dx= {0,0,-1,1};
	
	static Point dest;
	static Queue<Point> water;
	static Queue<Point> queue;
	static String answer;
	
	public static void main(String[] args) throws IOException {
		
		//비어있는 곳은 '.'
		//물이 차있는 지역은 '*'
		//돌은 'X'
		//비버의 굴은 'D'
		//고슴도치의 위치는 'S'
		
		String[] in1= br.readLine().split(" ");
		R=Integer.parseInt(in1[0]);
		C=Integer.parseInt(in1[1]);
		map=new String[R][C];
		water=new ArrayDeque<Point>();
		queue=new ArrayDeque<Point>();
		
		
		for(int i=0;i<R;i++) {
			String[] in2= br.readLine().split("");
			for(int j=0;j<C;j++) {
				map[i][j]=in2[j];
				if(map[i][j].equals("D"))dest=new Point(i, j);
				if(map[i][j].equals("*")) {water.offer(new Point(i, j));}
				if(map[i][j].equals("S")) {queue.offer(new Point(i, j));}
			}
		}//end for
		
		answer="KAKTUS";
		bfs();
		bw.write(answer);
		bw.flush();

	}//end main

	static void bfs() {
		int level=0;
		while(!queue.isEmpty()) {
			//물 채우기
			int waterSize=water.size();
			for(int i=0;i<waterSize;i++) {
				Point curr=water.poll();
				for(int d=0;d<4;d++) {
					int ny=curr.y+dy[d];
					int nx=curr.x+dx[d];
					if(ny>=0&&nx>=0&&ny<R&&nx<C&&(map[ny][nx].equals(".")||map[ny][nx].equals("S"))) {
						map[ny][nx]="*";
						water.offer(new Point(ny, nx));
					}
				}
			}//end for waterSize
			level++;
			int qSize=queue.size();
			for(int i=0;i<qSize;i++) {
				Point curr=queue.poll();
				for(int d=0;d<4;d++) {
					int ny=curr.y+dy[d];
					int nx=curr.x+dx[d];
					if(ny>=0&&nx>=0&&ny<R&&nx<C&&!map[ny][nx].equals("*")&&!map[ny][nx].equals("X")&&!map[ny][nx].equals("S")) {
						if(ny==dest.y&&nx==dest.x) {
							answer=Integer.toString(level);
							return;
						}
						map[ny][nx]="S";
						queue.offer(new Point(ny, nx));
					}
				}
			}//end for waterSize
			
		}//end while !isEmpty
	}//end bfs
	
	static class Point{
		int y;
		int x;
		public Point(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}
	
}

