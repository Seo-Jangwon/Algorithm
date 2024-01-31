import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int n;
	static int count;
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int tc=Integer.parseInt(br.readLine());
		for(int t=0;t<tc;t++) {
			n=Integer.parseInt(br.readLine());
			count=0;
			plus(0);
			bw.write(Integer.toString(count));
            bw.newLine();
			bw.flush();
			
		}bw.close();
	}
	public static void plus(int num){
		if(num==n) {
			count++;
			return;
		}else if(num>n) {
			return;
		}else {
			plus(num+1);
			plus(num+2);
			plus(num+3);
		}
	}
}