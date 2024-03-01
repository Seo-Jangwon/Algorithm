import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

class Solution {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static int N, maxCore, minLen;
	static int[][]map;
	static int[]di= {1,-1,0,0};
	static int[]dj= {0,0,-1,1};
	static ArrayList<Core> list;
	
	static class Core{
		int i;
		int j;

		public Core(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}
	}//end Core

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		int T=Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++)
		{	
			N=Integer.parseInt(br.readLine());
			maxCore=0;
			minLen=Integer.MAX_VALUE;//정답 저장할 최소값 초기화
			map=new int[N][N];
			list=new ArrayList<Core>();
			
			for(int i=0;i<N;i++) {
				String[] in=br.readLine().split(" ");
				for(int j=0;j<N;j++) {
					map[i][j]=Integer.parseInt(in[j]);
					
					boolean checkWall=false;
					if(map[i][j]==1) {
						if(i==0||j==0||i==N-1||j==N-1) continue;
						list.add(new Core(i, j));
					}
					
				}//end for j
			}//end for i
			
			dfs(0,0,0);
			
			bw.write("#"+Integer.toString(tc)+" "+Integer.toString(minLen));
            bw.newLine();
			bw.flush();
		}//end tc
	}//end main
	
	
	static void dfs(int dep, int core, int len) {
		
		if(core+list.size()-dep<maxCore) return;
		
		if(dep==list.size()) {
			if(maxCore<core) {
				maxCore=core;
				minLen=len;
			}else if(maxCore==core) {
				if(minLen>len) {
					minLen=len;
				}
			}
			return;
		}//end 종료조건


		int idxI=list.get(dep).i;
		int idxJ=list.get(dep).j;
			
		for(int d=0;d<4;d++) {
			if(check(idxI,idxJ,d)) {
				int wire=setWire(idxI, idxJ, d, 5);
				dfs(dep+1,core+1,len+wire);
				setWire(idxI, idxJ, d, 0);
			}//end if
		}//end for d
		dfs(dep+1,core,len);//연결 안하는 경우
	}//end dfs
	
	static boolean check(int i, int j, int d) {//코어나 전선이 없는지 확인
		int ni=i+di[d];
		int nj=j+dj[d];
		while(true) {
			if(ni<0||nj<0||ni>=N||nj>=N)return true;
			if(map[ni][nj]>0) return false;
			ni+=di[d];
			nj+=dj[d];
		}
	}
	static int setWire(int i, int j, int d, int n) {//코어에 전선 연결, 지우기
		int ni=i+di[d];
		int nj=j+dj[d];
		int len=0;
		while(ni>=0&&nj>=0&&ni<N&&nj<N) {
			map[ni][nj]=n;
			len++;
			ni+=di[d];
			nj+=dj[d];
		}
		return len;
	}
	
}//end class