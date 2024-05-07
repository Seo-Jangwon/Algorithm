import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;

	static int n;
	static int[] arr;
	static int[] oper;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		oper = new int[4];// +,-,×,÷

		String[] in1 = br.readLine().split(" ");
		String[] in2 = br.readLine().split(" ");

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(in1[i]);
		}

		for (int i = 0; i < 4; i++) {
			oper[i] = Integer.parseInt(in2[i]);
		}
		dfs(0, arr[0]);

		System.out.println(max);
		System.out.println(min);
	}

	static void dfs(int dep, int result) {
		if (dep == n - 1) {
			if (result > max)
				max = result;
			if (result < min)
				min = result;
			return;
		}

		for (int i = 0; i < 4; i++) {
			if (oper[i] > 0) {
				switch (i) {
				case 0:// +
					oper[i] -= 1;
					dfs(dep + 1, result + arr[dep + 1]);
					oper[i] += 1;
					break;
				case 1:// -
					oper[i] -= 1;
					dfs(dep + 1, result - arr[dep + 1]);
					oper[i] += 1;
					break;
				case 2:// *
					oper[i] -= 1;
					dfs(dep + 1, result * arr[dep + 1]);
					oper[i] += 1;
					break;
				case 3:// %
					oper[i] -= 1;
					dfs(dep + 1, result / arr[dep + 1]);
					oper[i] += 1;
					break;
				}

			}
		}

	}

}
