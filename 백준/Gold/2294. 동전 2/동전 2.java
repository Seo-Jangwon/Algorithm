import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static int n, k, ans;
	static int[] arr;
	static int[] dp;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String[] in1=br.readLine().split(" ");
		
		n=Integer.parseInt(in1[0]);
		k=Integer.parseInt(in1[1]);
		arr=new int[n];
		dp=new int[k+1];
		Arrays.fill(dp, 1000000);
		dp[0]=0;
		
		for(int i=0;i<n;i++) {
			int in2=Integer.parseInt(br.readLine());
			arr[i]=in2;
		}
		
		for(int i=0;i<n;i++) {
			for(int j=arr[i];j<=k;j++) {
				dp[j]=Integer.min(dp[j],dp[j-arr[i]]+1);
			}
		}
		
		ans=0;
		if(dp[k]==1000000) {
			ans=-1;
		}else {
			ans=dp[k];
		}
		
		System.out.println(ans);
		
	}

}