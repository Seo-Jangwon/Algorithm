import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb=new StringBuilder();
	static int n, num;
	static int[] di= {1,-1,0,0};
	static int[] dj= {0,0,-1,1};
	static int[][] map;
	static boolean[][] v;
	static PriorityQueue<Integer>pq;
	
	static class House{
		int i;
		int j;
		public House(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		pq=new PriorityQueue<Integer>();//아파트 단지내 집 수 저장
		n=Integer.parseInt(br.readLine());
		map=new int[n][n];
		v=new boolean [n][n];
		
		for(int i=0;i<n;i++) {
			String[] input=br.readLine().split("");
			for(int j=0;j<n;j++) {
				map[i][j]=Integer.parseInt(input[j]);
			}//end for
		}//end for
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(map[i][j]==1&&!v[i][j]) {
					bfs(i,j);
					num+=1;
				}//end if
			}//end for
		}//end for
		
		bw.write(Integer.toString(num));
		bw.newLine();
		while(!pq.isEmpty()) {
			bw.write(Integer.toString(pq.poll()));
			bw.newLine();
		}
		bw.flush();
		
	}//end main
	
	static void bfs(int i, int j) {
		int nHouse=0;
		Queue<House> q=new ArrayDeque<House>();
		q.offer(new House(i, j));
		v[i][j]=true;
		
		while(!q.isEmpty()) {
			House curr=q.poll();
			nHouse+=1;
			for(int d=0;d<4;d++) {
				int ni=curr.i+di[d];
				int nj=curr.j+dj[d];
				
				if(ni>=0&&nj>=0&&ni<n&&nj<n) {
					if(map[ni][nj]==1&&!v[ni][nj]) {
						q.offer(new House(ni, nj));
						v[ni][nj]=true;
					}
				}//end if
			}//end for
		}//end while
		pq.add(nHouse);
	}//end bfs
}
