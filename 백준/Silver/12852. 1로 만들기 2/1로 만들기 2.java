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
			
			ans+=N;//정답에 N 추가해주고
			while(N>1) {//N이 1보다 클때까지
				int case1,case2,case3, min;
				case1=case2=case3=Integer.MAX_VALUE;
				
				if(N%3==0) {case1=arr[N/3];}
				if(N%2==0) {case2=arr[N/2];}
				case3=arr[N-1];
				
				int tempMinIdx=Integer.MAX_VALUE;
				if(!(case1==Integer.MAX_VALUE&&case2==Integer.MAX_VALUE)){//둘다 나눠떨어지지 않는 경우가 아니라면
					tempMinIdx=case1>=case2?N/2:N/3;
				}
				if(tempMinIdx!=Integer.MAX_VALUE) {//2, 3으로 나눠떨어지지 않는 경우가 아니라면
					min=arr[tempMinIdx]>=case3?N-1:tempMinIdx;
				}else min=N-1;//나눠 떨어지지 않는다면
				N=min;//N값 최신화
				ans+=" "+min;
			}
		}else {ans+=ansN;}
		
		bw.write(Integer.toString(arr[ansN]));
		bw.newLine();
		bw.write(ans);
		bw.flush();
	}//end main

}