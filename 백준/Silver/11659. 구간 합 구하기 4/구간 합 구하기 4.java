import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

	static int n, m;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String[] input1=new String[2];
		input1=br.readLine().split(" ");
		
		n=Integer.parseInt(input1[0]);
		m=Integer.parseInt(input1[1]);
		
		arr=new int[n+1];
		
		String[] input2=new String[n];
		input2=br.readLine().split(" ");
		for(int i=1;i<n+1;i++) {
			arr[i]=arr[i-1]+Integer.parseInt(input2[i-1]);
		}

		
		for(int i=0;i<m;i++) {
			String[] input3=new String[2];
			input3=br.readLine().split(" ");
			int a=Integer.parseInt(input3[0]);
			int b=Integer.parseInt(input3[1]);
			bw.write(Integer.toString(arr[b]-arr[a-1]));
			bw.newLine();
			bw.flush();
		}
	}
}