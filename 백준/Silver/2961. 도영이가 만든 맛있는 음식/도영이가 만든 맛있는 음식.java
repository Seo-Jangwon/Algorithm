import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static int N;
	static int[] sour;
	static int[] bitt;
	static boolean[] sCheck;
	static boolean[] bCheck;
	static int min=Integer.MAX_VALUE;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		N=Integer.parseInt(br.readLine());
		bitt=new int[N];//신맛
		sour=new int[N];//쓴맛
		String[] str=new String[2];
		
		for(int i=0;i<N;i++) {
			str=br.readLine().split(" ");
			bitt[i]=Integer.parseInt(str[0]);
			sour[i]=Integer.parseInt(str[1]);
		}
		
		dfs(1,0,0,0);
		bw.write(Integer.toString(min));
		bw.flush();
		bw.close();
	}
	public static void dfs(int b, int s, int cnt,int input) {
		if(cnt==N ) {
			if((input!=0)) {
				if(min>Math.abs(b-s))
				min=Math.abs(b-s);
			}
			return;
		}
		
		dfs(b*bitt[cnt]	,s+sour[cnt],cnt+1, input+1);
		dfs(b,s,cnt+1,input);
		
	}
}
