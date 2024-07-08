import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static int N, M, A[], B;

	public static void main(String[] args) throws NumberFormatException, IOException {

		N = Integer.parseInt(br.readLine());
		A = new int[N];
		String[] in1 = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(in1[i]);
		}
		Arrays.sort(A);

		M = Integer.parseInt(br.readLine());
		String[] in2 = br.readLine().split(" ");
		for (int i = 0; i < M; i++) {
			B = Integer.parseInt(in2[i]);
			if (binary()) {
				System.out.println(1);
			} else {
				System.out.println(0);
			}
		}

	}

	static boolean binary() {
		int start = 0;
		int end = N - 1;

		while (start <= end) {
			int mid = (start + end) / 2;
			if (B < A[mid]) {
				end = mid - 1;
			} else if (B > A[mid]) {
				start = mid + 1;
			} else {
				return true;
			}
		}
		return false;
	}
}
