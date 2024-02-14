import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static int[] LtoR;
	static int[] RtoL;
	static int[] ver;
	static int N, ans;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		N=Integer.parseInt(br.readLine());
		int cnt=0;
		
		ans=0;
		LtoR=new int[2*N];
		RtoL=new int[2*N];
		ver=new int[N];
		
		dfs(0);
		
		bw.write(Integer.toString(ans));
		bw.flush();
		
	}
	
	static void dfs(int cnt) {
		if(cnt==N) {
			ans+=1;
			return;
		}//종료 조건
		
		boolean check=true;
		for(int i=0;i<N;i++) {
//			System.out.println("i : "+i+" cnt : "+cnt);
//			System.out.println("i+cnt : "+(i+cnt)+" i-cnt : "+(i-cnt+N));
			if(RtoL[i+cnt]==0&&LtoR[i-cnt+N]==0&&ver[i]==0) {
				RtoL[i+cnt]=1;LtoR[i-cnt+N]=1;ver[i]=1;
				dfs(cnt+1);
				RtoL[i+cnt]=0;LtoR[i-cnt+N]=0;ver[i]=0;
			}
		}
		
	}//end dfs
}
