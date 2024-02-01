import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	
	static int M,N;
	static String str;
	static int bit=0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		M=Integer.parseInt(br.readLine());
		StringBuilder sb=new StringBuilder();
		String[] input=new String[2];
		
		while(M>0) {
			
			input=br.readLine().split(" ");
			
			if(input[0].equals("add")) {
				bit=bit|(1<<(Integer.parseInt(input[1])-1));
			}
				
			if(input[0].equals("remove")) {
				bit=bit&~(1<<(Integer.parseInt(input[1])-1));
			}
				
			if(input[0].equals("check")) {
				int temp=bit&(1<<(Integer.parseInt(input[1])-1));
				if(temp==0) {
					sb.append("0\n");
				}
				else {
					sb.append("1\n");
				}
			}
				
			if(input[0].equals("toggle")){
				bit=bit^(1<<(Integer.parseInt(input[1])-1));
			}
				
			if(input[0].equals("all")) {
				bit=(1<<21)-1;
			}
			
			if(input[0].equals("empty")) {
				bit=0;
			}
			M--;
			}
			System.out.println(sb.toString());
		}
		
	}