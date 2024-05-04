import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int A=Integer.parseInt(br.readLine());
		int B=Integer.parseInt(br.readLine());
		
		bw.write(Integer.toString(A+B));
		bw.flush();
		bw.close();

	}

}