import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static int N;
	
	static PriorityQueue<Integer> pQueue=new PriorityQueue<>((o1, o2) -> {
		if(Math.abs(o1)==Math.abs(o2)) {//절댓값 같다면
			return o1-o2;//그대로 비교
		}else {//다르다면
			return Math.abs(o1)-Math.abs(o2);//절댓값 순으로 비교
		}
	});
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		N=Integer.parseInt(br.readLine());
		

		for(int i=0;i<N;i++) {
			int num=Integer.parseInt(br.readLine());
			
			if(num!=0) {//0이 아니면 큐에 삽입
				pQueue.offer(num);
			}
			else {
				if(pQueue.size()!=0) {//큐가 비어있지 않다면
					
					bw.write(Integer.toString(pQueue.poll()));//poll
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