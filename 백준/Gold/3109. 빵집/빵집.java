import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

	static int[] di= { -1, 0,1};
	static int[] dj= { 1, 1, 1};
	static int cnt;
	static int R,C;
	static String[][]map;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String[] in1=br.readLine().split(" ");
		R=Integer.parseInt(in1[0]);
		C=Integer.parseInt(in1[1]);
		
		map=new String[R][C];
		for(int i=0;i<R;i++) {
			String[] in2=br.readLine().split("");
			for(int j=0;j<C;j++) {
				map[i][j]=in2[j];
			}
		}
		
		
		cnt=0;
		for(int i=0;i<R;i++) {
			dfs(i,0);
		}
		
		System.out.println(cnt);
		
	}//end main
	
	static boolean dfs(int i, int j) {
		if(j==C-1) {
			cnt++;
			return true;
		}
		for(int d=0;d<3;d++) {
			int ni=i+di[d];
			int nj=j+dj[d];
			if(ni>=0 && nj>=0 && ni<R && nj<C && map[ni][nj].equals(".")) {
				map[ni][nj]="X";
				if(dfs(ni,nj)) {return true;}
			}
		}
		return false;
	}
	
}