import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] arr;
    static int n, m;

    public static void main(String[] args) throws IOException {
        String[] in = br.readLine().split(" ");
        n = Integer.parseInt(in[0]);
        m = Integer.parseInt(in[1]);

        arr = new int[m];

        dfs(0, 0);

    }

    static void dfs(int start, int count) {
        if (count == m) {
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        } else {
            for (int i = start; i < n; i++) {
                arr[count] = i + 1;
                dfs(i , count + 1);
            }
        }
    }
}
