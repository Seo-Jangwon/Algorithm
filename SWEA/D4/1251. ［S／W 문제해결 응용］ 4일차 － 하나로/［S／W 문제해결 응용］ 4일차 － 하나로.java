import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
	
static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		int T=Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++)
		{	
			int N=Integer.parseInt(br.readLine());
			long[]X=new long[N];
			long[]Y=new long[N];
			double[][]lens=new double[N][N];//거리 저장할 배열
			double[]minEdge=new double[N];//비트리 정점 기준으로 트리 정점과 연결 시 최소간선비용
			boolean[]v=new boolean[N];//트리 정점 여부 체크
			
			
			String[]Yin=br.readLine().split(" ");//y좌표 입력
			String[]Xin=br.readLine().split(" ");//x좌표 입력
			double E=Double.parseDouble(br.readLine());//E입력
			
			for(int i=0;i<N;i++) {
				Y[i]=Long.parseLong(Yin[i]);
				X[i]=Long.parseLong(Xin[i]);
				minEdge[i]=Double.MAX_VALUE;//최소값 갱신 위해 max로 초기화
			}//end for
			
			minEdge[0]=0;//임의의 시작점 0을 위해 처리
			double result=0;//최소 신장트리 비용
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(i!=j) {
						lens[i][j]=lens[j][i]=Math.pow(X[i]-X[j],2)+Math.pow(Y[i]-Y[j],2);
					}
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
