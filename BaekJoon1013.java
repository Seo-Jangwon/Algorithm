package codingTest.Gold5;
import java.util.Scanner;


public class BaekJoon1013 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String vega="(100+1+ | 01)+";
        int t=sc.nextInt();

        for(int tc=0;tc<t;tc++){
            String str=sc.next();
            if (str.matches(vega)){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
}
