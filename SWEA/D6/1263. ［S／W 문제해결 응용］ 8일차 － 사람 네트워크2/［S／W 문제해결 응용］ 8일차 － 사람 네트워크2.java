import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		int T=Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++)
		{
			int N;
			int [][] map;
			int[] ansList;
			
			String input=br.readLine();
			StringTokenizer st=new StringTokenizer(input);
			
			N=Integer.parseInt(st.nextToken());
			map=new int[N][N];
			ansList=new int[N];
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
					if(i!=j&&map[i][j]==0)map[i][j]=N*N*N;
				}
			}//end for
			
			for(int k=0;k<N;k++) {
				for(int i=0;i<N;i++) {
					for(int j=0;j<N;j++) {
						map[i][j]=Integer.min(map[i][k]+map[k][j],map[i][j]);
						
					}
				}
			}
			
			int ans=Integer.MAX_VALUE;
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					ansList[i]+=map[i][j];
				}
				if(ans>ansList[i]) ans=ansList[i];
			}
			
			System.out.println("#"+tc+" "+ans);
			
		}//end tc
		
	}//end main

}//end class