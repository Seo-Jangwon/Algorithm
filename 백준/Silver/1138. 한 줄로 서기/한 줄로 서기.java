import static java.lang.System.exit;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n;
    static int[] order; // 사람 위치
    static boolean[] used;
    static List<Integer> startArr; // 입력이 0이면 무조건 1등임을 고려할 수 있으므로
    static List<Integer> ans;

    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(br.readLine());
        order = new int[n];
        used = new boolean[n];

        startArr = new ArrayList<>();
        ans = new ArrayList<>();

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            order[i] = Integer.parseInt(input[i]);
            if (order[i] == 0) {
                startArr.add(i);
            }
        }

        for (Integer i : startArr) {
            ans.add(i);
            used[i] = true;
            dfs(1);
            used[i] = false;
            ans.remove(0);
        }

    }

    static void dfs(int dep) throws IOException {

        if (dep == n) {// 종료 조건

            if (ans.size() == n) {
                for (int i = 0; i < ans.size(); i++) {
                    bw.write(ans.get(i) + 1 + " ");
                }
            }
            bw.flush();
            bw.close();
            exit(0);
        }

        for (int i = 0; i < n; i++) {
            if (!used[i] && checkHeight(i)) {
                ans.add(i);
                used[i] = true;
                dfs(dep + 1);
                used[i] = false;
                ans.remove(dep);
            }// 줄세워지지 않았다면
        }// end for

    }

    static boolean checkHeight(int height) {// 왼쪽에 나보다 큰사람이 몇명인지
        int n = order[height];

        int cnt = 0;
        for (Integer i : ans) {
            if (i > height) {
                cnt++;
            }
        }

        if (n == cnt) {
            return true;
        } else {
            return false;
        }

    }
}
