import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Solution {
	
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static boolean[] v;
	static int[] weight;
	static int N,M;//무게가 이거 넘으면 안됨
	static int maxWeight;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		int T=Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++)
		{
			maxWeight=-1;
			
			String[] in=new String[2];
			in=br.readLine().split(" ");
			N=Integer.parseInt(in[0]);
			M=Integer.parseInt(in[1]);
			
			v=new boolean[N];//사용 체크
			
			String[] inW=new String[N];
			weight=new int[N];
			inW=br.readLine().split(" ");

			for(int i=0;i<N;i++) {
				weight[i]=Integer.parseInt(inW[i]);
			}//end for
			
			dfs(0,0,0);
			
			bw.write("#"+Integer.toString(tc)+" "+Integer.toString(maxWeight));
			bw.newLine();
			bw.flush();
		}//end TC for
		
		
	}//end Main
	
	public static void dfs(int used,int idx, int W ) {
		//System.out.println("총 무게: "+W);
		//종료조건1: 사용한 과자 2 개
		if(idx==N) {
			if(used==2) {
				if( W<=M && W>maxWeight ) {//무게가 M보다 가볍다면
					maxWeight=W;
					//System.out.println("최대 무게: "+maxWeight);
				}
			}return;
		}
		if(used==2) {
			if( W<=M && W>maxWeight ) {//무게가 M보다 가볍다면
				maxWeight=W;
				//System.out.println("최대 무게: "+maxWeight);
			}
			return;
		}

		//System.out.println("사용 : "+(used+1)+", 인덱스 : "+(idx+1)+", 더해지는 무게: "+weight[idx]);
		dfs(used+1,idx+1,W+weight[idx]);


		//System.out.println("사용 X, 인덱스 : "+(idx+1)+", 더해지는 무게 없음 ");
		dfs(used,idx+1,W);
	}
}
