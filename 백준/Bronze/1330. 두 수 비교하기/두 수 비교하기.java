import java.io.IOException;
import java.util.Scanner;

public class Main {
	static int n, m;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		n=in.nextInt();
		m=in.nextInt();
		
		if(n>m)System.out.println(">");
		if(n<m)System.out.println("<");
		if(n==m)System.out.println("==");
	}

}