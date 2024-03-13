import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static int N,max;
	static String[][] arr;
	static int[] dy= {1,0,-1,0};
	static int[] dx= {0,1,0,-1};
	
	static class Point{
		int y;
		int x;
		public Point(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		N=Integer.parseInt(br.readLine());
		
		arr=new String[N][N];
		
		for(int i=0;i<N;i++) {
			String[]in2=br.readLine().split("");
			for(int j=0;j<N;j++) {
				arr[i][j]=in2[j];
			}
		}//end for
		
		max=0;
		change();
		bw.write(Integer.toString(max));
		bw.flush();
	}//end main

	static void change() {
		boolean[][][]changed=new boolean[N][N][4];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				for(int d=0;d<4;d++) {
					int ny=dy[d]+i;
					int nx=dx[d]+j;
					if(ny>=0&&nx>=0&&ny<N&&nx<N&&!arr[ny][nx].equals(arr[i][j])&&!changed[i][j][d]) {
						String tmp;
						tmp=arr[ny][nx];
						arr[ny][nx]=arr[i][j];
						arr[i][j]=tmp;
						changed[i][j][d]=true;
						d=(d+2)%4;
						changed[ny][nx][d]=true;
						
						find();

						tmp=arr[ny][nx];
						arr[ny][nx]=arr[i][j];
						arr[i][j]=tmp;
					}//end if
				}//end for d
			}
		}//end for
	}//end change
	
	
	static void find() {
		String now="";
		int cnt;
		for(int i=0;i<N;i++) {
			cnt=0;
			for(int j=0;j<N;j++) {
				if(!arr[i][j].equals(now)) {
					now=arr[i][j];
					cnt=0;
				}if(arr[i][j].equals(now)) {
					cnt+=1;
				}
				if(cnt>max) {
					max=cnt;
				}
			}
		}
		for(int j=0;j<N;j++) {
			cnt=0;
			for(int i=0;i<N;i++) {
				if(!arr[i][j].equals(now)) {
					now=arr[i][j];
					cnt=0;
				}if(arr[i][j].equals(now)) {
					cnt+=1;
				}
				if(cnt>max) {
					max=cnt;
				}
			}
		}
		
		
	}//end dfs
	
}
	
