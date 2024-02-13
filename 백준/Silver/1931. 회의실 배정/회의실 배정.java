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
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N=Integer.parseInt(br.readLine());
		int[][] times=new int[N][2];//끝시간, 시작시간 순으로 저장
		
		for(int i=0;i<N;i++) {
			String[]input =br.readLine().split(" ");
			
			times[i][1]=Integer.parseInt(input[0]);
			times[i][0]=Integer.parseInt(input[1]);
		}//end for
		
		Arrays.sort(times, (o1, o2) -> {
			// TODO Auto-generated method stub
			if(o1[0]==o2[0]) {
				return (o1[1]-o2[1]);
			}
			else {
				return o1[0]-o2[0];
			}
			
		});
		
		int cnt=1;
		int endTime=times[0][0];
		for(int i=1;i<N;i++) {
			if(times[i][1]>=endTime) {
				//System.out.println("시작 : "+times[i][1]+", 끝 : "+times[i][0]);
				endTime=times[i][0];
				cnt+=1;
			}
		}
		bw.write(Integer.toString(cnt));
		bw.flush();
		
	}//end main

}