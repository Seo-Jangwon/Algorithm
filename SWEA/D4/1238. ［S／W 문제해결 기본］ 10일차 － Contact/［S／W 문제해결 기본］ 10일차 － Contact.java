import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Solution {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		for(int tc = 1; tc < 11; tc++)
		{
			
            int N, start, ans=0;
			int[][] map=new int[101][101];
			boolean[]V=new boolean[101];
			
			StringTokenizer st;
            st=new StringTokenizer(br.readLine());
			N=Integer.parseInt(st.nextToken());
			start=Integer.parseInt(st.nextToken());
			
			
			st=new StringTokenizer(br.readLine());
			for(int idx=0;idx<N/2;idx++) {
				int i=Integer.parseInt(st.nextToken());
				int j=Integer.parseInt(st.nextToken());
				map[i][j]=1;
			}//end for i
			
			Queue<Integer> q =new LinkedList<>();
			q.offer(start);
			V[start]=true;
			
			while(!q.isEmpty()) {
				int qSize=q.size();
				int max=0;
				
				while(qSize-->0) {
					int tmp=q.poll();
					if(tmp>max) {
						max=tmp;
					}
					for(int i=1;i<101;i++) {
						if(map[tmp][i]==1&&!V[i]) {
							q.offer(i);
							V[i]=true;
						}
					}
				}
				ans=max;
			}

			System.out.println("#"+tc+" "+ans);
		
		}//end for tc
        return;
	}//end main

	
}
