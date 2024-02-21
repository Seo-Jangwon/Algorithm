import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb=new StringBuilder();
	static int L,C;
	static String[] alphabet;
	static boolean[] v;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String[] input1=br.readLine().split(" ");
		L=Integer.parseInt(input1[0]);
		C=Integer.parseInt(input1[1]);
		
		v=new boolean[L];
		
		alphabet=br.readLine().split(" ");
		Arrays.sort(alphabet);

		
		for(int i=0;i<C;i++) {
			dfs(1,i+1,alphabet[i]);
		}
	}
	static void dfs(int dep, int start,String s) throws IOException {
		if(dep==L) {
			if(check(s)) {
			bw.write(s);
			bw.newLine();
			bw.flush();
			}
		}//end if
		
		for(int i=start;i<C;i++) {
			dfs(dep+1,i+1,s+alphabet[i]);
		}
		
	}
	
	static boolean check(String s) {
		int ja=0;
		int mo=0;
		for(int i=0;i<s.length();i++) {
			char c=s.charAt(i);
			if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u') {
				mo+=1;
			}
			else {ja+=1;}
		}
		if(ja>=2&&mo>=1) {
			return true;
		}else return false;
	}

}
