import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[] arr;
	static long n, p, q;

	static HashMap<Long, Long> map;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String[] in = br.readLine().split(" ");
		n = Long.parseLong(in[0]);
		p = Long.parseLong(in[1]);
		q = Long.parseLong(in[2]);

		map = new HashMap<>();
		map.put((long) 0, (long) 1);

		System.out.println(dfs(n));

	}

	public static Long dfs(long n) {
		if (n == 0)
			return map.get(n);
		long first;
		long second;
		if (map.containsKey(n / p)) {
			first = map.get(n / p);
		} else {
			first = dfs(n / p);
		}
		
		if (map.containsKey(n / q)) {
			second = map.get(n / q);
		} else {
			second = dfs(n / q);
		}
		map.put(n, first + second);
		return first + second;
	}

}