import java.io.*;
import java.util.Arrays;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N, K;
    static int[] Xs;

    public static void main(String[] args) throws IOException {

        String in1[] = br.readLine().split(" ");
        N = Integer.parseInt(in1[0]);// N개의 캐릭터
        K = Integer.parseInt(in1[1]);// 올릴 수 있는 레벨 총합

        Xs = new int[N];
        for (int i = 0; i < N; i++) {
            Xs[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(Xs);

        long low=Xs[0];
        long high=Xs[0]+K;
        
        while (low < high) {
            long mid = (low + high + 1) / 2;

            if (achive(Xs, N, K, mid)) {
                low = mid;// 목표 달성이 가능하면 low를 중간값으로
            } else {
                high = mid - 1;// 목표달성이 불가능하면 high를 중간값-1로
            }
        }
        
        System.out.println(low);
    }
    
    private static boolean achive(int[] Xs, int N, long K, long target) {
    	long totalIncrease=0;
    	
    	for(int i=0;i<N;i++) {
    		if(Xs[i]<target) {
    			totalIncrease+=target-Xs[i];
    			if(totalIncrease>K) {
    				return false;
    			}
    		}
    	}
    	return true;
    }
}