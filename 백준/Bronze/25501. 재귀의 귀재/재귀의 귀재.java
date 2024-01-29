import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		for(int i=0;i<n;i++) {
			String str=sc.next();
			
			int[] ans=new int[2];
			ans=isPalindrome(str,0,str.length()-1,1);
			System.out.println(ans[0]+" "+ans[1]);
		}
	}//main
	
	public static int[] isPalindrome(String s, int l, int r,int cnt) {
		int[] temp=new int[2];
		if(l >= r) {
			temp[0]=1;
			temp[1]=cnt;
			return temp;
		}
        else if(s.charAt(l) != s.charAt(r)) {
        	temp[0]=0;
			temp[1]=cnt;
			return temp;
        }
        else return isPalindrome(s, l+1, r-1,cnt+1);
	}

}