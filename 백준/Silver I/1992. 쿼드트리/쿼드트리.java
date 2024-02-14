import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static int[][] arr;
	static int N;
	static StringBuilder sb=new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		N=Integer.parseInt(br.readLine());
		arr=new int[N][N];
		for(int i=0;i<N;i++) {
			String[]input=br.readLine().split("");
			for(int j=0;j<N;j++) {
				arr[i][j]=Integer.parseInt(input[j]);
			}// end for j
		}//end for i
		
		find(N,0,N,0,N, false, false);
		bw.write(sb.toString());
		bw.flush();
	}//end main
	
	static void find(int idxLen, int startR, int endR, int startC, int endC, boolean one, boolean zero) {
		if(idxLen<1) {
			return;
		}
		//System.out.println("startR : "+startR+" endR : "+endR+" startC : "+startC+" endC : "+endC+" one : "+one+" zero : "+zero);
		int midR=(startR+endR)/2;
		int midC=(startC+endC)/2;	
		boolean check1=true;
		boolean check0=true;
		if(one==false) {
			for(int i=startR;i<endR;i++) {
				for(int j=startC;j<endC;j++) {
					if(arr[i][j]!=1) {
						check1=false;
						break;
					}
				}//end for j
			}//end for i
		}
		if(zero==false) {
			for(int i=startR;i<endR;i++) {
				for(int j=startC;j<endC;j++) {
					if(arr[i][j]!=0) {
						check0=false;
						break;
					}
				}//end for j
			}//end for i
		}
		
		if(startR==endR||startC==endC) {check0=false; check1=false;}
		
		if(one!=true&&check1==true) {
			//System.out.println("append 1");
			sb.append("1");
			return;
		}
		if(zero!=true&&check0==true) {
			//System.out.println("append 0");
			sb.append("0");
			return;
		}
		
		if(check0==false||check1==false) {
			sb.append("(");
			find(idxLen/2, startR, midR, startC, midC, check1, check0);
			find(idxLen/2, startR, midR, midC, endC, check1, check0);
			find(idxLen/2, midR, endR, startC, midC, check1, check0);
			find(idxLen/2, midR, endR, midC, endC, check1, check0);
			sb.append(")");
		}
		

	}//end findB()
}