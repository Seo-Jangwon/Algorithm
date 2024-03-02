import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	
	static int N;//연구소 크기는 N*N
	static int M;//바이러스 개수
	static int minTime;//바이러스 퍼뜨리는 최소 시간
	static int nOfWall;//벽 개수
	static int[][]map;//연구소 크기
	static ArrayList<Virus>virusPoint;//바이러스 놓을 수 있는 위치
	static LinkedList<Virus>realVirusPoint;//바이러스를 진짜로 놓은 위치
	static int[]dy= {1,-1,0,0};
	static int[]dx= {0,0,-1,1};
	
	static class Virus{
		int i;
		int j;
		public Virus(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}
	}//end Virus
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String[] in1=br.readLine().split(" ");
		N=Integer.parseInt(in1[0]);
		M=Integer.parseInt(in1[1]);
		
		map=new int[N][N];//연구소
		virusPoint=new ArrayList<Virus>();//바이러스 위치 저장할 배열
		realVirusPoint=new LinkedList<Virus>();
		minTime=Integer.MAX_VALUE;
		nOfWall=0;//벽 개수 초기화
		
		for(int i=0;i<N;i++) {
			String[] in2=br.readLine().split(" ");
			for(int j=0;j<N;j++) {
				map[i][j]=Integer.parseInt(in2[j]);
				if(map[i][j]==2) virusPoint.add(new Virus(i, j));
			}
		}//end for
		
		dfs(0,0);
		if(minTime==Integer.MAX_VALUE)minTime=-1;
		bw.write(Integer.toString(minTime));
		bw.flush();
		
	}//end main
	
	static void dfs(int dep, int start) {
		if(dep==M) {
			//바이러스 퍼뜨리기
			int spreadTime=spreadVirus();
//			System.out.println("............................................"+spreadTime);
			if(spreadTime<minTime) {
				minTime=spreadTime;
			}
			return;
		}
		for(int i=start;i<virusPoint.size();i++) {
			Virus virus=virusPoint.get(i);
			int vi=virus.i;
			int vj=virus.j;
			realVirusPoint.add(new Virus(vi, vj));
			map[vi][vj]=2;
			dfs(dep+1,i+1);
			map[vi][vj]=0;
			realVirusPoint.remove(realVirusPoint.size()-1);
		}
		
	}//end dfs
	
	static int spreadVirus() {
		int maxLevel=0;
		int[][]tempMap=new int[N][N];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]==0) tempMap[i][j]=-1;//bfs레벨은 0부터라서
				if(map[i][j]==2) tempMap[i][j]=-2;
			}
		}//map 복사
		
		int level=0;
		Queue<Virus>q=new ArrayDeque<Virus>();
		for(Virus virus:realVirusPoint) {
			q.offer(new Virus(virus.i, virus.j));
			tempMap[virus.i][virus.j]=level;
		}//end for (Virus virus:realVirusPoint)

		level+=1;
		while(!q.isEmpty()) {
			int len=q.size();
			for(int i=0;i<len;i++) {
				Virus curr=q.poll();
				for(int d=0;d<4;d++) {
					int ny=curr.i+dy[d];
					int nx=curr.j+dx[d];
					if(ny>=0&&nx>=0&&ny<N&&nx<N&&(tempMap[ny][nx]==-1||tempMap[ny][nx]==-2)) {
						q.offer(new Virus(ny, nx));
						tempMap[ny][nx]=level;
							
						if(level>maxLevel) {
							maxLevel=level;
						}//레벨 최신화
					}
						
				}//end for 4방위 탐색
			}
			level++;
		}//end while
			
		
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
//				System.out.print(tempMap[i][j]);
                if(tempMap[i][j]==-1||tempMap[i][j]==-2) maxLevel=Integer.MAX_VALUE;
			}
//			System.out.println();
		}//end for
//		System.out.println();
		
		return maxLevel;
	}//end spreadVirus
	
}
