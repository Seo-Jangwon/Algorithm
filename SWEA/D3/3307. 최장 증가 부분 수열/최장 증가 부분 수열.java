import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Solution {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		
		StringBuilder sb=new StringBuilder();
		
		int T;
		T=Integer.parseInt(br.readLine());

		for(int tc = 1; tc <= T; tc++)
		{
			int N;
			int[] arr;
			int[] dp;
			
			N=Integer.parseInt(br.readLine());
			arr=new int[N];
			dp=new int[N];
			
			
			String[] input=br.readLine().split(" ");
			for(int i=0;i<N;i++) {
				arr[i]=Integer.parseInt(input[i]);
			}//end for		
			dp[0]=arr[0];
			
			int idx=0;
			for(int i=1;i<N;i++) {
				
				if(dp[idx]<arr[i]) {
					dp[++idx]=arr[i];
				}
				
				else if(dp[idx]>arr[i]) {
					int newI=lowerBound(dp, idx, arr[i]);
					dp[newI]=arr[i];
				}
				
			}
			
			sb.append("#"+Integer.toString(tc)+" "+Integer.toString(idx+1)+"\n");
			
		}//end for tc
		System.out.println(sb);

	}//end main

	static int lowerBound(int[] dp, int end, int arrI ) {
		int start=0;
		
		while(start<end) {
		int mid=(start+end)/2;
            if(dp[mid]>=arrI) end=mid;
			else start=mid+1;
		}
		return end;
	}
}