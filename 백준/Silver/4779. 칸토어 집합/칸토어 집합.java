import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {
	static char[] chList;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		String str;
		while((str=br.readLine())!=null) {
		int n=Integer.parseInt(str);
		final int len=(int) Math.pow(3, n);
		
		chList=new char[len];
		
		for(int i=0;i<len;i++) {
			chList[i]='-';
		}
		canto(0,len);
		for(char c:chList) {
			bw.write(c);
		}
		bw.newLine();
		bw.flush();
		}
	}
	
	public static void canto(int start,int len) {
		//종료조건코드 짜기
		if(len<3) {
			return;
		}
		
		int newLen=len/3;
		
		for(int i=start+newLen;i<start+(newLen*2);i++) {
			chList[i]=' ';
		}
		
		canto(start,newLen);
		canto(start+2*newLen, newLen);
		
	}
}