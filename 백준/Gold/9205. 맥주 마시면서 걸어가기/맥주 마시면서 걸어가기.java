import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		int T=Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++)
		{
			int nConv = Integer.parseInt(br.readLine());
			int N=nConv+2;
			
			int[][]map=new int [N][N];//플로이드 워셜을 위한 지도. 0,0은 집, N-1,N-1은 페스티벌
			ArrayList<Point> list=new ArrayList<Point>();//각 지점들을 위한 리스트
			
			
			
			String[] houseIn=br.readLine().split(" ");//집 좌표 입력
			list.add(new Point(Integer.parseInt(houseIn[0]), Integer.parseInt(houseIn[1])));
			
			for(int i=0;i<nConv;i++) {
				String[] convIn=br.readLine().split(" ");//편의점 좌표 입력
				list.add(new Point(Integer.parseInt(convIn[0]), Integer.parseInt(convIn[1])));
			}
			
			String[] pentaIn=br.readLine().split(" ");//페스티벌 좌표 입력
			list.add(new Point(Integer.parseInt(pentaIn[0]), Integer.parseInt(pentaIn[1])));
			
			
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(i==j)map[i][j]=0;//같은 위치
					else {
						map[i][j]=dist(list.get(i).y, list.get(i).x, list.get(j).y, list.get(j).x);
					}
				}
			}//end for
			
			//플로이드 워셜
			for(int k=0;k<N;k++) {
				for(int i=0;i<N;i++) {
					for(int j=0;j<N;j++) {
						map[i][j]=Integer.min(map[i][j], Integer.max(map[i][k],map[k][j]));
					}
				}
			}//end F.W.
			
			
			String ans="happy";
			if(map[0][N-1]>1000) {
				ans="sad";
			}
			
			bw.write(ans);
			bw.newLine();
			bw.flush();
			
		}//end for tc
	}
	
	static int dist(int startY, int startX, int endY, int endX) {
		return Math.abs(startY-endY)+Math.abs(startX-endX);
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
