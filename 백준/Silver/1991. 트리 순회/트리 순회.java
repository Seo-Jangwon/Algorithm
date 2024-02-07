import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static LinkedList<Node> nodeArr=new LinkedList<Node>();
	static StringBuilder Fsb=new StringBuilder();
	static StringBuilder Csb=new StringBuilder();
	static StringBuilder Rsb=new StringBuilder();
	static boolean[] v;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		// TODO Auto-generated method stub
		int N=Integer.parseInt(br.readLine());
		v=new boolean[N];
		
		for(int i=0;i<N;i++) {
			String[] input=new String[3];
			input=br.readLine().split(" ");
			nodeArr.add(new Node(input[0],input[1],input[2]));
		}
		
		Fdfs("A");
		bw.write(Fsb.toString());
		bw.newLine();
		Cdfs("A");
		bw.write(Csb.toString());
		bw.newLine();
		Rdfs("A");
		bw.write(Rsb.toString());
		bw.flush();
	}
	
	public static void Fdfs(String node) {//전위 순회
		Node tempN=null;
		for(int i=0;i<nodeArr.size();i++) {//node라는 이름의 노드 찾기
			if(nodeArr.get(i).getNode().equals(node)) {
				tempN=nodeArr.get(i);
			}
		}
		
		Fsb.append(tempN.getNode());//현재 노드 저장
		
		if(tempN.isLeftSon()) {//좌측 자식이 존재하면 방문
			Fdfs(tempN.getLeftSon());
		}
		
		if(tempN.isRightSon()) {//우측 자식이 존재하면 방문
			Fdfs(tempN.getRightSon());
		}
		
		return;
	}
	
	public static void Cdfs(String node) {//중위 순회
		Node tempN=null;
		for(int i=0;i<nodeArr.size();i++) {//node라는 이름의 노드 찾기
			if(nodeArr.get(i).getNode().equals(node)) {
				tempN=nodeArr.get(i);
			}
		}
		
		if(tempN.isLeftSon()) {//좌측 자식이 존재하면 방문
			Cdfs(tempN.getLeftSon());
		}
		
		Csb.append(tempN.getNode());//현재 노드 저장
		
		if(tempN.isRightSon()) {//우측 자식이 존재하면 방문
			Cdfs(tempN.getRightSon());
		}
		
		return;
	}
	
	public static void Rdfs(String node) {//후위 순회
		Node tempN=null;
		for(int i=0;i<nodeArr.size();i++) {//node라는 이름의 노드 찾기
			if(nodeArr.get(i).getNode().equals(node)) {
				tempN=nodeArr.get(i);
			}
		}
		
		if(tempN.isLeftSon()) {//좌측 자식이 존재하면 방문
			Rdfs(tempN.getLeftSon());
		}
		
		if(tempN.isRightSon()) {//우측 자식이 존재하면 방문
			Rdfs(tempN.getRightSon());
		}
		
		Rsb.append(tempN.getNode());//현재 노드 저장
		
		return;
	}
	

	static class Node {//노드 클래스
		private String node;
		private String sonL;
		private String sonR;
		
		Node(String node, String sonL, String sonR){
			this.node=node;
			this.sonL=sonL;
			this.sonR=sonR;
		}
		public String getNode() {
			return node;
		}
		
		public boolean isLeftSon() {
			if(!sonL.equals(".")) {return true;}
			else {return false;}
		}
		
		public String getLeftSon() {
			return sonL;
		}
		
		public boolean isRightSon() {
			if(!sonR.equals(".")) {return true;}
			else {return false;}
		}
		
		
		public String getRightSon() {
			return sonR;
		}
	}

}