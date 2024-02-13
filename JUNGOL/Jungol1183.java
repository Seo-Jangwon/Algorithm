import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		int N=Integer.parseInt(br.readLine());
		int[] coins=new int[6];// 1, 5, 10, 50, 100, 500원 순으로 저장
		int[] ans=new int[6];
		int total=0;
		int count=0;
		
		String[] input=br.readLine().split(" ");
		for(int i=0;i<6;i++) {
			coins[i]=Integer.parseInt(input[i]);
			if(i==0)total+=coins[i]*500;
			if(i==1)total+=coins[i]*100;
			if(i==2)total+=coins[i]*50;
			if(i==3)total+=coins[i]*10;
			if(i==4)total+=coins[i]*5;
			if(i==5)total+=coins[i];
		}
		
		int target=total-N;
		//System.out.println(target);
		while(target>=0) {
			
			for(int i=coins[0];i>=0;i--) {
				if(target-i*500>=0) {
					//System.out.println("500 : "+ i +"개. target : "+(target-i*500)+" ee : "+(coins[0]-i));
					ans[0]=coins[0]-i;
					count+=ans[0];
					target=target-i*500;
					break;
				}
			}//end 500
			
			for(int i=coins[1];i>=0;i--) {
				if(target-i*100>=0) {
					//System.out.println("100 : "+ i +"개. target : "+(target-i*100)+" ee : "+(coins[1]-i));
					ans[1]=coins[1]-i;
					count+=ans[1];
					target=target-i*100;
					break;
				}
			}//end 100
			
			for(int i=coins[2];i>=0;i--) {
				if(target-i*50>=0) {
					//System.out.println("50 : "+ i +"개. target : "+(target-i*50)+" ee : "+(coins[2]-i));
					ans[2]=coins[2]-i;
					count+=ans[2];
					target=target-i*50;
					break;
				}
			}//end 50
			
			for(int i=coins[3];i>=0;i--) {
				if(target-i*10>=0) {
					//System.out.println("10 : "+ i +"개. target : "+(target-i*10)+" ee : "+(coins[3]-i));
					ans[3]=coins[3]-i;
					count+=ans[3];
					target=target-i*10;
					break;
				}
			}//end 10
			
			for(int i=coins[4];i>=0;i--) {
				if(target-i*5>=0) {
					//System.out.println("5 : "+ i +"개. target : "+(target-i*5)+" ee : "+(coins[4]-i));
					ans[4]=coins[4]-i;
					count+=ans[4];
					target=target-i*5;
					break;
				}
			}//end 5
			
			for(int i=coins[5];i>=0;i--) {
				if(target-i*1==0) {
					//System.out.println("1 : "+ i +"개. target : "+(target-i)+" ee : "+(coins[5]-i));
					ans[5]=coins[5]-i;
					count+=ans[5];
					target=target-i*1;
					break;
				}
			}//end 1
			break;
		}//end while
		
		
		bw.write(Integer.toString(count));
		bw.newLine();
		for(int i=0;i<6;i++) {
			bw.write(Integer.toString(ans[i])+" ");
		}
		bw.flush();
	}

}
