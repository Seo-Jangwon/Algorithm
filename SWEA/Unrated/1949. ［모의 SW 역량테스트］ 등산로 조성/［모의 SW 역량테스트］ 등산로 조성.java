import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Solution {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static int N,K,peak;
	static boolean canUseK;
	static int max;
	static int[]di= {1,-1,0,0};
	static int[]dj= {0,0,-1,1};
	static int[][] map;
	static boolean[][]v;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		int T=Integer.parseInt(br.readLine());

		for(int tc = 1; tc <= T; tc++)
		{	
			String[]in1=br.readLine().split(" ");
			N=Integer.parseInt(in1[0]);//부지
			K=Integer.parseInt(in1[1]);// 최대 K 깊이만큼 지형을 깎는 공사를 할 수 있음
			max=0;
			map=new int[N][N];
			v=new boolean[N][N];
			canUseK=true;//이게 false가 되면 K 못씀
			peak=0;
			
			for(int i=0;i<N;i++) {
				String[]in2=br.readLine().split(" ");
				for(int j=0;j<N;j++) {
					map[i][j]=Integer.parseInt(in2[j]);
					if(peak<map[i][j]) {
						peak=map[i][j];
					}
				}//end for
			}//end for
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(map[i][j]==peak) {
						v[i][j]=true;
						dfs(1,i,j);
						v[i][j]=false;
					}
				}
			}
			bw.write("#"+Integer.toString(tc)+" "+Integer.toString(max));
			bw.newLine();
			bw.flush();
		}//end Test Case
	}//end main
	
	static void dfs(int len, int i, int j) {
//		System.out.println("len : "+len+" 방문 i : "+i+" 방문 j : "+j);
		for(int d=0;d<4;d++) {
			int ni=i+di[d];
			int nj=j+dj[d];
			
			if(ni>=0&&nj>=0&&ni<N&&nj<N&&!v[ni][nj]) {
				if(map[ni][nj]<map[i][j]) {
					v[ni][nj]=true;
					dfs(len+1,ni,nj);
					v[ni][nj]=false;
				}
				
				if(canUseK&&map[ni][nj]>=map[i][j]) {//깎을 수 있다면&&현재 지대보다 더 높거나 같은 곳이면
					int tempMap=map[ni][nj];
					for(int k=1;k<=K;k++) {
						if((map[ni][nj]-k)<map[i][j]) {
//							System.out.println("깎기 전 : "+map[ni][nj]);
							map[ni][nj]-=k;
//							System.out.println("깎은 후 : "+map[ni][nj]);
							canUseK=false;
							v[ni][nj]=true;
							dfs(len+1,ni,nj);
							v[ni][nj]=false;
							canUseK=true;
							map[ni][nj]=tempMap;
						}//end if
					}//end for k
				}//end if				
			}//end if
		
		}//end for
		if(max<len) {
			max=len;
		}
	}//end dfs
}
