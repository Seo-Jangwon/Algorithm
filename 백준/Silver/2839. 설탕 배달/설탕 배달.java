import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		int N=Integer.parseInt(br.readLine());
		
		int cnt=0;
		while(N>0) {
			if(N%5==0) {
				cnt+=1;
				N=N-5;
			}
			else if(N%3==0){
				cnt+=1;
				N=N-3;
			}else if(N>5){
				cnt+=1;
				N-=5;
			}else {
				cnt=-1;
				break;
			}
			
		}
		bw.write(Integer.toString(cnt));
		bw.flush();
	}

}