import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	
	static Stack<String> stack=new Stack<String>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		int N=Integer.parseInt(br.readLine());
		
		for(int i=0;i<N;i++) {
			String[] input=br.readLine().split(" ");
			
			
			String opr=input[0];
			String num=null;
			if(input.length==2) {
				num=input[1];
			}
			
			if(opr.equals("push"))stack.push(num);
			if(opr.equals("top")) {
				if(stack.size()==0) bw.write("-1");
				else if(stack.size()!=0) bw.write(stack.peek());
				bw.newLine();
				bw.flush();
			}
			if(opr.equals("pop")) {
				if(stack.size()==0) bw.write("-1");
				else if(stack.size()!=0) bw.write(stack.pop());
				bw.newLine();
				bw.flush();
			}
			if(opr.equals("size")) {
				bw.write(Integer.toString(stack.size()));
				bw.newLine();
				bw.flush();
			}
			if(opr.equals("empty")) {
				if(stack.size()==0) bw.write("1");
				else if(stack.size()!=0) bw.write("0");
				bw.newLine();
				bw.flush();
			}
			
			
		}//end for
		
		bw.close();
	}//end main

}