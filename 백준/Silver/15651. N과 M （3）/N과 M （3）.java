import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	static int n,m;
	static int[] arr;
	static BufferedWriter bw;
	static StringBuilder sb=new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Scanner sc=new Scanner(System.in);
		
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());

		arr=new int[m];
		permut(0);
		System.out.print(sb);
	}
	
	public static void permut(int cnt) throws IOException {

		if(cnt==m) {
			for(int i=0;i<m;i++) {
				sb.append(arr[i]).append(" ");
				
				}
			sb.append("\n");
				
			return;
		}
		
		for(int i=1;i<n+1;i++) {
			arr[cnt]=i;
			permut(cnt+1);
		}
		
	}
}