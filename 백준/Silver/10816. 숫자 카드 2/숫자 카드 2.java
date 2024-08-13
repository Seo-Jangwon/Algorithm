import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static String[] nums;
    static int M;
    static String[] sangeun;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine().trim());
        String[] nums = br.readLine().trim().split(" ");
        int M = Integer.parseInt(br.readLine().trim());
        String[] sangeun = br.readLine().trim().split(" ");

        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        StringBuilder result = new StringBuilder();
        // 쿼리 처리
        for (String query : sangeun) {
            result.append(map.getOrDefault(query, 0)).append(" ");
        }

        System.out.println(result.toString().trim());
    }
}