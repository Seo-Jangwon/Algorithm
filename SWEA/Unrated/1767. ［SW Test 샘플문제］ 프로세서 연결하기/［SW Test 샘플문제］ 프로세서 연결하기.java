import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Solution {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	
	static int[] dy= {1,-1, 0, 0};
	static int[] dx= {0, 0,-1, 1};
	static int[][] map;
	
	static int N;
	static int numOfCore;
	static int static_LnkedCore;
	static int lenOfWire;
	
	static ArrayList<Core> coreList;
	
	static class Core{
		int y;
		int x;
		public Core(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		int T=Integer.parseInt(br.readLine());
		T+=1;
		for(int tc=1;tc<T;tc++) {
			N=Integer.parseInt(br.readLine());
			map=new int[N][N];
			coreList=new ArrayList<Core>();
			
			static_LnkedCore=0;
			lenOfWire=Integer.MAX_VALUE;
			numOfCore=0;
			
			for(int i=0;i<N;i++) {
				String[] in=br.readLine().split(" ");
				for(int j=0;j<N;j++) {
					map[i][j]=Integer.parseInt(in[j]);
					if(map[i][j]==1&&i!=0&&i!=N-1&&j!=0&&j!=N-1) {coreList.add(new Core(i,j)); numOfCore++;}
				}
			}//end for
			
			dfs(0,0,0);
			
			bw.write("#"+Integer.toString(tc)+" "+Integer.toString(lenOfWire));
			bw.newLine();
			bw.flush();
			
		}//end test case;
	}//end main
	
	static void dfs(int dep, int linkedCore, int len) {
		if(dep==numOfCore) {
			if(static_LnkedCore<linkedCore) {
				static_LnkedCore=linkedCore;
				lenOfWire=len;
			}
			if(static_LnkedCore==linkedCore) {
				if(lenOfWire>len) {
					lenOfWire=len;
				}
			}
			return;
		}//end 종료조건
		
		Core curr=coreList.get(dep);
		int currY=curr.y;
		int currX=curr.x;
		
		for(int d=0;d<4;d++) {
			if(check(currY, currX, d)) {
				int wireLen=link(currY, currX, d, 5);
				dfs(dep+1, linkedCore+1, len+wireLen);
				link(currY, currX, d, 0);
			}
		}//end 4방향 탐색
		dfs(dep+1, linkedCore, len);//연결 안시킴
	}//end dfs

	static boolean check(int y, int x, int d) {//y좌표, x좌표, 방향
		int ny=y+dy[d];
		int nx=x+dx[d];
		boolean check=false;
		while(true) {
			if(ny==-1||nx==-1||ny==N||nx==N) {check=true; break;}
			if(map[ny][nx]!=0) {check=false;break;}
			ny+=dy[d];
			nx+=dx[d];
		}
		return check;
	}//end check
	
	static int link(int y, int x, int d, int val) {//y좌표, x좌표, 방향, 값(연결 : 5, 연결 끊기: 0)
		int ny=y+dy[d];
		int nx=x+dx[d];
		int wireLen=0;
		while(true) {
			if(ny==-1||nx==-1||ny==N||nx==N) {break;}
			map[ny][nx]=val;
			wireLen++;
			ny+=dy[d];
			nx+=dx[d];
		}
		return wireLen;
	}//end link
	
}