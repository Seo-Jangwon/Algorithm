import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

	static int N;
	static int maxVal,minVal;
	static int[] opr;
	static int[] nums;
	
	public static void main(String args[]) throws Exception
	{
		
		int T;
		T=Integer.parseInt(br.readLine());

		for(int tc = 1; tc <= T; tc++)
		{
			maxVal=Integer.MIN_VALUE;
			minVal=Integer.MAX_VALUE;
			
			N=Integer.parseInt(br.readLine());
			
			opr=new int[4];
			nums=new int[N];
			
			String[] in1=br.readLine().split(" ");
			
			for(int i=0;i<4;i++) {
				opr[i]=Integer.parseInt(in1[i]);
			}//end for i
			
			String[] in2=br.readLine().split(" ");
			for(int i=0;i<N;i++) {
				nums[i]=Integer.parseInt(in2[i]);
			}//end for i
			
			dfs(0,nums[0]);
			
			bw.write("#"+Integer.toString(tc)+" "+Integer.toString(maxVal-minVal));
			bw.newLine();
			bw.flush();
			
		}//end for tc
	}//end main
	
	static void dfs(int dep, int num) {
		if(dep==N-1) {
			if(num>maxVal) {
				maxVal=num;
			}
			if(num<minVal) {
				minVal=num;
			}
			return;
		}//end 종료조건
		
		
		for(int i=0;i<4;i++) {
			if(opr[i]>0) {
				switch (i) {
				case 0:
					opr[i]-=1;
					dfs(dep+1,num+nums[dep+1]);
					opr[i]+=1;
					break;
				case 1:
					opr[i]-=1;
					dfs(dep+1,num-nums[dep+1]);
					opr[i]+=1;
					break;
				case 2:
					opr[i]-=1;
					dfs(dep+1,num*nums[dep+1]);
					opr[i]+=1;
					break;
				case 3:
					opr[i]-=1;
					dfs(dep+1,num/nums[dep+1]);
					opr[i]+=1;
					break;
				}
			}
		}
		
	}//end dfs
}
