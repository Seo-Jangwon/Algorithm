import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	
	static int[] arr=new int[9];
	static int[] ans=new int[7];
	static int sum;
	
	public static void main(String[] args) throws IOException {
		for(int i=0;i<9;i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}
		comp(0,0);
		bw.close();

	}
	public static void comp(int start, int count) throws IOException {
		if(count==7) {
			if(sum==100) {
				for(int i:ans) {
					bw.write(Integer.toString(i));
					bw.newLine();
					bw.flush();
				}
			}else {
				return;				
			}
		}
		else {
			for(int i=start;i<9;i++) {
				sum+=arr[i];
				ans[count]=arr[i];
				comp(i+1,count+1);
				ans[count]=0;
				sum-=arr[i];
			}
		}
	}
}