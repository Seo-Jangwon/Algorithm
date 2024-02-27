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
	
	static class Data implements Comparable<Data>{
		int i;
		int j;
		int damage;
		public Data(int i, int j, int damage) {
			super();
			this.i = i;
			this.j = j;
			this.damage=damage;
		}//end constructor Data
		@Override
		public int compareTo(Data o) {
			// TODO Auto-generated method stub
			return damage-o.damage;
		}
	}//end Data
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		int problem=1;
		while(true) {
			int[]di= {-1,1,0,0};
			int[]dj= {0,0,1,-1};
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
			
			
			
			PriorityQueue<Data> pq = new PriorityQueue<Data>();
			dijk[0][0]=0;
			pq.offer(new Data(0, 0, arr[0][0]));
			 
			while(!pq.isEmpty()) {
				Data curr=pq.poll();
				if(curr.i==N-1&&curr.j==N-1) break;

				for(int d=0;d<4;d++) {
					int ni=curr.i+di[d];
					int nj=curr.j+dj[d];
					 
					if(ni>=0&&nj>=0&&ni<N&&nj<N) {
						if(dijk[ni][nj]>curr.damage+arr[ni][nj]) {
							dijk[ni][nj]=curr.damage+arr[ni][nj];
							pq.offer(new Data(ni,nj, dijk[ni][nj]));
						}
					}
				}
			}
			
			bw.write("Problem "+Integer.toString(problem)+": "+Integer.toString(dijk[N-1][N-1]));
			bw.newLine();
			bw.flush();
			problem+=1;
		}//end while
	}//end main
	


}