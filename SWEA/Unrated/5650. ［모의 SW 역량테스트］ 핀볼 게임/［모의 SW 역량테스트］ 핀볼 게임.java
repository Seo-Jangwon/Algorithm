import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	
	static int ans;
	static int N;
	static int spY, spX;
	static int[][] arr;
	static WormHole[] wormHoles;
	static ArrayList<Point> startPoints;
	
	public static void main(String args[]) throws Exception
	{
		int T=Integer.parseInt(br.readLine());

		for(int tc = 1; tc <= T; tc++)
		{
			N=Integer.parseInt(br.readLine().trim());
			
			ans=0;
			arr=new int[N][N];
			wormHoles=new WormHole[11];
			startPoints=new ArrayList<Point>();
			
			for(int i=0;i<N;i++) {
				String[] str=br.readLine().split(" ");
				for(int j=0;j<N;j++) {
					arr[i][j]=Integer.parseInt(str[j]);
					if(arr[i][j]>5) {
						if(wormHoles[arr[i][j]]==null) {
							wormHoles[arr[i][j]]=new WormHole(i, j);
						}else {
							wormHoles[arr[i][j]].y2=i;
							wormHoles[arr[i][j]].x2=j;
						}
					}
					if(arr[i][j]==0)startPoints.add(new Point(i, j));
				}
			}
			
			
			for(Point p: startPoints) {
				for(int d=0;d<4;d++) {
					spY=p.y;
					spX=p.x;
					play(spY, spX, d);
				}
			}
		
			System.out.println("#"+tc+" "+ans);
			
		}//end tc
		
		
	}//end main
	
	private static void play(int y, int x, int d) {
		
		int cnt=0;
		
		while(true) {
			
			y+=dy[d];
			x+=dx[d];
			
			if((y<0||x<0||y>=N||x>=N)||(y==spY&&x==spX)||arr[y][x]==-1) {
				if((y<0||x<0||y>=N||x>=N)) {
					cnt=(cnt+1)*2-1;
				}
				
				if(cnt>ans)ans=cnt;
				return;
			}
			
			if(arr[y][x]>0&&arr[y][x]<6) {
				switch (arr[y][x]) {
				case 1:
					
					switch (d) {
					case 0:
						d=1;
						break;
					case 1:
						d=3;
						break;
					case 2:
						d=0;
						break;
					case 3:
						d=2;
						break;
					}
					
					break;
				case 2:
					
					switch (d) {
					case 0:
						d=3;
						break;
					case 1:
						d=0;
						break;
					case 2:
						d=1;
						break;
					case 3:
						d=2;
						break;
					}
					
					break;
				case 3:
	
					switch (d) {
					case 0:
						d=2;
						break;
					case 1:
						d=0;
						break;
					case 2:
						d=3;
						break;
					case 3:
						d=1;
						break;
					}
					
					break;
				case 4:
	
					switch (d) {
					case 0:
						d=1;
						break;
					case 1:
						d=2;
						break;
					case 2:
						d=3;
						break;
					case 3:
						d=0;
						break;
					}
					
					break;
				case 5:
					
					switch (d) {
					case 0:
						d=1;
						break;
					case 1:
						d=0;
						break;
					case 2:
						d=3;
						break;
					case 3:
						d=2;
						break;
					}
	
					break;
					
				}//end switch
				cnt+=1;
				continue;
			}//벽
			if(arr[y][x]==0) {//0이면 직진
				continue;
			}
			if(arr[y][x]>5) {//웜홀
				WormHole wh=wormHoles[arr[y][x]];
				if(wh.y1==y&&wh.x1==x) { y=wh.y2; x=wh.x2; }
				else { y=wh.y1; x=wh.x1; }
				continue;
			}
			
		}//end while
	}
	
	static class WormHole{
		int y1;
		int x1;
		int y2;
		int x2;
		public WormHole(int y1, int x1) {
			super();
			this.y1 = y1;
			this.x1 = x1;
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
	}
	
}