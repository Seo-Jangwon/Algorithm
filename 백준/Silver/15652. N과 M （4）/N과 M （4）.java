import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static int n;
	static int m;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		String[] input=new String[2];
		input=br.readLine().split(" ");
		n=Integer.parseInt(input[0]);
		m=Integer.parseInt(input[1]);
		
		arr=new int[m];
		
		comp(0,0);
		bw.close();
		
	}
	
	public static void comp(int start, int count) throws IOException {
		if(count==m) {//깊이가 m만큼 내려오면
			for(int i:arr) {
				bw.write(Integer.toString(i)+" ");
				bw.flush();
			}
			bw.newLine();
		}
		else {
			for(int i=start;i<n;i++) {
				arr[count]=i+1;
				comp(i,count+1);
			}
		}
	}
	

}