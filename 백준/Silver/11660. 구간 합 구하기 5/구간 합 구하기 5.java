import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb;
	
	static int N,M;
	static ArrayList<Point> list;
	static int[][] arr;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String in1=br.readLine();
		st=new StringTokenizer(in1);
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		list=new ArrayList<Point>();
		
		arr=new int[N+1][N+1];
		for(int i=1;i<N+1;i++) {
			String in2=br.readLine();
			st=new StringTokenizer(in2);
			for(int j=1;j<N+1;j++) {
				arr[i][j]=arr[i][j-1]+Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0;i<M;i++) {
			String in3=br.readLine();
			st=new StringTokenizer(in3);
			list.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		sb=new StringBuilder();
		for(Point p:list) {
			sb.append(Integer.toString(sum(p))+"\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		
	}//end main
	
	static int sum(Point p) {
		int sum=0;
		for(int i=p.x1;i<=p.x2;i++) {
			sum+=arr[i][p.y2];
		}
		for(int i=p.x1;i<=p.x2;i++) {
			sum-=arr[i][p.y1-1];
		}
		return sum;
	}
	
	static class Point{
		int y1;
		int x1;
		int y2;
		int x2;
		public Point(int x1, int y1,int x2, int y2) {
			super();
			this.y1 = y1;
			this.x1 = x1;
			this.y2 = y2;
			this.x2 = x2;
		}
	}//end class
}
