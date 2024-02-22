import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Solution {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static int N, M, cnt;
	static int[] parent;
	static int[] check;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		int T=Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++)
		{
			String[] input1=br.readLine().split(" ");
			N=Integer.parseInt(input1[0]);//사람은 N번까지
			M=Integer.parseInt(input1[1]);//M개의 줄에 거쳐 입력
			cnt=0;
			parent=new int[N+1];
			check=new int[N+1];
			
			for(int i=1;i<N+1;i++) {
				parent[i]=i;
			}
			
			for(int i=0;i<M;i++) {
				String[] input2=br.readLine().split(" ");
				int num1=Integer.parseInt(input2[0]);
				int num2=Integer.parseInt(input2[1]);
				
				union(num1, num2);
				
			}//end for i
			
			for(int i=1;i<N+1;i++) {
				check[findSet(parent[i])]+=1;
			}
			for(int i=1;i<N+1;i++) {
				if(check[i]>=1){
					cnt+=1;
				}
			}
			
			bw.write("#"+tc+" "+Integer.toString(cnt));
            bw.newLine();
			bw.flush();
			
		}//end for tc
	}//end main()
	
	static int findSet(int x) {
		if(x==parent[x])return x;
		else return parent[x]=findSet(parent[x]);
	}//end findSet
	
	static void union(int x,int y) {
		int fX=findSet(x);
		int fY=findSet(y);
		
		if(fX!=fY) {
			parent[fY]=fX;
		}
	}
	
	static boolean check(int x, int y) {
		int fX=findSet(x);
		int fY=findSet(y);
		if(fX==fY) {
			return true;
		}
		else return false;
	}
}
