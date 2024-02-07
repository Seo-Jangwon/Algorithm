import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	
	static int n;
	static int[][]paper=new int[101][101];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		n=Integer.parseInt(br.readLine());
		int count=0;
		
		for(int t=0;t<n;t++) {
			String[] input=new String[2];
			input=br.readLine().split(" ");
			
			int x=Integer.parseInt(input[0]);//가로 낮음
			int xx=x+10;//가로 높음
			int y=Integer.parseInt(input[1]);//세로 앞
			int yy=y+10;//세로 뒤
			
			for(int i=x;i<xx;i++) {
				for(int j=y;j<yy;j++) {
				paper[i][j]=1;
				
				}
			}
			
			
		}//end for t
		
		
		for(int i=0;i<101;i++) {
			for(int j=0;j<101;j++) {
				
				if(paper[i][j]==1 && i-1>=0 && paper[i-1][j]==0)count++;
				if(paper[i][j]==1 && i+1<101 && paper[i+1][j]==0)count++;
				if(paper[i][j]==1 && j-1>=0 && paper[i][j-1]==0)count++;
				if(paper[i][j]==1 && i+1<101 && paper[i][j+1]==0)count++;
				
				
			}//end for j
		}//end for i
		
		System.out.println(count);
	}//end main

}