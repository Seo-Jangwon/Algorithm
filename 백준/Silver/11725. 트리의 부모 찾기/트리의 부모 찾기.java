import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static ArrayList<Integer>[] tree;
    static int[] parent;
    static boolean[] visited;
    static int N;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        tree = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        parent = new int[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i < N; i++) {
            String[] input = br.readLine().split(" ");

            int parent = Integer.parseInt(input[0]);
            int child = Integer.parseInt(input[1]);

            tree[parent].add(child);
            tree[child].add(parent);
        }

        dfs(1);

        for (int i = 2; i <= N; i++) {
            bw.write(String.valueOf(parent[i]));
            bw.newLine();
            bw.flush();
        }
        bw.close();

    }

    static void dfs(int curr) {
        visited[curr] = true;
        for (int next : tree[curr]) {
            if (!visited[next]) {
                parent[next] = curr;
                dfs(next);
            }
        }
    }

}
