import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[][] dp;
	static int n, k;

	public static void main(String[] args) throws IOException {
		String[] in = br.readLine().split(" ");
		n = Integer.parseInt(in[0]);
		k = Integer.parseInt(in[1]);
		
		dp=new int[k+1][n+1];
		for(int i=0;i<=n;i++) {
			dp[1][i]=1;
		}
		
		for(int i=2;i<=k;i++) {
			for(int j=0;j<=n;j++) {
				for(int l=0;l<=j;l++) {
					dp[i][j]+=dp[i-1][l]%1000000000;
					dp[i][j]%= 1000000000;
				}
			}
		}
		System.out.println(dp[k][n]);
		
	}//end main

}