import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	
	
	static Stack<String> stack=new Stack<String>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		int T=Integer.parseInt(br.readLine());
		
		for(int tc=0;tc<T;tc++) {
			StringBuilder sb=new StringBuilder();
			String[] input =br.readLine().split(" ");
			int len=input.length;
			
			for(int i=0;i<len;i++) {
				int partLen=input[i].length();
				
				for(int j=partLen-1;j>=0;j--) {
					sb.append(input[i].charAt(j));
				}
				sb.append(" ");
				
			}//end for
			bw.write(sb.toString());
			bw.flush();
		}//end for tc
	}//end main

}