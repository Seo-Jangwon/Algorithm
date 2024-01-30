import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static int[] arr;
	static boolean[] v;
	static int N;
	static BufferedReader br;
	static BufferedWriter bw;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		br=new BufferedReader(new InputStreamReader(System.in));
		bw=new BufferedWriter(new OutputStreamWriter(System.out));
		
		N=Integer.parseInt(br.readLine());
		arr=new int[N];
		v=new boolean[N+1];
		perm(1);
	}
	public static void perm(int dep) throws IOException {
		if(dep==N+1) {
			for(int i:arr) {
				bw.write(Integer.toString(i)+' ');
			}
			bw.newLine();
			bw.flush();
			return;
		}else {
			for(int i=1;i<N+1;i++) {
				if(v[i]==false) {
					v[i]=true;
					arr[dep-1]=i;
					perm(dep+1);
					v[i]=false;
				}
			}
		}
	}
}