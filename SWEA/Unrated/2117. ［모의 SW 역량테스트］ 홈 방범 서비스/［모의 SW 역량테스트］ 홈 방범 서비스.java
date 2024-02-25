import java.awt.PrintGraphics;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;


class Solution {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static int N,M;
	static int limitK;
	static int maxHouse;
	static int[]di= {1,-1,0,0};
	static int[]dj= {0,0,1,-1};
	static int[][]map;
	static boolean[][]v;
	static LinkedList<Point>points;
	
	static class Point{
		int i;
		int j;
		public Point(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		int T=Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++)
		{
			String[]in1=br.readLine().split(" ");
			N=Integer.parseInt(in1[0]);//도시의 크기 (5 ≤ N ≤ 20)
			M=Integer.parseInt(in1[1]);//집이 지불하는 비용 (1 ≤ M ≤ 10)
			limitK=Math.round(N/2);//k가 커질 수 있는 최대값
			maxHouse=0;
			
			map=new int[N][N];//집: 1, 나머지: 0
			v=new boolean[N][N];//방문 체크 배열
			points=new LinkedList<Point>();
			
			for(int i=0;i<N;i++) {
				String[]in2=br.readLine().split(" ");
				for(int j=0;j<N;j++) {
					map[i][j]=Integer.parseInt(in2[j]);
					if(map[i][j]==1) {points.add(new Point(i, j));}
				}//end for j
			}//end for i
			
			/*
			 * 운영 비용 = K * K + (K - 1) * (K - 1)
			 * 홈방범 서비스를 제공받는 집들은 각각 M의 비용을 지불할 수 있음.
			 * 보안회사에서는 손해를 보지 않는 한 최대한 많은 집에 홈방범 서비스를 제공하려고 함.
			 * 손해를 보지 않으면서 홈방범 서비스를 가장 많은 집들에 제공하는 서비스 영역을 찾고
			 * 그 때의 홈방범 서비스를 제공 받는 집들의 수를 출력
			 * */

			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					for(int K=1;K<=N+1;K++) {
						int opMoney=K*K+(K-1)*(K-1);
						int numHouse=0;
								
						for(Point p:points) {
							if((int)Math.abs(p.i-i)+(int)Math.abs(p.j-j)>=K) continue;//집이 범위 밖이면 continue
							numHouse+=1;//범위 안이면 집 개수 +1
						}
						
						if(numHouse*M>=opMoney) {
							if(maxHouse<numHouse) {
								maxHouse=numHouse;
							}
						}
						
					}//end for K
				}//end for j
			}//end for i
			
			bw.write("#"+Integer.toString(tc)+" "+Integer.toString(maxHouse));
			bw.newLine();
			bw.flush();
			
		}//end tc
	}//end main
	
}