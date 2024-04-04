import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

	static int N, B;
	static int ans;
	static int[] Hi;
	
	public static void main(String args[]) throws Exception
	{
		int T=Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++)
		{
			String[] in1=br.readLine().split(" ");
			
			N=Integer.parseInt(in1[0]);
			B=Integer.parseInt(in1[1]);
			
			Hi=new int[N];
			ans=Integer.MAX_VALUE;
			
			String[] in2=br.readLine().split(" ");
			for(int i=0;i<N;i++) {
				Hi[i]=Integer.parseInt(in2[i]);
			}
			
			for(int i=0;i<N;i++) {
				dfs(i, Hi[i]);
			}

			
			bw.write("#"+Integer.toString(tc)+" "+Integer.toString(ans-B));
			bw.newLine();
			bw.flush();
		}
	}
	
	static void dfs(int idx, int sum) {
		if(sum>ans)return;
		
		if(sum>=B) {
			if(sum<ans)
				ans=sum;
			return;
		}
		
		for(int i=idx+1;i<N;i++) {
			dfs(i, sum+Hi[i]);
		}
	}
}