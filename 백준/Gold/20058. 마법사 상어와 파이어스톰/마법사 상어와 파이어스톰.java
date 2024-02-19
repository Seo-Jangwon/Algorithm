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
	static int N,Q,len;
	static int sum, vol;
	static int [] L;
	static int[][]map;
	static int[] dx= {1,-1,0,0};
	static int[] dy= {0,0,-1,1};
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String[] input1=br.readLine().split(" ");
		N=Integer.parseInt(input1[0]);
		Q=Integer.parseInt(input1[1]);
		
		len=(int) Math.pow(2, N);
		map=new int[len][len];
		for(int i=0;i<len;i++) {
			String[] input2=br.readLine().split(" ");
			for(int j=0;j<len;j++) {
				map[i][j]=Integer.parseInt(input2[j]);
			}//end for
		}//end for
		
		L=new int[Q];
		String[] input3=br.readLine().split(" ");
		for(int i=0;i<Q;i++) {
			L[i]=Integer.parseInt(input3[i]);
		}
		
		sum=0;
		vol=0;
		
		for(int i=0;i<=Q;i++) {
			magic(i);
		}
		
		bw.write(Integer.toString(sum));
		bw.newLine();
		bw.write(Integer.toString(vol));
		bw.flush();
		bw.close();
		
	}//end main
	
	
	
	
	public static void magic(int level) {
		
		if(level==Q) {//종료 조건
			//=================얼음의 합
			for(int i=0;i<len;i++) {
				for(int j=0;j<len;j++) {
					sum+=map[i][j];
				}//end for
			}//end for
			//=================얼음의 합
			
			//=================제일 큰 얼음 덩어리
			bfs();
			//=================제일 큰 얼음 덩어리
			return;
		}//end 종료 조건
		
		//======================회전
		int lev=L[level];
		int Ln=(int) Math.pow(2, lev);
		
		for(int i=0;i<len;i+=Ln) {
			for(int j=0;j<len;j+=Ln) {
				
				rotate(i, j, Ln);
				
				
				
			}//회전할거 고르기
		}//회전할거 고르기
		
		
//	=====================출력찍기
//		System.out.println("====================================================     "+Ln+"    회전");
//		
//		for(int i=0;i<len;i++) {//얼음들을 돌며
//			for(int j=0;j<len;j++) {
//				System.out.print(map[i][j]+" ");
//			}
//			System.out.println();
//		}//출력찍기 끝

		//======================얼음 지우기
		LinkedList<Integer> IList=new LinkedList<Integer>();
		LinkedList<Integer> JList=new LinkedList<Integer>();
		for(int i=0;i<len;i++) {//얼음들을 돌며
			for(int j=0;j<len;j++) {
				
				int cnt=0;
				for(int d=0;d<4;d++) {//4방향 탐색
					int ny=i+dy[d];
					int nx=j+dx[d];
					
					if(nx>=0&&nx<len&&ny>=0&&ny<len) {
						if(map[ny][nx]>0) {
							cnt+=1;
						}
					}
				}
				
				if(cnt<3) {//얼음이 있는칸이 1보다 작으면
//					map[i][j]-=1;
//					if(map[i][j]<0)map[i][j]=0;
					IList.add(i);
					JList.add(j);
				}
				
			}//end for
		}//end for
		
		for(int i=IList.size()-1;i>=0;i--) {
			map[IList.get(i)][JList.get(i)]-=1;
			if(map[IList.get(i)][JList.get(i)]<0)map[IList.get(i)][JList.get(i)]=0;
		}//배열 돌면서 제거
		IList.remove();
		JList.remove();
		//======================얼음 지우기
		
		
//		=====================출력찍기
//		System.out.println("====================================================     "+Ln+"    얼음 지우기");
//		
//		for(int i=0;i<len;i++) {//얼음들을 돌며
//			for(int j=0;j<len;j++) {
//				System.out.print(map[i][j]+" ");
//			}
//			System.out.println();
//		}//출력찍기 끝
	
	}//end magic
	
	public static void rotate(int y, int x, int ln) {
		int[][] tmp=new int[ln][ln];
		
		for(int i=0;i<ln;i++) {
			for(int j=0;j<ln;j++) {
				
				tmp[i][j]=map[y+ln-1-j][x+i];
				
			}
		}
		
		
		for(int i=0;i<ln;i++) {
			for(int j=0;j<ln;j++) {
				map[y+i][x+j]=tmp[i][j];
			}
		}
	}
	

	public static void bfs() {//vol(얼음의 면적) 찾기
		Queue<Ice>queue=new ArrayDeque<Ice>();
		boolean[][]v=new boolean[len][len];
		
		for(int i=0;i<len;i++) {//얼음들을 돌며
			for(int j=0;j<len;j++) {
				if(map[i][j]>0&&!v[i][j]) {
					
					int size=1;//얼음 사이즈
					
					queue.offer(new Ice(i,j));
					v[i][j]=true;
					
					while(!queue.isEmpty()) {
						Ice temp;
						temp=queue.poll();
						
						for(int d=0;d<4;d++) {
							int ny=temp.y+dy[d];
							int nx=temp.x+dx[d];
							
							if(nx>=0&&nx<len&&ny>=0&&ny<len&&map[ny][nx]>0&&!v[ny][nx]) {
								queue.offer(new Ice(ny, nx));
								v[ny][nx]=true;
								size+=1;
							}//end if
						}//end for
						
					}//end while
					
					if(size>vol)vol=size;
					
				}//end if

			}//end for
		}//end for
	}//end bfs
	
	static class Ice{
		int y;
		int x;
		public Ice(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
		
	}
	
}