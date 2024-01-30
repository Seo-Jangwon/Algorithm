import java.util.Scanner;

public class Main {
	static int n,m;
	static int[] arr;
	static boolean[] v;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		n=sc.nextInt();
		m=sc.nextInt();


		arr=new int[m];
		v=new boolean[n+1];
		permut(0);
		
	}
	
	public static void permut(int cnt) {

		if(cnt==m) {
			for(int v:arr)
				System.out.print(v + " ");
			System.out.println();
			return;
		}
		
		for(int i=1;i<n+1;i++) {
			if(v[i]!=true) {
				v[i]=true;
				arr[cnt]=i;
				permut(cnt+1);
				v[i]=false;
			}else {
				continue;
			}
			
		}
		
	}
}