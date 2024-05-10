import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int[] arr = { 1, 1, 2, 2, 2, 8 };

		String[] in = br.readLine().split(" ");
		for (int i = 0; i < 6; i++) {
			arr[i] = arr[i] - Integer.parseInt(in[i]);

		}
		for (int i : arr) {
			System.out.print(i + " ");
		}
	}

}

