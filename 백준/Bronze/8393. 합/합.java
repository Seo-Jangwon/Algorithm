import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		int n=Integer.parseInt(br.readLine());
		
		int sum=0;
		for(int i=1;i<=n;i++) {
			sum+=i;
		}
		System.out.println(sum);
	}

}