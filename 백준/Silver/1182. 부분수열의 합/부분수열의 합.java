import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int n, s, arr[], count;
	static boolean v[];
	
	
	public static void main(String[] args) throws IOException {
		String[] input=br.readLine().split(" ");
		n=Integer.parseInt(input[0]);
		s=Integer.parseInt(input[1]);
		
		v=new boolean[n];
		String[] integers=br.readLine().split(" ");
		arr=new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=Integer.parseInt(integers[i]);
		}
		
		count=0;
		find(0,0);
		if(s==0) {
			count-=1;
		}
		bw.write(Integer.toString(count));
		bw.newLine();
		bw.flush();
		bw.close();
	}
	public static void find(int sum, int depth) {
		if(depth==n) {
			if(sum==s) {
				count++;
			}
			return;
		}
		find(sum,depth+1);
		find(sum+arr[depth],depth+1);
//		else {
//			for(int i=0;i<n;i++) {
//				if(v[i]==false) {
//				v[i]=true;
//				find(sum+arr[i]);
//				v[i]=false;
//				}
//			}
			
//		}
	}
}
