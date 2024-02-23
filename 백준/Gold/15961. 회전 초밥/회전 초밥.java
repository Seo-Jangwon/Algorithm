import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int N, d, k, c;
		int max=0;//최대 개수 저장
		int count=0;//n(스시 종류)
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		N=Integer.parseInt(st.nextToken());//접시 수
		d=Integer.parseInt(st.nextToken());//초밥 종류
		k=Integer.parseInt(st.nextToken());//연속해서 먹는 접시 수
		c=Integer.parseInt(st.nextToken());//쿠폰 번호
		int[] plate=new int[N];//회전판		
		
		for(int i=0;i<N;i++) {//회전판 입력
			plate[i]=Integer.parseInt(br.readLine());
		}//end for
		
		int[] sushi=new int[d+1];
		
		sushi[c]+=1;//쿠폰 반영
		count+=1;
		
		for(int i=0;i<k;i++) {
			if(sushi[plate[i]]==0)count+=1;
			sushi[plate[i]]++;
		}
		max=count;
		
		for(int i=1;i<N;i++) {
			//end 이동
			int end=(i+k-1)%N;
			if(sushi[plate[end]]==0) {
				count+=1;
			}
			sushi[plate[end]]+=1;
			
			//start 이동
			sushi[plate[i-1]]-=1;
			if(sushi[plate[i-1]]==0) {
				count-=1;
			}
			
			if(max<count) {
				max=count;
			}
			
		}//end for i
		bw.write(Integer.toString(max));
		bw.flush();
	}

}
