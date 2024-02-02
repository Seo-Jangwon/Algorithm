import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Solution {
	
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static int win;
	static int draw;
	static int count;
	static int[] cardKyu;
	static int[] cardIn;
	static boolean[] cards;
	static boolean[] v;

	public static void main(String[] args) throws NumberFormatException, IOException {
	
	int t=Integer.parseInt(br.readLine());
	
	for(int tc = 1; tc <= t; tc++)
	{	cardKyu=new int[9];
		cardIn=new int[9];
		cards=new boolean[19];
		v=new boolean[9];
		
		win=0;
		draw=0;
		count=0;
		
		String[] input=br.readLine().split(" ");
		for(int i=0;i<9;i++) {
			cardKyu[i]=Integer.parseInt(input[i]);
			cards[cardKyu[i]]=true;
		}
		
		int tempIdx1=0;
		for(int i=1;i<19;i++) {
			if(cards[i]==false) {
				cardIn[tempIdx1]=i;
				tempIdx1++;
			}
		}
		
		dfs(0,0,0);
		
		bw.write("#"+Integer.toString(tc)+" "+Integer.toString(win)+" "+Integer.toString(count-win-draw));
		bw.newLine();
		bw.flush();
	}
	}
	
	
	public static void dfs(int cnt, int sum1, int sum2) {
		if(cnt==9) {
			count+=1;
			if(sum1>sum2) {
				win+=1;
			}
			if (sum1==sum2){
				draw+=1;
			}
			return;
		}
		
		for(int i=0;i<9;i++) {
			if(!v[i]) {
				v[i]=true;
				if(cardKyu[cnt]>cardIn[i]) {
					dfs(cnt+1,(sum1+cardKyu[cnt]+cardIn[i]),sum2);
				}
				else{
					dfs(cnt+1,sum1,(sum2+cardKyu[cnt]+cardIn[i]));
				}
				v[i]=false;
			}
		}
		
	}
}
