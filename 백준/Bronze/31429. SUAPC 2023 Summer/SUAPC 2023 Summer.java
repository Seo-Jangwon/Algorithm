import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws NumberFormatException, IOException {

		// TODO Auto-generated method stub
		int[] a = { 12, 11, 11, 10, 9, 9, 9, 8, 7, 6, 6 };
		int[] b = { 1600, 894, 1327, 1311, 1004, 1178, 1357, 837, 1055, 556, 773 };
		int n = Integer.parseInt(br.readLine());
		System.out.println(a[n - 1] + " " + b[n - 1]);
	}

}
