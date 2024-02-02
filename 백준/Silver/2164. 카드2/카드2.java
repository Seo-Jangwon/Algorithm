import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		LinkedList<Integer> arr= new LinkedList<>();
		int n=Integer.parseInt(br.readLine());
		
		for(int i=n;i>0;i--) {
			arr.add(i);
		}
		
		while(arr.size()>0) {
			if(arr.size()==1) {
				break;
			}
			
			arr.remove(arr.size()-1);
			
			int temp1=arr.get(arr.size()-1);
			arr.remove(arr.size()-1);
			arr.addFirst(temp1);
			
			
		}
		bw.write(Integer.toString(arr.get(0)));
		bw.flush();
		bw.close();
		
	}
}