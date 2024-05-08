import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static int n;
	static int[] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		n=Integer.parseInt(br.readLine());
		dp=new int[31];
		dp[0]=1;
		dp[1]=0;
		dp[2]=3;
		for(int i=4;i<=n;i+=2) {
			dp[i]=dp[i-2]*4-dp[i-4];
		}
		System.out.println(dp[n]);
	}

}
