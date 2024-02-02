import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

import javax.print.DocFlavor.STRING;

public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb=new StringBuilder();
	static int n;
	static int k;
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		LinkedList<Integer> list=new LinkedList<Integer>();
		
		String[] str=new String[2];
		str=br.readLine().split(" ");
		n=Integer.parseInt(str[0]);
		k=Integer.parseInt(str[1]);
		
		for(int i=1;i<n+1;i++) {
			list.add(i);
		}
		sb.append("<");
		int idx=k-1;
		int tempIdx=0;
		while(!list.isEmpty()) {
			if(idx>=list.size()) {
				idx=idx%list.size();
			}
			if(list.size()==1) {
				sb.append(Integer.toString(list.get(idx))+">");
				break;
			}
			sb.append(Integer.toString(list.get(idx))+", ");
			list.remove(idx);
			idx+=k-1;

		}
		System.out.println(sb);
		
	}
}