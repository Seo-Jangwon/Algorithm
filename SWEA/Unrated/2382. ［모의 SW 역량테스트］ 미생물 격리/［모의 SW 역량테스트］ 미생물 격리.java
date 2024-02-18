import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

class Solution {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static int N,M,K;
	static LinkedList<Germ> list;
	
	static class Germ {
		int y;
		int x;
		int num;
		int dir;
		public Germ(int y, int x, int num, int dir) {
			super();
			this.y = y;
			this.x = x;
			this.num = num;
			this.dir = dir;
		}

		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		int T=Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++)
		{
			String[] input1=br.readLine().split(" ");
			N=Integer.parseInt(input1[0]);//셀의 개수
			M=Integer.parseInt(input1[1]);//격리 시간
			K=Integer.parseInt(input1[2]);//미생물 군집의 개수
			list=new LinkedList<Germ>();
			
			
			for(int i=0;i<K;i++) {
				String[] input2=br.readLine().split(" ");
				list.add(new Germ(Integer.parseInt(input2[0]), Integer.parseInt(input2[1]), Integer.parseInt(input2[2]), Integer.parseInt(input2[3])));
			}
			
		for(int t=0;t<M;t++) {
			
			for(int i=K-1;i>=0;i--) {
				
				Germ temp;
				temp=list.get(i);
				
					
				switch (temp.dir) {
					case 1: {
						if(temp.y-1>=0) {//위로 올라갈 수 있다면
							temp.y-=1;//올라가기
							if(temp.y==0) {//y-1이 0이면
								temp.dir=2;//방향 반대
								temp.num/=2;//개수 절반
								if(temp.num==0) {list.remove(i);K-=1;}
							}//end if y-1==0
						}//end if y-1>=0
						break;
					}
					case 2: {
						if(temp.y+1<N) {
							temp.y+=1;
							if(temp.y==N-1) {
								temp.dir=1;
								temp.num/=2;
								if(temp.num==0) {list.remove(i);K-=1;}
							}
						}
						break;
					}
					case 3: {
						if(temp.x-1>=0) {
							temp.x-=1;
							if(temp.x==0) {
								temp.dir=4;
								temp.num/=2;
								if(temp.num==0) {list.remove(i);K-=1;}
							}
						}
						break;
					}
					case 4: {
						if(temp.x+1<N) {
							temp.x+=1;
							if(temp.x==N-1) {
								temp.dir=3;
								temp.num/=2;
								if(temp.num==0) {list.remove(i);K-=1;}
							}
						}
						break;
					}
				}//end switch
				
			}//end for i ... k개의 세균이 저정된 리스트 돌기
			
			
//			//===============테스트 위한 출력
//			System.out.println("테스트 출력, 리스트 돌기 끝");
//			for(int tt=0;tt<list.size();tt++) {
//				System.out.println("M : "+t+" idx : "+tt+"      y: "+list.get(tt).y+" x: "+list.get(tt).x+" num: "+list.get(tt).num+" 방향: "+list.get(tt).dir);
//			}
//			System.out.println();
//			//===============테스트 위한 출력
			
			Collections.sort(list, new Comparator<Germ>() {

				@Override
				public int compare(Germ o1, Germ o2) {
					if(o1.y!=o2.y) {
						return o1.y-o2.y;
					}
					else {
						if(o1.x!=o2.x) return o1.x-o2.x;
						else return o1.num-o2.num;
					}
				}
			});
			
			
//			//===============테스트 위한 출력
//			System.out.println("테스트 출력, 정렬");
//			for(int tt=0;tt<list.size();tt++) {
//				System.out.println("M : "+t+" idx : "+tt+"      y: "+list.get(tt).y+" x: "+list.get(tt).x+" num: "+list.get(tt).num+" 방향: "+list.get(tt).dir);
//			}
//			System.out.println();
//			//===============테스트 위한 출력
			
			
			for(int i=list.size()-2;i>=0;i--) {
				Germ temp1=list.get(i);
				Germ temp2=list.get(i+1);
				
				
				if(temp1.y==temp2.y&&temp1.x==temp2.x) {
					if(temp1.num>temp2.num) {//tmep1이 더 많다면
						temp2.num+=temp1.num;
						switch (temp2.dir) {
						case 1: {
							temp2.dir=2;
							break;
						}
						case 2: {
							temp2.dir=1;
							break;
						}
						case 3: {
							temp2.dir=4;
							break;
						}
						case 4: {
							temp2.dir=3;
							break;
						}
					}
					}//end if
					else if(temp1.num<temp2.num) {//tmep2의 개수가 많다면
						temp2.num+=temp1.num;
					}//end if
					list.remove(i);
					K-=1;
				}//위치가 같은 경우
			}//같은 위치 삭제
			
			
//			//===============테스트 위한 출력
//			System.out.println("테스트 출력, 같은 위치 삭제");
//			for(int tt=0;tt<list.size();tt++) {
//				System.out.println("M : "+t+" idx : "+tt+"      y: "+list.get(tt).y+" x: "+list.get(tt).x+" num: "+list.get(tt).num+" 방향: "+list.get(tt).dir);
//			}
//			System.out.println();
//			//===============테스트 위한 출력
			
			
		}//end for M 시간동안 돌기
			
		int ans=0;
		for(int i=0;i<list.size();i++) {
			ans+=list.get(i).num;
		}
		bw.write("#"+tc+" "+ans);
		bw.newLine();
		bw.flush();
		
		}//end for
	}//end main

}