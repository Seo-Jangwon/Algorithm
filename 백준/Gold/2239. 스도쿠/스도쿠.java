import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	
	static int[][]map;
	static int[] isUsed;
	static ArrayList<Point> zeroList;
	static int listSize;

	public static void main(String[] args) throws IOException {
		map=new int[9][9];
		zeroList=new ArrayList<Point>();
		
		for(int i=0;i<9;i++) {
			String[] in1=br.readLine().split("");
			for(int j=0;j<9;j++) {
				map[i][j]=Integer.parseInt(in1[j]);
				if(map[i][j]==0) zeroList.add(new Point(i, j));
			}
		}//end for i
		
		listSize=zeroList.size();
		dfs(0);

	}//end main
	
	public static void dfs(int dep) {
		if(dep==listSize) {
			
			for(int i=0;i<9;i++) {
				for(int j=0;j<9;j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
			
			System.exit(0);
		}
		
		int ni = zeroList.get(dep).i;
		int nj = zeroList.get(dep).j;
		
		
		boolean[] check=new boolean[10];
		
		
		for(int i=0;i<9;i++) {
			if(map[ni][i]!=0) {
				check[map[ni][i]]=true;
			}//end if
			
			if(map[i][nj]!=0) {
				check[map[i][nj]]=true;
			}//end if
		}//end for
		
		int recI=(ni/3)*3;
		int recJ=(nj/3)*3;
		for(int i=recI; i<recI+3;i++) {
			for(int j=recJ; j<recJ+3;j++) {
				if(map[i][j]!=0) {
					check[map[i][j]]=true;
				}
			}
		}
		
		for(int i=1;i<=9;i++) {
			if(!check[i]) {
				map[ni][nj]=i;
				dfs(dep+1);
				map[ni][nj]=0;
			}
		}
		
	}//end dfs
	
	static class Point{
		int i;
		int j;
		public Point(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}
	}//end Point
}
