import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Queue;

public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static int N, M, ans;
	static ArrayList<Integer>[] fList;
	static boolean[] v;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String[] input1=br.readLine().split(" ");
		N=Integer.parseInt(input1[0]);
		M=Integer.parseInt(input1[1]);
		fList=new ArrayList[N];
		v=new boolean[N];
		ans=0;
		
		for(int idx=0;idx<N;idx++) {
			fList[idx]=new ArrayList<Integer>();
		}
		
		for(int i=0;i<M;i++) {
			String[] input2=br.readLine().split(" ");
			int ni=Integer.parseInt(input2[0]);
			int nj=Integer.parseInt(input2[1]);
			fList[ni].add(nj);
			fList[nj].add(ni);
		}//end for

		
		for(int idx=0;idx<N;idx++) {
			if(ans==0) {
				v[idx]=true;
				dfs(1,idx);
				v[idx]=false;
			}
		}
		
		bw.write(Integer.toString(ans));
		bw.flush();
	}//end main
	
	static void dfs(int dep, int idx) {
		if(dep==5) {
			ans=1;
			return;
		}
		
		for(int i=0;i<fList[idx].size();i++) {
			if(!v[fList[idx].get(i)]) {
				v[fList[idx].get(i)]=true;
				dfs(dep+1, fList[idx].get(i));
				v[fList[idx].get(i)]=false;
			}
		}
		
	}//end dfs
	
}