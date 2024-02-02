import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

class Solution {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));


public static void main(String args[]) throws Exception
{
	
	int T;
	T=Integer.parseInt(br.readLine());
	/*
	   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
	*/

	for(int tc = 1; tc <= T; tc++)
	{	Stack<String>stack=new Stack<String>();
	
		String str=br.readLine();
		int l=str.length();
		int cnt=0;
		char[] list=str.toCharArray();
		
		for(int i=0;i<l;i++) {
			if(list[i]=='(') {
				stack.push("(");
			}
			else {
				if(list[i-1]=='(') {
					stack.pop();
					cnt+=stack.size();
				}
				else {
					stack.pop();
					cnt+=1;
				}
			}
		}
		bw.write("#"+Integer.toString(tc)+" "+Integer.toString(cnt));
		bw.newLine();
		bw.flush();
	}
    
}
}