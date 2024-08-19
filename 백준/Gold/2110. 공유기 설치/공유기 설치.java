import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int n, c;
    static int ans;
    static int[] houses;

    public static void main(String[] args) throws IOException {
        String in[] = br.readLine().split(" ");
        n = Integer.parseInt(in[0]); // 집의 개수
        c = Integer.parseInt(in[1]); // 공유기 개수
        houses = new int[n];
        for (int i = 0; i < n; i++) {
            houses[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(houses);
        ans = 0;

        int min = 1;
        int max = houses[n - 1] - houses[0];

        while (min <= max) {
            int mid = min + (max - min) / 2;
            if (numOfWifi(mid) >= c) {
                min = mid + 1;
                ans = mid;
            } else {
                max = mid - 1;
            }

        }
        System.out.println(ans);
    }

    static int numOfWifi(int dist) {
        int count = 1; // 첫 번째 공유기 설치
        int lastPosition = houses[0]; // 첫 번째 집에 첫 번째 공유기 설치

        for (int i = 1; i < n; i++) {
            if (houses[i] - lastPosition >= dist) { // 거리 조건 만족하면
                count++; // 공유기 설치
                lastPosition = houses[i]; // 마지막 설치 위치 업데이트
            }
        }
        return count; // 설치한 공유기 개수 반환
    }
}
