import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static int N, M;
	static int wallCnt;//벽 개수
	static int maxArea;//최대 영역
	static int[][]map;
	static ArrayList<Germ> germList;
	static int[]dy= {1,-1,0,0};
	static int[]dx= {0,0,-1,1};
	
	static class Germ{
		int i;
		int j;
		public Germ(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}
	}

	
	public static void main(String[] args) throws IOException {
		/*
		 * 
		 *0: 빈 칸
		 *1: 벽
		 *2: 바이러스가 있는 위치
		 *안전 영역 크기의 최댓값 구하기
		 */
		
		String[] in1=br.readLine().split(" ");
		N=Integer.parseInt(in1[0]);
		M=Integer.parseInt(in1[1]);
		
		wallCnt=0;
		maxArea=0;
		
		map=new int[N][M];
		germList=new ArrayList<Germ>();
		
		for(int i=0;i<N;i++) {
			String[] in2=br.readLine().split(" ");
			for(int j=0;j<M;j++) {
				map[i][j]=Integer.parseInt(in2[j]);
				if(map[i][j]==1) wallCnt++;//벽 개수 세기
				if(map[i][j]==2) germList.add(new Germ(i, j));
			}//end for j
		}//end for i
		
		makeWall(0);
		
		bw.write(Integer.toString(maxArea));
		bw.flush();
	}//main
	
	static void makeWall(int cnt) {//end 만들기 
		if(cnt==3) {//세워진 벽이 3개면 bfs로 퍼지는 영역 체크
			int currArea=N*M-(wallCnt+3+spreadGerm());
			if(currArea>maxArea) {
				maxArea=currArea;
			}
			return;
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]==0) {
					map[i][j]=1;
					makeWall(cnt+1);
					map[i][j]=0;
				}
			}
		}
		
	}//end 벽 만들기 
	
	static int spreadGerm() {
		Queue<Germ>q=new ArrayDeque<Germ>();
		boolean[][]v=new boolean[N][M];
		int cntSpread=0;
		
		for(int i=0;i<germList.size();i++) {
			Germ startGerm=germList.get(i);
			
			if(v[startGerm.i][startGerm.j])continue;//처리한 germ이면 건너뛰기
			
			q.offer(startGerm);
			v[startGerm.i][startGerm.j]=true;
			while(!q.isEmpty()) {
				Germ curr=q.poll();
				cntSpread+=1;
				
				for(int d=0;d<4;d++) {
					int ny=curr.i+dy[d];
					int nx=curr.j+dx[d];
					if(ny>=0&&nx>=0&&ny<N&&nx<M&&!v[ny][nx]&&map[ny][nx]!=1) {//인덱스 범위 체크, 방문 체크, 벽인지 체크
						q.offer(new Germ(ny, nx));
						v[ny][nx]=true;
						
					}
				}//end 4방위 탐색
			}//end while
		}//end for
//		System.out.println("n of GErm : "+cntSpread );
		return cntSpread;
	}//end spreadGerm
	
}