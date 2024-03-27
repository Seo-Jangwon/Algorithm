import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

public class Solution {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static int R,C;
	static int ans;
	
	static int[] dy = {1,-1,0,0};
	static int[] dx = {0,0,-1,1};
	
	static String[][] Map;
	static LinkedList<String> list;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		int T=Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++)
		{
			String[]in1=br.readLine().split(" ");
			R=Integer.parseInt(in1[0]);
			C=Integer.parseInt(in1[1]);
			
			list=new LinkedList<String>();
			Map=new String[R][C];
			ans=0;
			
			for(int i=0;i<R;i++) {
				String[]in2=br.readLine().split("");
				for(int j=0;j<C;j++) {
					Map[i][j]=in2[j];
				}
			}//end for
			
			list.push(Map[0][0]);
			dfs(0,0,1);
			
			bw.write("#"+Integer.toString(tc)+" "+Integer.toString(ans));
			bw.newLine();
			bw.flush();
			
		}//end for tc
	}//end main

	public static void dfs(int y, int x, int dep) {
		for(int d=0;d<4;d++) {
			int ny=y+dy[d];
			int nx=x+dx[d];
			if(ny>=0&&nx>=0&&ny<R&&nx<C&&!list.contains(Map[ny][nx])) {
				list.push(Map[ny][nx]);
				dfs(ny, nx, dep+1);
				list.remove(Map[ny][nx]);
			}//end if
		}//end for d
		
		if(ans<dep) {
			ans=dep;
		}
	}
}
