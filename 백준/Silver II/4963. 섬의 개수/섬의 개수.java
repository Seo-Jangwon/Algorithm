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
	static StringBuilder sb=new StringBuilder();
	static int [][]map;
	static int w,h,ans;
	static int[] dx= { 1, -1, 0, 0, 1, -1, 1, -1};
	static int[] dy = {0, 0, -1, 1, -1, 1, 1, -1};
	
	static class Island{
		int x;
		int y;
		public Island(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		while(true) {
			String[] input1=br.readLine().split(" ");
			w=Integer.parseInt(input1[1]);
			h=Integer.parseInt(input1[0]);
			
			if(w==0&&h==0) {
				break;
			}
			
			map=new int[w][h];
			for(int i=0;i<w;i++) {
				String[]input2=br.readLine().split(" ");
				for(int j=0;j<h;j++) {
					map[i][j]=Integer.parseInt(input2[j]);
				}//end for j
			}//end for i
		    ans=0;
			bfs();
			sb.append(Integer.toString(ans)+"\n");
		
		}
		bw.write(sb.toString());
		bw.newLine();
		bw.flush();
	}//end main
	
	static void bfs() {
		Queue<Island> queue=new ArrayDeque<Island>();
		boolean[][]v=new boolean[w][h];
		
		int cnt=0;
		
		for(int i=0;i<w;i++) {
			for(int j=0;j<h;j++) {
				if(map[i][j]==1&&v[i][j]==false) {
					queue.offer(new Island(i, j));
					v[i][j]=true;
					
					while(!queue.isEmpty()) {
						
						Island curr=queue.poll();
						
						for(int d=0;d<8;d++) {
							int nx=curr.x+dx[d];
							int ny=curr.y+dy[d];
							
							if(nx>=0&&nx<w&&ny>=0&&ny<h) {
								if(map[nx][ny]==1&&v[nx][ny]==false) {
									queue.offer(new Island(nx, ny));
									v[nx][ny]=true;
								}//end if
							}//end if
						}//end for
					}//end while
					cnt+=1;
					ans=cnt;
				}//end if
			}//end for j
		}//end for i
		return;
	}
}