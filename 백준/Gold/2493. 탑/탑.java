import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Stack;

public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb=new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		int n=Integer.parseInt(br.readLine());
		String[] input=new String[n];
		Stack<Integer> stack=new Stack<Integer>();
		int[] arr=new int[n];
		int[] ans=new int[n];
		
		input=br.readLine().split(" ");
		for(int i=n-1;i>=0;i--) {//오른쪽에서 왼쪽으로
			arr[i]=Integer.parseInt(input[i]);
		}
		
		for(int i=n-1;i>=0;i--) {//오른쪽에서 왼쪽으로
			
			if(stack.size()!=0 &&arr[stack.peek()]<arr[i]) {//스택 사이즈가 0이 아니고 지금 탑의 높이가 스택에 있는 인덱스의 탑 높이보다 높으면 
				while(stack.size()!=0) {
					if(arr[stack.peek()]<arr[i])// 지금 탑의 높이가 스택에 있는 인덱스의 탑 높이보다 높으면 
						ans[stack.pop()]=i+1; //pop 후 인덱스 저장
					else {break;}
				}//end while
			}//end if
			
			stack.push(i);
		}//end for
		
		
		for(int a:ans) {
			sb.append(Integer.toString(a)+" ");
		}
		sb.deleteCharAt(sb.length() - 1);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}
}