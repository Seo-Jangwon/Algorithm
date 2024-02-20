import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static int[][] map;
	static int N,M,minDist;
	static ArrayList<Point> chickenHouse;
	static ArrayList<Point> house;
	
	static class Point{
		int y;
		int x;
		boolean visited;
		public Point(int y, int x) {
			super();
			this.y = y;
			this.x = x;
			this.visited=false;
		}
	}
	
	public static void main(String[] args) throws IOException {
		String[] input1=br.readLine().split(" ");
		N=Integer.parseInt(input1[0]);
		M=Integer.parseInt(input1[1]);
		minDist=Integer.MAX_VALUE;
		map=new int[N][N];
		chickenHouse=new ArrayList<Point>();
		house=new ArrayList<Point>();
		
		for(int i=0;i<N;i++) {
			String[] input2=br.readLine().split(" ");
			for(int j=0;j<N;j++) {
				map[i][j]=Integer.parseInt(input2[j]);
				if(map[i][j]==1)house.add(new Point(i, j));
				if(map[i][j]==2)chickenHouse.add(new Point(i, j));
			}//end for
		}//end for
		
		dfs(0, 0);
		bw.write(Integer.toString(minDist));
		bw.flush();
		bw.close();
		
	}//end main

	static void dfs(int dep, int index) {
		if(dep==M) {
			int dist=0;
			for(int i=0;i<house.size();i++) {
				int mindist=Integer.MAX_VALUE;
				for(int j=0;j<chickenHouse.size();j++) {
					if(chickenHouse.get(j).visited==true) {
						mindist=mindist>(Math.abs(house.get(i).x-chickenHouse.get(j).x)+Math.abs(house.get(i).y-chickenHouse.get(j).y))?(Math.abs(house.get(i).x-chickenHouse.get(j).x)+Math.abs(house.get(i).y-chickenHouse.get(j).y)):mindist;
					}
				}
				dist+=mindist;
			}
			if(minDist>dist) {
				minDist=dist;
			}
			return;
		}//end if
		
		for(int i=index;i<chickenHouse.size();i++) {
			if(chickenHouse.get(i).visited==false) {
				chickenHouse.get(i).visited=true;
				dfs(dep+1, i+1);
				chickenHouse.get(i).visited=false;
			}
		}
		
	}//end dfs
}