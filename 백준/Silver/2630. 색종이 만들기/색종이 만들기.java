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
	static int cntB;
	static int cntW;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		N=Integer.parseInt(br.readLine());
		arr=new int[N][N];
		for(int i=0;i<N;i++) {
			String[]input=br.readLine().split(" ");
			for(int j=0;j<N;j++) {
				arr[i][j]=Integer.parseInt(input[j]);
			}// end for j
		}//end for i
		
		findB(N,0,N,0,N);
		findW(N,0,N,0,N);
		
//		findB(N, 0, N/2, 0, N/2);
//		findB(N, 0, N/2, N/2, N);
//		findB(N, N/2, N, 0, N/2);
//		findB(N, N/2, N, N/2, N);
//		
//		findW(N, 0, N/2, 0, N/2);
//		findW(N, 0, N/2, N/2, N);
//		findW(N, N/2, N, 0, N/2);
//		findW(N, N/2, N, N/2, N);
		
		bw.write(Integer.toString(cntW));
		bw.newLine();
		bw.write(Integer.toString(cntB));
		bw.flush();
	}//end main
	
	static void findB(int idxLen, int startR, int endR, int startC, int endC) {
		if(idxLen<1) {
			return;
		}
		//System.out.println("startR : "+startR+" endR : "+endR+" startC : "+startC+" endC : "+endC);
		
		int midR=(startR+endR)/2;
		int midC=(startC+endC)/2;	
		boolean check=true;
		
		for(int i=startR;i<endR;i++) {
			for(int j=startC;j<endC;j++) {
				if(arr[i][j]!=1) {
					check=false;
					break;
				}
			}//end for j
		}//end for i
		
		if(startR==endR||startC==endC)check=false;
		
		if(check==false) {
			//System.out.println("check : false");
			findB(idxLen/2, startR, midR, startC, midC);
			findB(idxLen/2, startR, midR, midC, endC);
			findB(idxLen/2, midR, endR, startC, midC);
			findB(idxLen/2, midR, endR, midC, endC);
		}else if(check==true) {
			//System.out.println("check : !!!!!!!!!!!!!!!!!!!true");
			cntB+=1;
			return;
		}
	}//end findB()
	
	static void findW(int idxLen, int startR, int endR, int startC, int endC) {
		if(idxLen<1) {
			return;
		}
		//System.out.println("startR : "+startR+" endR : "+endR+" startC : "+startC+" endC : "+endC);
		
		int midR=(startR+endR)/2;
		int midC=(startC+endC)/2;	
		boolean check=true;
		
		for(int i=startR;i<endR;i++) {
			for(int j=startC;j<endC;j++) {
				if(arr[i][j]!=0) {
					check=false;
					break;
				}
			}//end for j
		}//end for i
		
		if(startR==endR||startC==endC)check=false;
		
		if(check==false) {
			//System.out.println("check : false");
			findW(idxLen/2, startR, midR, startC, midC);
			findW(idxLen/2, startR, midR, midC, endC);
			findW(idxLen/2, midR, endR, startC, midC);
			findW(idxLen/2, midR, endR, midC, endC);
		}else if(check==true) {
			//System.out.println("check : !!!!!!!!!!!!!!!!!!!true");
			cntW+=1;
			return;
		}
	}//end findW()
}
