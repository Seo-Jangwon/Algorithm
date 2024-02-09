import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T=Integer.parseInt(br.readLine());
		
		for(int tc=0;tc<T;tc++) {
			Stack<String> stack=new Stack<String>();
			String ans="YES";
			String[] input=br.readLine().split("");
			int len=input.length;
			
			for(int i=0;i<len;i++) {
				if(input[i].equals("("))stack.push("(");// ( 라면 스택에 push
				if(input[i].equals(")")){// ) 라면 스택에서 꺼내기
					if(stack.size()==0) { ans="NO";} //스택이 비어있다면 틀린거
					else if(stack.size()!=0) {stack.pop();}//비어있지 않다면 pop
				}
			}//end for i
			if(stack.size()!=0) {ans="NO";}
			bw.write(ans);
			bw.newLine();
			bw.flush();
		}//end for
		bw.close();
	}//end main
	
}