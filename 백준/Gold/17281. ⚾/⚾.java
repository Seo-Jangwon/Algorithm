import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static int[] order;//타순
	static boolean[] V;//방문
	static int[][] plays;//
	static int inning;
	static int max;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		inning=Integer.parseInt(br.readLine());
		order=new int[10];
		V=new boolean[10];
		order[4]=1;
		plays=new int[inning][10];
		
		for(int i=0;i<inning;i++) {
			String[]input=br.readLine().split(" ");
			for(int j=1;j<10;j++) {
				plays[i][j]=Integer.parseInt(input[j-1]);
			}//end for
		}//end for
		
		max=0;
		dfs(2, 0);
		
		bw.write(Integer.toString(max));
		bw.flush();
		
	}//end main

	static void dfs(int dep, int idx) {//dep은 선수 번호
		if(dep==10) {
			
			int score=0;//점수
			int num=1;//타순
			int inn=0;//이닝 초기화
			
			while(true) {//경기
				if(inn==inning) {
					break;
				}
//				System.out.print("이닝 : "+inn+" 선두 타자 : "+order[num]);
				boolean[] base = new boolean[4];
				int outCount=0;		
				while(true) {//이닝
					
					boolean threeOut=false;//아웃 3갠지 체크
					
					int p=plays[inn][order[num]];
					switch (p) {
						case 1: {
							if(base[3]) {
			    				score++;
			    				base[3] = false;
			    			}
			    			if(base[2]) {
			    				base[3] = true;
			    				base[2] = false;
			    			}
			    			if(base[1]) {
			    				base[2] = true;
			    			}
			    			base[1] = true;
							break;
						}
						case 2: {
							if(base[3]) {
			    				score++;
			    				base[3] = false;
			    			}
			    			if(base[2]) {
			    				score++;
			    			}
			    			if(base[1]) {
			    				base[3] = true;
			    				base[1] = false;
			    			}
			    			base[2] = true;
							break;
						}
						case 3: {
							if(base[3]) {
			    				score++;
			    			}
			    			if(base[2]) {
			    				score++;
			    				base[2] = false;
			    			}
			    			if(base[1]) {
			    				score++;
			    				base[1] = false;
			    			}
			    			base[3] = true;
							break;
						}
						case 4: {
							if(base[3]) {
			    				score++;
			    				base[3] = false;
			    			}
			    			if(base[2]) {
			    				score++;
			    				base[2] = false;
			    			}
			    			if(base[1]) {
			    				score++;
			    				base[1] = false;
			    			}
			    			score++;
							break;
						}
						case 0: {
							outCount+=1;
							if(outCount==3) {
								threeOut=true;
							}
							break;
						}
					
					}//switch
					
					num+=1;//다음 타자
					if(num==10) {
						num%=9;
					}
					if(threeOut==true) {//아웃 3번이면
//						System.out.println(" 대기 타석 : "+order[num]);
						inn++;//다음 이닝
						break;//종료
					}
				}//이닝 종료
			}//경기 종료
			
			if(score>max) {
				max=score;
			}
			return;
		}//종료조건
		
		for(int i=1;i<10;i++) {//타순 조합
			if(!V[i]&&i!=4) {
				V[i]=true;
				order[i]=dep;
				dfs(dep+1,i);
				V[i]=false;
			}
		}
		
	}//end dfs
}
