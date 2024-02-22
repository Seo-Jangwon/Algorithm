import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Solution {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb;
	static int n,m;
	static int p[];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		int T;
		T=Integer.parseInt(br.readLine());
		
		for(int TC = 1; TC <= T; TC++)
		{
            sb=new StringBuilder();
			String[] input1=br.readLine().split(" ");
			n=Integer.parseInt(input1[0]);
			m=Integer.parseInt(input1[1]);
			p=new int[n+1];
			make();
			for(int i=0;i<m;i++) {
				String[] input2=br.readLine().split(" ");
				
				int x=Integer.parseInt(input2[1]);
				int y=Integer.parseInt(input2[2]);
				
				switch (Integer.parseInt(input2[0])) {
				case 0:
					union(x,y);
					break;
				case 1:
					sb.append(check(x, y));
					break;
				
				}
			}//end for
			bw.write("#"+Integer.toString(TC)+" "+sb.toString());
            bw.newLine();
			bw.flush();
		}//end TC
	}//end main

	static void make() {
		for(int i=1;i<n+1;i++) {
			p[i]=i;
		}
	}//end make
	
	static int find(int idx) {
		
		if(idx==p[idx]) return idx;
		else {
			return p[idx]=find(p[idx]);
		}
		
	}
	
	static void union(int x, int y) {
		int xRoot=find(x);
		int yRoot=find(y);
		
		if(xRoot==yRoot) {
			return;
		}else {
			p[yRoot]=xRoot;
		}
	}
	
	static String check(int x, int y) {
		int xRoot=find(x);
		int yRoot=find(y);
		
		if(xRoot==yRoot) {
			return "1";
		}else {
			return "0";
		}
	}
}