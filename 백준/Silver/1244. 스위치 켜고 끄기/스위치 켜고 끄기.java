import java.util.Scanner;

public class Main {

	static int[]switchArr;
	static int[][]stuArr;
	static int nS;
	static int nH;
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		nS=sc.nextInt();
		switchArr=new int[nS];
		for(int i=0;i<nS;i++) {
			int input=sc.nextInt();
			switchArr[i]=input;
		}
		nH=sc.nextInt();
		stuArr=new int[nH][2];
		for(int i=0;i<nH;i++) {
			int input1=sc.nextInt();
			int input2=sc.nextInt();
			stuArr[i][0]=input1;
			stuArr[i][1]=input2;
		}
		find(0);
		
	}
	
	
	public static void find(int count) {
		if(count==nH) {
			for(int i=0;i<nS;i++) {
				System.out.print(switchArr[i]+" ");
				if((i+1)%20==0) {
					System.out.println();
				}
			}
		}else {
			if(stuArr[count][0]==1) {
				for(int i=0;i<nS;i++) {
					if((i+1)%stuArr[count][1]==0) {
						if(switchArr[i]==0) {
							switchArr[i]=1;
						}//if
						else if(switchArr[i]==1) {
							switchArr[i]=0;
						}//if
					}//if
				}//for
			}//if
			else if(stuArr[count][0]==2) {
				int i=1;
				while(true) {
					if(stuArr[count][1]-i-1>=0 && stuArr[count][1]+i-1<nS && switchArr[stuArr[count][1]+i-1]==switchArr[stuArr[count][1]-i-1]) {
						if(switchArr[stuArr[count][1]+i-1]==0) {
							switchArr[stuArr[count][1]+i-1]=1;
							switchArr[stuArr[count][1]-i-1]=1;
						}//if
						else if(switchArr[stuArr[count][1]+i-1]==1) {
							switchArr[stuArr[count][1]+i-1]=0;
							switchArr[stuArr[count][1]-i-1]=0;
						}//if
						i+=1;
					}else {
						break;
					}
				}
				
				if(switchArr[stuArr[count][1]-1]==0) {
					switchArr[stuArr[count][1]-1]=1;
				}//if
				else if(switchArr[stuArr[count][1]-1]==1) {
					switchArr[stuArr[count][1]-1]=0;
				}//if
				
			}
			
			find(count+=1);
		}
		
		
	}
}