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
		arr[1]=0;
		if(N>1) {
			for(int i=2;i<=N;i++) {
				if(i==2||i==3) {
					arr[i]=1;
				}//end if
				else {
					int case1,case2,case3;
					case1=case2=case3=Integer.MAX_VALUE;
			
					case1=1+arr[i-1];//1빼는경우
			
					if(i%2==0) case2=1+arr[i/2];
					if(i%3==0) case3=1+arr[i/3];
				
					int tempMin=case1>=case2?case2:case1;
					arr[i]=tempMin>=case3?case3:tempMin;
				}
			}//end for
		}
		bw.write(Integer.toString(arr[N]));
		bw.flush();
	}//end main

}