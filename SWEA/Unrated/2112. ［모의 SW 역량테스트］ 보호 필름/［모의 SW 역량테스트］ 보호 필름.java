import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int D,W,K;
	static int ans;
	int[][] film;
	static boolean v[][];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		int T;
		T=Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++)
		{
			String in1=br.readLine();
			st=new StringTokenizer(in1);
			D=Integer.parseInt(st.nextToken());//두께
			W=Integer.parseInt(st.nextToken());//가로
			K=Integer.parseInt(st.nextToken());//합격 기준
			
			int[][] film=new int[D][W];
			v=new boolean[D][2];
			
			for(int i=0;i<D;i++) {
				String in2=br.readLine();
				st=new StringTokenizer(in2);
				for(int j=0;j<W;j++) {
					film[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			
			ans=Integer.MAX_VALUE;
			
			if(check(film)) {
				ans=0;
			}
			
			for(int i=0;i<D;i++) {
				v[i][0]=true;
				dfs(1,i,0,film);
				v[i][0]=false;
				
				v[i][1]=true;
				dfs(1,i,1,film);
				v[i][1]=false;
			}
			
			bw.write("#"+Integer.toString(tc)+" "+Long.toString(ans));
			bw.newLine();
			bw.flush();
			
		}//end for tc
	}//end main

	static void dfs(int dep, int idx, int med, int[][]film) {//약품A 주입
		if(dep>=ans)return;
		
		int[][]newFilm=new int[D][W];
		
		for(int i=0;i<D;i++) {
			for(int j=0;j<W;j++) {
				newFilm[i][j]=film[i][j];
			}
		}
		
		for(int i=0;i<W;i++) {
			newFilm[idx][i]=med;
		}
		
		
		if(check(newFilm)) {
			if(ans>dep) {
				ans=dep;
			}
			return;
		}
		
		for(int i=idx+1;i<D;i++) {
			if(!v[i][0]) {
				v[i][0]=true;
				dfs(dep+1,i,0,newFilm);
				v[i][0]=false;
			}
			if(!v[i][1]) {
				v[i][1]=true;
				dfs(dep+1,i,1,newFilm);
				v[i][1]=false;
			}
		}
		
	}//end dfs
	
	static boolean check(int[][]newFilm) {//통과 체크
		for(int i=0;i<W;i++) {
			
			int cnt=0;
			int now=0;
			int maxCnt=0;
			now=newFilm[0][i];
			
			for(int j=0;j<D;j++) {
				if(now==newFilm[j][i]) cnt+=1;
				else {
					now=newFilm[j][i];
					cnt=1;
				}
				if(maxCnt<cnt)maxCnt=cnt;
			}//end for j
			if(maxCnt<K) return false;
		}//end for i
		return true;
	}//end check
	
}
