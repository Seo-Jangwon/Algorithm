import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static int N, ans, operLen;
	static ArrayList<Integer> nums;
	static ArrayList<Character> oper;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		N = Integer.parseInt(br.readLine());

		nums=new ArrayList<>();
		oper=new ArrayList<>();
		
		String[] str = br.readLine().split("");
		for (int i = 0; i < str.length; i++) {
			if(Character.isDigit(str[i].charAt(0))) {
				nums.add(Integer.parseInt(str[i]));
			}else {
				oper.add(str[i].charAt(0));
			}
			
		}
        
		ans=Integer.MIN_VALUE;
		operLen=oper.size();

		if (N != 1)
			dfs(nums.get(0), 0);
		if (N == 1)
			ans = nums.get(0);

		System.out.println(ans);

	}

	public static void dfs(int sum, int oppIdx) {
		if (oppIdx >= operLen) {
			if (ans < sum)
				ans = sum;
			return;
		}

		// 그냥 계산 후 넘기기
		int result1=opp(sum,oper.get(oppIdx),nums.get(oppIdx+1));
		dfs(result1,oppIdx+1);
		
		if(oppIdx+1<operLen) {
			int result2=opp(nums.get(oppIdx+1),oper.get(oppIdx+1),nums.get(oppIdx+2));
			int result3=opp(sum,oper.get(oppIdx),result2);
			dfs(result3,oppIdx+2);
		}
	}

	public static int opp(int num1, char opp, int num2) {

		int result = 0;

		switch (opp) {
		case '+':
			result = num1 + num2;
			break;
		case '-':
			result = num1 - num2;
			break;
		case '*':
			result = num1 * num2;
			break;
		}

		return result;
	}

}