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
	static String[][] arrO;
	static String[][] arrRG;
	static boolean[][] v, v2;
	static int[] dx= {1,-1,0,0};
	static int[] dy= {0,0,-1,1};
	static int N, normal, nX;//N, 정상인이 보는 색, 겹쳐보이는 곳
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		N=Integer.parseInt(br.readLine());
		arrO=new String[N][N];
		arrRG=new String[N][N];
		
		for(int i=0;i<N;i++) {
			String[] input=br.readLine().split("");
			for(int j=0;j<N;j++) {
				arrO[i][j]=input[j];
				if(input[j].equals("G")) {
					arrRG[i][j]="R";
				}
				else {
					arrRG[i][j]=input[j];
				}
			}//end for
		}//end for
		
		
		
//		for(int i=0;i<N;i++) {
//			for(int j=0;j<N;j++) {
//				System.out.print(arrRG[i][j]+i+j+" ");
//			}//end for
//			System.out.println();
//		}//end for
		
		
		v=new boolean[N][N];
		for(int i=0;i<N;i++) {//정상인 색깔 구역
			for(int j=0;j<N;j++) {
				if(arrO[i][j].equals("R")&&!v[i][j]) {
					bfs(i, j,"R");
					normal+=1;
				}//end if Red
				if(arrO[i][j].equals("G")&&!v[i][j]) {
					bfs(i, j,"G");
					normal+=1;
				}//end if Green
				if(arrO[i][j].equals("B")&&!v[i][j]) {
					bfs(i, j,"B");
					normal+=1;
				}//end if Blue
			}//end for
		}//end for 
		
		v2=new boolean[N][N];
		for(int i=0;i<N;i++) {//적녹색맹
			for(int j=0;j<N;j++) {
				if(arrRG[i][j].equals("R")&&!v2[i][j]) {
//					System.out.println("R i : "+i+" R j : "+j);
					bfsRG(i, j,"R");
					nX+=1;
				}//end if RG
				else if(arrO[i][j].equals("B")&&!v2[i][j]) {
//					System.out.println("B i : "+i+" B j : "+j);
					bfsRG(i, j,"B");
					nX+=1;
				}//end if Blue
			}//end for
		}//end for 
		
		bw.write(Integer.toString(normal)+" "+Integer.toString(nX));
		bw.flush();
		bw.close();
		
	}//end main
	
	static void bfs(int i, int j, String color) {
		Queue<Color> q=new ArrayDeque<Color>();
		
		q.offer(new Color(i, j, color));
		v[i][j]=true;
		
		while(!q.isEmpty()) {
			Color curr=q.poll();
			
			for(int d=0;d<4;d++) {
				int ny=curr.i+dy[d];
				int nx=curr.j+dx[d];
				
				if(nx>=0&&nx<N&&ny>=0&&ny<N) {
					if(!v[ny][nx]&&arrO[ny][nx].equals(color)) {
						q.offer(new Color(ny, nx, color));
						v[ny][nx]=true;
					}//end if
				}//end if
			}//end for d
		}//end while
	}//end bfs
	
	static void bfsRG(int i, int j, String color) {
		Queue<Color> q=new ArrayDeque<Color>();
		
		q.offer(new Color(i, j, color));
		v2[i][j]=true;
		
		while(!q.isEmpty()) {
			Color curr=q.poll();
			
			for(int d=0;d<4;d++) {
				int ny=curr.i+dy[d];
				int nx=curr.j+dx[d];
				
				if(nx>=0&&nx<N&&ny>=0&&ny<N) {
					if(!v2[ny][nx]&&arrRG[ny][nx].equals(curr.color)) {
						q.offer(new Color(ny, nx, curr.color));
						v2[ny][nx]=true;
					}//end if
				}//end if
			}//end for d
		}//end while
	}//end bfs
	
	static class Color{
		int i;
		int j;
		String color;
		public Color(int i, int j, String color) {
			super();
			this.i = i;
			this.j = j;
			this.color = color;
		}
	}
}