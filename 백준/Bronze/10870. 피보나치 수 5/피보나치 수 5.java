import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int result=0;
		if(n>=2) {
			result=pivo((n-1))+pivo((n-2));
		}else if(n==1) {
			result=1;
		}else if(n==0) {
			result=0;
		}
		System.out.println(result);
	}
	public static int pivo(int i) {
		if(i==0)
			return 0;
		else if(i==1)
			return 1;
		else {
			return pivo(i-1)+pivo(i-2);
		}
	}
}