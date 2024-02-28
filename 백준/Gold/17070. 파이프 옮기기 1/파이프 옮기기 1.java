import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static int N;
	static int[][]arr;
	static int[][][] dp;//좌표, 좌표, 0:가로, 1:세로, 2:대각선
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		N=Integer.parseInt(br.readLine());
		arr=new int[N+1][N+1];
		dp=new int[N+1][N+1][3];
		
		for(int i=1;i<N+1;i++) {
			String[]in=br.readLine().split(" ");
			for(int j=1;j<N+1;j++) {
				arr[i][j]=Integer.parseInt(in[j-1]);
			}//end for
		}//end for
		dp[1][2][0]=1;
		for(int i=1;i<N+1;i++) {
			for(int j=3;j<N+1;j++) {
				if(arr[i][j]!=1) { 
					dp[i][j][0]=dp[i][j-1][0]+dp[i][j-1][2];//가로로 들어옴(가로, 대각선)
					
					dp[i][j][1]=dp[i-1][j][1]+dp[i-1][j][2];//세로로 들어옴(세로, 대각선)
					
					if(arr[i-1][j]!=1&&arr[i][j-1]!=1) dp[i][j][2]=dp[i-1][j-1][0]+dp[i-1][j-1][1]+dp[i-1][j-1][2];//대각선으로 들어옴
					else dp[i][j][2]=0;
				}
			}//end for
		}//end for
		
		bw.write(Integer.toString(dp[N][N][0]+dp[N][N][1]+dp[N][N][2]));
		bw.flush();
	}//end main

}