import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
	
	static class Vertex implements Comparable<Vertex>{
		int no;
		int weight;
		public Vertex(int no, int weight) {
			super();
			this.no = no;
			this.weight = weight;
		}
		@Override
		public int compareTo(Vertex o) {
			return Integer.compare(this.weight, o.weight);
		}
		
	}
	
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		int T=Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++)
		{	
			int N=Integer.parseInt(br.readLine());
//			System.out.println("N : "+N);
			long[]X=new long[N];
			long[]Y=new long[N];
			double[][]lens=new double[N][N];
			double[]minEdge=new double[N];
			boolean[]v=new boolean[N];
			
			
			String[]Xin=br.readLine().split(" ");
			String[]Yin=br.readLine().split(" ");
			
			double E=Double.parseDouble(br.readLine());
			
			for(int i=0;i<N;i++) {
				Y[i]=Long.parseLong(Yin[i]);
				X[i]=Long.parseLong(Xin[i]);
				minEdge[i]=Double.MAX_VALUE;
			}//end for
			
			minEdge[0]=0;
			double result=0;
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(i!=j) {
						lens[i][j]=lens[j][i]=Math.pow(X[i]-X[j],2)+Math.pow(Y[i]-Y[j],2);
					}
				}
			}
			
			for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
			}
		}
			
			int c;
			for(c=0;c<N;c++) {
				double min=Double.MAX_VALUE;
				int minVertex=-1;
				
				for(int i=0;i<N;i++) {//모든 정점 돌며
					if(!v[i]&&minEdge[i]<min) {
						min=minEdge[i];
						minVertex=i;
					}//end if
				}//end for
				
				if(minVertex==-1)break;
				
				result+=E*min;
				v[minVertex]=true;
				
				for(int i=0;i<N;i++) {
					if(!v[i]&&lens[minVertex][i]!=0&&lens[minVertex][i]<minEdge[i]) {
						minEdge[i]=lens[minVertex][i];
					}
				}
			}//end for c
			System.out.println("#"+tc+" "+(long)(Math.round(result)));
		}//end for tc
	}//end main

}