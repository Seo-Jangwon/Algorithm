import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.concurrent.SynchronousQueue;

public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static int W,H, cnt;
	static int[] dx= {1,-1, 0, 0, 1, 1,-1,-1};
	static int[] dy= {0, 0, 1,-1, 1,-1, 1,-1};
	static int map[][];
	static boolean v[][];

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		W=H=1;
		
		while(W!=0&&H!=0) {
			String[] in1=br.readLine().split(" ");
			W=Integer.parseInt(in1[0]);
			H=Integer.parseInt(in1[1]);
			cnt=0;
			
			if(W==0&&H==0)break;
			
			map=new int[H][W];
			v=new boolean[H][W];
			
			for(int i=0;i<H;i++) {
				String[] in2=br.readLine().split(" ");
				for(int j=0;j<W;j++) {
					map[i][j]=Integer.parseInt(in2[j]);
				}//end for j
			}//end for i
			
			for(int i=0;i<H;i++) {
				for(int j=0;j<W;j++) {
					if(v[i][j]==false&&map[i][j]==1) {
						cnt+=1;
						v[i][j]=true;
						dfs(i,j);
						
					}
					
				}//end for j
			}//end for i
			
			bw.write(Integer.toString(cnt));
			bw.newLine();
			
		}//end while
		bw.close();
	}//end main
	static void dfs(int y, int x) {
		
		for(int d=0;d<8;d++) {
			int ny=y+dy[d];
			int nx=x+dx[d];
			
			if(nx>=0&&nx<W&&ny>=0&&ny<H&&map[ny][nx]==1&&v[ny][nx]==false) {
				v[ny][nx]=true;
				dfs(ny,nx);
			}
			
		}//사방향 탐색 끝
		
	}
}
