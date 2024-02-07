import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static int N;
	static PriorityQueue<Integer> pQueue=new PriorityQueue<>(new Comparator<Integer>() {

		@Override
		public int compare(Integer o1, Integer o2) {
			if(Math.abs(o1)==Math.abs(o2)) {
				return o1-o2;
			}else {
				return Math.abs(o1)-Math.abs(o2);
			}
		}
	});
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		N=Integer.parseInt(br.readLine());
		

		for(int i=0;i<N;i++) {
			int num=Integer.parseInt(br.readLine());
			
			if(num!=0) {
				pQueue.offer(num);
			}
			else {
				if(pQueue.size()!=0) {
					
					bw.write(Integer.toString(pQueue.poll()));
					bw.newLine();
					bw.flush();
				}else {
					bw.write("0");
					bw.newLine();
					bw.flush();
				}
			}
			
		}
	}

}
