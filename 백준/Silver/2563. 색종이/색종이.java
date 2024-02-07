import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	
	static int n;
	static int[][]paper=new int[100][100];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		n=Integer.parseInt(br.readLine());
		int count=0;
		
		for(int t=0;t<n;t++) {
			String[] input=new String[2];
			input=br.readLine().split(" ");
			
			int x=Integer.parseInt(input[0]);
			int y=Integer.parseInt(input[1]);
			
			for(int i=y;i<y+10;i++) {
				for(int j=x;j<x+10;j++) {
					
					paper[i][j]=1;
					
				}//end for j
			}//end for i
			
		}//end for t
		
		for(int i=0;i<100;i++) {
			for(int j=0;j<100;j++) {
				
				if(paper[i][j]==1)count+=1;
				
			}//end for j
		}//end for i
		
		System.out.println(count);
	}//end main

}
