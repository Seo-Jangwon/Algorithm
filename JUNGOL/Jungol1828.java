import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StreamCorruptedException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		int N=Integer.parseInt(br.readLine());
		int[][] ci=new int[N][2];
		int[] refrigerator=new int[10271];
		int count=0;
		
		for(int i=0;i<N;i++) {
			String[] input=br.readLine().split(" ");
			ci[i][0]=Integer.parseInt(input[0]);//최저 보관 온도
			ci[i][1]=Integer.parseInt(input[1]);//최고 보관 온도
		}//end for
		
		Arrays.sort(ci, (o1, o2) -> {
			// TODO Auto-generated method stub
			if(o1[0]==o2[0]) {
				return (o1[1]-o2[1]);
			}
			else {
				return o1[0]-o2[0];
			}
			
		});
		int min=ci[0][0];
		int max=ci[0][1];
		//System.out.println("min : "+min+" max : "+max);
		for(int i=1;i<N;i++) {
			if(min<=ci[i][0]&&ci[i][0]<=max) {
				min=ci[i][0];
				if(max>=ci[i][1]) {max=ci[i][1];}
			}else {
				//System.out.println("cnt+1");
				count+=1;
				min=ci[i][0];
				max=ci[i][1];
			}
			//System.out.println("min : "+min+" max : "+max);
		}//end for
		System.out.println(count+1);
	}//end main

}
