import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n, ans;
    static int[] arr;

    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        ans = Integer.MAX_VALUE;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if(arr[i] <= arr[j]){
                    int left = i + 1;
                    int right = j - 1;
                    int sumElsa = arr[i] + arr[j];

                    while (left < right) {
                        if (arr[left] <= arr[right]) {
                            int sumAnna = arr[left] + arr[right];
                            int diff = sumElsa - sumAnna;
                            ans = Math.min(Math.abs(diff), ans);

                            if (diff < 0) {
                                right--;
                            } else {
                                left++;
                            }
                        }
                    }
                }
            }
        }

        bw.write(ans + "");
        bw.flush();
        bw.close();

    }

}
