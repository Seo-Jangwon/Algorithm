import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static int k;
	static int[] arr;
	static int[] ans;
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		while(true) {
		String[] input=new String[14];
		input=br.readLine().split(" ");
		
		
		k=Integer.parseInt(input[0]);
		if(k==0) {
			return;
		}
		
		
		arr=new int[k];
		
		
		for(int i=0;i<k;i++) {
			arr[i]=Integer.parseInt(input[i+1]);
		}
		
		
		ans=new int[6];
		comp(0,0);
		bw.newLine();;
		}
	}//main end
	
	public static void comp(int start, int count) throws IOException {

		if(count==6) {
			Arrays.sort(arr);
			for(int i:ans) {
				bw.write(Integer.toString(i)+" ");
				bw.flush();
			}
			bw.newLine();
		}//if(count==k) end
		else {
			for(int i=start;i<k;i++) {
				ans[count]=arr[i];
				comp(i+1,count+1);
			}
			
		}
	}//comp() end

}