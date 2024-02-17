import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Solution {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	
	static int[] number;
	static boolean[] vNumber;
	static int[] operator;
	static int N;
	
	static int max, min;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		int T=Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++)
		{
			max=Integer.MIN_VALUE;
			min=Integer.MAX_VALUE;
			
			N=Integer.parseInt(br.readLine());
			number=new int[N];
			vNumber=new boolean[N];
			operator=new int[4];

			String[] inputO=br.readLine().split(" ");
			for(int i=0;i<4;i++) {
				operator[i]=Integer.parseInt(inputO[i]);
			}//end for
			
			String[] inputN=br.readLine().split(" ");
			for(int i=0;i<N;i++) {
				number[i]=Integer.parseInt(inputN[i]);
			}//end for
			

			dfs(1, number[0]);

			bw.write("#"+tc+" "+Integer.toString(max-min));
			bw.newLine();
			bw.flush();
			
		}//end TC
		bw.close();
	}//end main
	
	static void dfs(int dep, int num) {
		if(dep==N) {
//			System.out.println("num : "+(int)num);
			if(num>max) {
				max=num;
			}
			if(num<min) {
				min=num;
			}
			return;
		}//end if
		
		if(operator[0]>0) {// +
			operator[0]-=1;//연산자 -1
			dfs(dep+1,num+number[dep]);
			operator[0]+=1;//복구
		}
		if(operator[1]>0) {// -
			operator[1]-=1;//연산자 -1
			dfs(dep+1,num-number[dep]);
			operator[1]+=1;//복구
		}
		if(operator[2]>0) {// *
			operator[2]-=1;//연산자 -1
			dfs(dep+1,num*number[dep]);
			operator[2]+=1;//복구
		}
		if(operator[3]>0) {// /
			operator[3]-=1;//연산자 -1
			dfs(dep+1,num/number[dep]);
			operator[3]+=1;//복구
		}	
	}//end dfs 
	
}