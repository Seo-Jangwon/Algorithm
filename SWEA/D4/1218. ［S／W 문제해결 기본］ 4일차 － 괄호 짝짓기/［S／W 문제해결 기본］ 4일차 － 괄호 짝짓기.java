import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

class Solution {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		Stack<String> stack=new Stack<>();
		
		
		
		for(int tc = 1; tc <= 10; tc++)
		{
			int n=Integer.parseInt(br.readLine());
			String[] str=new String[n];
			str=br.readLine().split("");
			int ans=1;
			for(int i=0;i<n;i++) {
				if(str[i].equals("(")||str[i].equals("[")||str[i].equals("{")||str[i].equals("<") ) {
					stack.push(str[i]);
				}
				if(str[i].equals(")")||str[i].equals("]")||str[i].equals("}")||str[i].equals(">") ) {
					if(!stack.isEmpty()) {
						if(stack.peek().equals("(")) {
							if(!str[i].equals(")")) {
								ans=0;
								//System.out.println(stack.peek()+" "+str[i]+"  false");
							}
						}
						else if(stack.peek().equals("[")) {
							if(!str[i].equals("]")) {
								ans=0;
								//System.out.println(stack.peek()+" "+str[i]+"  false");
							}
						}
						else if(stack.peek().equals("{")) {
							if(!str[i].equals("}")) {
								ans=0;
								//System.out.println(stack.peek()+" "+str[i]+"  false");
							}
						}
						else if(stack.peek().equals("<")) {
							if(!str[i].equals(">")) {
								ans=0;
								//System.out.println(stack.peek()+" "+str[i]+"  false");
							}
						}
						stack.pop();
					}
				}
			}
			if(stack.size()!=0 ||ans==0) {
				bw.write("#"+Integer.toString(tc)+" "+Integer.toString(ans));
				bw.newLine();
				bw.flush();
			}else {
				bw.write("#"+Integer.toString(tc)+" "+Integer.toString(ans));
				bw.newLine();
				bw.flush();
			}
		}
	}
}
