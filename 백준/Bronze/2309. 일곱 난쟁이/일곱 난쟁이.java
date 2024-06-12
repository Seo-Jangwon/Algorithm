import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static int ten[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		ten = new int[9];
		int ans[] = new int[7];

		for (int i = 0; i < 9; i++) {
			ten[i] = Integer.parseInt(br.readLine());
		}

		int[] seven = new int[7];
		choose(0, 0, seven);

	}

	static void choose(int cnt, int idx, int[] seven) {
		if (cnt == 7) {
			int sum = 0;
			for (int i = 0; i < 7; i++) {
				sum += seven[i];
			}
			if (sum == 100) {
				Arrays.sort(seven);
				for (int j = 0; j < 7; j++) {
					System.out.println(seven[j]);
				}
				System.exit(0);
			}
			return;
		}

		for (int i = idx; i < 9; i++) {
			seven[cnt] = ten[i];
			choose(cnt + 1, i + 1, seven);
		}
		return;

	}

}