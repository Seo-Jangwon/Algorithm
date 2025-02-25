import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n, m;
    static int[] parent;

    public static void main(String[] args) throws IOException {

        String[] input = br.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        parent = new int[n + 1];
        initParent();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            String ans = "";

            String[] input2 = br.readLine().split(" ");
            int opr = Integer.parseInt(input2[0]);
            int num1 = Integer.parseInt(input2[1]);
            int num2 = Integer.parseInt(input2[2]);

            if (opr == 0) {
                union(num1, num2);
            } else {
                if (find(num1) == find(num2)) {
                    ans = "YES";
                } else {
                    ans = "NO";
                }
                sb.append(ans).append("\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static void initParent() {
        for (int i = 0; i < n + 1; i++) {
            parent[i] = i;
        }
    }

    static void union(int n1, int n2) {
        int root1 = find(n1);
        int root2 = find(n2);
        if (root1 != root2) {
            parent[root1] = root2;
        }
    }

    static int find(int n) {
        if (n == parent[n]) {
            return n;
        }
        return parent[n] = find(parent[n]);
    }

}
