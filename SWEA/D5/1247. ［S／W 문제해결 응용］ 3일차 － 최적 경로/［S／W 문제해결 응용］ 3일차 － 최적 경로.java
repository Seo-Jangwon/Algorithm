import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


class Solution {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static int N;
	static int officeX,officeY;
	static int houseX, houseY;
	static int length;
	static boolean[] v;
	static int[][] map;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		int T=Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++){
			N=Integer.parseInt(br.readLine());
			String[] input=br.readLine().split(" ");
			
			map=new int[N][2];
			v=new boolean[N];
			officeX=Integer.parseInt(input[0]);
			officeY=Integer.parseInt(input[1]);
			houseX=Integer.parseInt(input[2]);
			houseY=Integer.parseInt(input[3]);
			int nowX=officeX;//현재 좌표
			int nowY=officeY;//현재 좌표
			length=Integer.MAX_VALUE;//총 거리;
			
			int iCnt=0;
			for(int i=0;i<N;i++) {
				map[i][0]=Integer.parseInt(input[4+i+iCnt]);
				map[i][1]=Integer.parseInt(input[5+i+iCnt]);
				iCnt+=1;
			}//end for i
			dfs(0,0,nowX, nowY);
			System.out.println("#"+tc+" "+length);
		}//end for TestCase
	}
	
	static void dfs(int depth, int len, int nX, int nY) {
		int nowX=nX;
		int nowY=nY;
		if(depth==N) {
			len+=(Math.abs(nowX-houseX)+Math.abs(nowY-houseY));
			if(length>len) {
				//System.out.println("len : "+len);
				length=len;
			}
			return;
		}//종료조건 끝
		
		//System.out.println("nowX : "+nowX+" nowY : "+nowY);
		for(int i=0;i<N;i++) {
			if(v[i]!=true) {
				v[i]=true;
				dfs(depth+1, len+(Math.abs(nowX-map[i][0])+Math.abs(nowY-map[i][1])), map[i][0], map[i][1]);
				v[i]=false;
			}
		}//end for
		
	}

}
