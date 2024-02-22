import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int[] parents, population;
	static int[] combination;
	static boolean[][] check;
	static int N, combiSize,ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		parents = new int[N+1];
		population = new int[N+1];
		for(int i=0; i<=N; i++) parents[i]=-1;
		for(int i=1; i<=N; i++) population[i] = sc.nextInt();
		check = new boolean[N+1][N+1];
		int count,temp;
		for(int i=1; i<=N; i++) {
			count = sc.nextInt();
			for(int j=0; j<count; j++) {
				temp = sc.nextInt();
				check[i][temp]=check[temp][i]=true;
			}
		}
		ans = Integer.MAX_VALUE;
		for(int i=1; i<=N/2; i++) {
			combination = new int[i];
			combiSize = i;
			combi(0,0,1);
		}
		if(ans==Integer.MAX_VALUE) ans=-1;
		System.out.println(ans);
		sc.close();
	}
	static void solution(int[] a, int[] b) {
		if(a.length>1) {
			for(int i=0; i<a.length-1; i++) {
				for(int j=i+1; j<a.length; j++) {
					if(check[a[i]][a[j]]) union(a[i],a[j]);
				}
			}
		}
		if(b.length>1) {
			for(int i=0; i<b.length-1; i++) {
				for(int j=i+1; j<b.length; j++) {
					if(check[b[i]][b[j]]) union(b[i],b[j]);
				}
			}
		}
		
		boolean[] arr = new boolean[N+1];
		for(int i=1; i<=N; i++) {
			arr[find(i)]=true;
//			System.out.println(i+"의 부모: "+find(i));
		}
		int count=0;
		for(int i=1; i<=N; i++) if(arr[i])  count++;
		if(count==2) {
//			System.out.println(Arrays.toString(a) + " / "+ Arrays.toString(b));
//			System.out.println("-------------부모의 수 : "+count+"\n");
			int A=0,B=0;
			for(int i : a) A+=population[i];
			for(int i:b) B+=population[i];
			ans = Math.min(ans, Math.abs(A-B));
		}
	}
	
	static void combi(int index, int flag, int start) {
		if(index>=combiSize) {
			boolean[] temp = new boolean[N+1];
			for(int i=0; i<combiSize; i++) temp[combination[i]]=true;
			int[] otherCombi = new int[N-combiSize];
			int inx=0;
			for(int i=1; i<=N; i++) {
				if(!temp[i]) otherCombi[inx++] = i;
			}
			for(int i=0; i<=N; i++) parents[i]=-1;
//			System.out.println(Arrays.toString(combination));
//			System.out.println(Arrays.toString(otherCombi));
//			System.out.println("-------------");
			solution(combination, otherCombi);
			return;
		}
		for(int i=start; i<=N; i++) {
			if((flag&1<<i)==0) {
				combination[index]=i;
				combi(index+1,flag|1<<i, i);
			}
		}
	}
	
	
	static int find(int a) {
		if(parents[a]<0) return a;
		return parents[a] = find(parents[a]);
	}
	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot=find(b);
		if(aRoot!=bRoot) {
			parents[bRoot]=aRoot;
			return true;
		}
		return false;
	}
}