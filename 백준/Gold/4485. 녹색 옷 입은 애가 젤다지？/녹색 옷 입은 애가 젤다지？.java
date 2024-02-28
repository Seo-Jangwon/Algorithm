import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.PriorityQueue;


public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static final int INF = 999_999_999;
	static int[] di= {1,-1,0,0};
	static int[] dj= {0,0,-1,1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		int problem=1;
		while(true) {
			int N=Integer.parseInt(br.readLine());
			if(N==0)break;
			int[][] arr=new int[N][N];
			int[][]dijk=new int[N][N];
			
			for(int i=0;i<N;i++) {
				String[] in=br.readLine().split(" ");
				for(int j=0;j<N;j++) {
					arr[i][j]=Integer.parseInt(in[j]);
					dijk[i][j]=INF;
				}
			}
			
			PriorityQueue<Point> pq=new PriorityQueue<>();
			dijk[0][0]=0;
			pq.offer(new Point(0, 0, arr[0][0]));
			
			while(!pq.isEmpty()) {
				Point curr=pq.poll();
				
				for(int d=0;d<4;d++) {
					int ni=curr.i+di[d];
					int nj=curr.j+dj[d];
					
					if(ni>=0&&nj>=0&&ni<N&&nj<N) {
						if(dijk[ni][nj]>curr.minus+arr[ni][nj]) {
							dijk[ni][nj]=curr.minus+arr[ni][nj];
							pq.offer(new Point(ni, nj, dijk[ni][nj]));
						}
					}//end if
				}//end for
				
				
			}//end while pq
			
			bw.write("Problem "+Integer.toString(problem)+": "+Integer.toString(dijk[N-1][N-1]));
			bw.newLine();
			bw.flush();
			problem+=1;
			
		}//end while true
	}//end main
	
	static class Point implements Comparable<Point>{
		int i;
		int j;
		int minus;
		public Point(int i, int j, int minus) {
			super();
			this.i = i;
			this.j = j;
			this.minus = minus;
		}//end constructor Point
		@Override
		public int compareTo(Point o) {
			// TODO Auto-generated method stub
			return minus-o.minus;
		}
	}//end Point

}