import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Solution {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb=new StringBuilder();
	
	public static void main(String args[]) throws Exception
	{
		
		int T=10;
		for(int test_case = 1; test_case <= T; test_case++)
		{
			LinkedList<String> list=new LinkedList<String>();
			
			int N=Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int i=0;i<N;i++) {//원본 입력
				list.add(st.nextToken());
			}
			
			
			int I=Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			
			for(int i = 0;i<I;i++) {
				if(st.nextToken().equals("I")) {
					int x = Integer.parseInt(st.nextToken());
					int y = Integer.parseInt(st.nextToken());
					
					for(int j = 0;j<y;j++) {
						list.add(x,st.nextToken());
						x++;
					}
				}
				
			}
			bw.write("#"+Integer.toString(test_case));
			for(int i=0;i<10;i++) {
				bw.write(" "+list.get(i));
			}
			bw.newLine();
			bw.flush();
		}
	}
}