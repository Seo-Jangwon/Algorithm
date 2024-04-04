import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	
	static int[][]arr;
	static int[] paper;
	static int ans;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		arr=new int[10][10];
		paper=new int[6];
		paper[1]=5;paper[2]=5;paper[3]=5;paper[4]=5;paper[5]=5;
		
		for(int i=0;i<10;i++) {
			String[] in=br.readLine().split(" ");
			for(int j=0;j<10;j++) {
				arr[i][j]=Integer.parseInt(in[j]);
			}
		}//end for
		
		ans=Integer.MAX_VALUE;
		dfs(0,0);
		
		if(ans==Integer.MAX_VALUE)ans=-1;
		System.out.println(ans);
		
	}//end main
	
	static void dfs(int dep, int cnt) {
		if(cnt>ans)return;
		if(dep==100) {
			boolean isOk=true;
			for(int i=0;i<10;i++) {
				for(int j=0;j<10;j++) {
					if(arr[i][j]==1)isOk=false;
				}
			}
			if(isOk&&cnt<ans) {
				ans=cnt;
			}
			return;
		}//종료조건
		
		int y=dep/10;
		int x=dep%10;
		
		
		if(arr[y][x]!=1) dfs(dep+1, cnt);
		
		for(int a=1;a<6;a++) {
			if(checkArea(y,x,a)&&paper[a]>0) {
				setArea(y,x,a,5);
				paper[a]-=1;
				dfs(dep+a,cnt+1);
				paper[a]+=1;
				setArea(y,x,a,1);
			}
		}
		
	}
	
	static boolean checkArea(int y, int x, int A) {
		if(y+A>10||x+A>10)return false;
		for(int i=0; i<A; i++) {
			for(int j=0;j<A;j++) {
				if(arr[y+i][x+j]!=1) {
					return false;
				}
			}
		}
		return true;
	}
	
	static void setArea(int y, int x, int A, int set) {
		for(int i=0; i<A; i++) {
			for(int j=0;j<A;j++) {
				arr[y+i][x+j]=set;
			}
		}
	}
	
	static class Point{
		int y;
		int x;
		public Point(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}//end Point
	
}
