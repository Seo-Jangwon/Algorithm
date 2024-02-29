
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;



public class Main {
	
	static class Student{
		int i;
		int j;
		String pa;
		int num;
		public Student(int i, int j, String pa, int num) {
			super();
			this.i = i;
			this.j = j;
			this.pa = pa;
			this.num = num;
		}
	}
	
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	
	static int ans;
	static Student arr[];
	static int[] di= {1,-1,0,0};
	static int[] dj= {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		arr=new Student[25];
		for(int i=0;i<5;i++) {
			String[] in=br.readLine().split("");
			for(int j=0;j<5;j++) {
				arr[5*i+j]=new Student(i,j,in[j],5*i+j);
			}
		}
		ans=0;
		Student[]list=new Student[7];
		comb(0,0,list);
		bw.write(Integer.toString(ans));
		bw.flush();
	}
	
	static void comb(int dep, int start,Student[] list) {
		if(dep==7) {
			
			if(checkSeat(list)&&countS(list)) {
				ans+=1;
			}
			return;
		}
		for(int i=start;i<25;i++) {
			list[dep]=arr[i];
			comb(dep+1,i+1,list);
		}
	}//end comb
	
	static boolean checkSeat(Student[] list) {
		Queue<Student> q=new ArrayDeque<Student>();
		boolean[][]v=new boolean[5][5];
		q.add(list[0]);
		v[list[0].i][list[0].j]=true;
		
		int cnt=1;
		while(!q.isEmpty()) {
			Student curr=q.poll();
			for(int d=0;d<4;d++) {
				int ni=curr.i+di[d];
				int nj=curr.j+dj[d];
				if(ni>=0&&nj>=0&&ni<5&&nj<5&&!v[ni][nj]) {
					for(int i=1;i<7;i++) {
						if(list[i].i==ni&&list[i].j==nj) {
							q.offer(list[i]);
							v[ni][nj]=true;
							cnt+=1;
						}
					}
				}
			}
		}
		if(cnt==7) {return true;}
		else {return false;}
	}
	static boolean countS(Student[] list) {
		int S=0;
		for(Student s:list) {
			if(s.pa.equals("S")) {
				S+=1;
			}
		}
		if(S>=4)return true;
		else return false;
	}
}
