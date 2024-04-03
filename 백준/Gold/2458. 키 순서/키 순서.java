import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	

	
	static int N,M;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String[] in1= br.readLine().split(" ");
		N=Integer.parseInt(in1[0]);
		M=Integer.parseInt(in1[1]);
		
		int[][] arr=new int[N+1][N+1];
		for(int i=1;i<N+1;i++) {
			Arrays.fill(arr[i], 10000);
		}
		
		
		for(int i=0;i<M;i++) {
			String[] in2= br.readLine().split(" ");
			arr[Integer.parseInt(in2[0])][Integer.parseInt(in2[1])]=1;
		}
		
		for(int k=1;k<N+1;k++) {
			for(int i=1;i<N+1;i++) {
				for(int j=1;j<N+1;j++) {
					if((arr[i][k]==1&&arr[k][j]==1)) {
						arr[i][j]=1;
					}
				}
			}
		}
		
		int ans=0;
		int[] cnt = new int[N+1];
		for(int i=1; i<N+1; i++) {
			for(int j=1; j<N+1; j++) {
                if(arr[i][j]==1 || arr[j][i]==1) {
					cnt[i] ++;
					if(cnt[i]==N-1)ans++;
				}
			}
		}
		
		bw.write(Integer.toString(ans));
		bw.flush();
	}

}