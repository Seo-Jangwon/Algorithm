import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	public static boolean isInteger(String value) {
		boolean check=true;
		String[] opr= {"+","-","*","/"};
		for(String s:opr) {
			if(value.contains(s)) {
				check=false;
			}
		}
		return check;
	}
	
//	class Solution
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		
		for(int tc = 1; tc <= 10; tc++)
		{
		
			int N=Integer.parseInt(br.readLine());
			//System.out.println("N" + N);
			int[] arr=new int[N+1];
			int idx=0;
			String opr;
			int son1=0;
			int son2=0;
			String ans="1";
			int num=0;
			
			for(int i=0;i<N;i++) {
				String[] input=br.readLine().split(" ");
				
				if(input.length==4) {
					
					idx=Integer.parseInt(input[0]);
					
					opr=input[1];
					if(isInteger(opr)==true) {
						ans="0";//break;
					}
					
					son1=Integer.parseInt(input[2]);
					if(idx*2!=son1) {
						ans="0";//break;
					}//end if son1
					
					son2=Integer.parseInt(input[3]);
					if(idx*2+1!=son2) {
						ans="0";//break;
					}//end if son2
				}//end if
				
				if(input.length==2) {
					if(isInteger(input[1])==false) {
						ans="0";//break;
					}
				}//end if
				
			}//end for
			
			bw.write("#"+Integer.toString(tc)+" "+ans);
			bw.flush();
			bw.newLine();
		}
		
	}

}