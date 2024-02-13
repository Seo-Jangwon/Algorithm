import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String[] in1=br.readLine().split(" ");
		int N=Integer.parseInt(in1[0]);
		int L=Integer.parseInt(in1[1]);
		int[]fruits=new int[N];
		
		String[] in2=br.readLine().split(" ");
		for(int i=0;i<N;i++) {
			fruits[i]=Integer.parseInt(in2[i]);
		}
		
		Arrays.sort(fruits);
		
		for(int i=0;i<N;i++) {
			if(fruits[i]<=L) {
				L+=1;
			}else {
				break;
			}
		}
		System.out.println(L);
	}

}
