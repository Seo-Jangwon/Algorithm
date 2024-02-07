import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Solution {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static int N;
	static int[][] room;
	static int[]ans;
	static boolean[][] v;
	
	static int MAX_VISIT;//가장 많이 방문한 횟수
	static int MAX_ROOM;//가장 많이 방문 했을 때 방 번호 
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		int T=Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++)
		{
			N=Integer.parseInt(br.readLine());
			room=new int[N][N];
			v=new boolean[N][N];
			
			
			ans= new int[2];
			ans[0]=N*N;//방 번호
			MAX_ROOM=0;//가장 많이 방문 했을 때 방 번호 
			ans[1]=0;//방문 횟수
			MAX_VISIT=0;//가장 많이 방문한 횟수
			
			
			
			for(int i=0;i<N;i++) {
				String[] input=br.readLine().split(" ");
				for(int j=0;j<N;j++) {
					room[i][j]=Integer.parseInt(input[j]);
				}
			}
			
			for(int i=N-1;i>=0;i--) {
				for(int j=N-1;j>=0;j--) {
					v[i][j]=true;
					dfs(i,j,1, room[i][j]);
					v[i][j]=false;
				}//end for j
			}//end for i
			
			
			System.out.println("#"+tc+" "+ans[0]+" "+ans[1]);
			
		}
	}

	static void dfs(int i,int j, int cntV, int roomN) {
		
		
		if(i-1>=0 && room[i-1][j]-room[i][j]==1 && v[i-1][j]==false) {
			v[i-1][j]=true;
			dfs(i-1,j,cntV+1,roomN);
			v[i-1][j]=false;
			}
		if(i+1<N && room[i+1][j]-room[i][j]==1 && v[i+1][j]==false) {
			v[i+1][j]=true;
			dfs(i+1,j,cntV+1,roomN);
			v[i+1][j]=false;
			}
		if(j-1>=0 && room[i][j-1]-room[i][j]==1 && v[i][j-1]==false) {
			v[i][j-1]=true;
			dfs(i,j-1,cntV+1,roomN);
			v[i][j-1]=false;
			}
		if(j+1<N && room[i][j+1]-room[i][j]==1 && v[i][j+1]==false) {
			v[i][j+1]=true;
			dfs(i,j+1,cntV+1,roomN);
			v[i][j+1]=false;
			}
		else {
			if(ans[1]<=cntV) {//새로운 카운트가 기존 카운트보다 크거나 같으면
				int tmp=ans[1];//기존 카운트 저장
				ans[1]=cntV;//카운트 최신화
				if(tmp==ans[1]&&ans[0]>roomN) {//기존 카운트와 최신화된 카운트가 같은 경우 현재 방 번호가 더 작으면 최신화
					ans[0]=roomN;
				}
				if(tmp!=ans[1]) {//기존 카운트와 최신화된 카운트가 다른 경우 
					ans[0]=roomN;//무조건 최신화
				}
			}//end if
			return;
		}
		
	}
}
