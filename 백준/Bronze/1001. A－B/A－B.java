import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int a, b;
		String[] in = br.readLine().split(" ");
		a = Integer.parseInt(in[0]);
		b = Integer.parseInt(in[1]);
		System.out.println(a-b);
	}

}
