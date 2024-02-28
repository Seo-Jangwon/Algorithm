import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		int N=Integer.parseInt(br.readLine());
		int[] arr=new int[N+1];
		arr[0]=0;
		arr[1]=1;
		if(N>=2) {
			for(int i=2;i<=N;i++) {
				if(i==2)arr[i]=3;
				if(i>2) {
					arr[i]=(arr[i-1]+arr[i-2]*2)%10007;
				}
			}//end for
		}//end if
		bw.write(Integer.toString(arr[N]));
		bw.flush();
	}//end main

}