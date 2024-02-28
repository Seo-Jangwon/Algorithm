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
		int ansN=N;
		String ans="";
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
			ans+=N;
			while(N>1) {
				int case1,case2,case3, min;
				case1=case2=case3=Integer.MAX_VALUE;
				if(N%3==0) {case1=arr[N/3];}
				if(N%2==0) {case2=arr[N/2];}
				case3=arr[N-1];
				int tempMinIdx=Integer.MAX_VALUE;
				if(!(case1==Integer.MAX_VALUE&&case2==Integer.MAX_VALUE)){
					tempMinIdx=case1>=case2?N/2:N/3;
				}
				if(tempMinIdx!=Integer.MAX_VALUE) {
					min=arr[tempMinIdx]>=case3?N-1:tempMinIdx;
				}else min=N-1;
				N=min;
				ans+=" "+min;
			}
		}else {ans+=ansN;}
		
		bw.write(Integer.toString(arr[ansN]));
		bw.newLine();
		bw.write(ans);
		bw.flush();
	}//end main
    
}