import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n, k; // n: 건물의 개수, k: 건설순서의 규칙
    static int[] d; // 건물당 건설에 걸리는 시간 n개
    static int[][] xy; // 건설 순서 xy (건물 X를 지은 다음에 건물 Y를 짓는 것이 가능)
    static int w; // 백준이가 승리하기 위해 건설해야 할 건물의 번호
    static TreeMap<Integer, Integer> jinipChasoo;
    static ArrayList<Node> nodeList;

    public static void main(String[] args) throws IOException {

        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            StringTokenizer st = null;
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            jinipChasoo = new TreeMap<>();
            nodeList = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            d = new int[n + 1];
            for (int i = 1; i <= n; i++) { // 각 건물당 건설에 걸리는 시간
                d[i] = Integer.parseInt(st.nextToken());
                jinipChasoo.put(i, 0);
                nodeList.add(new Node(i, d[i])); //노드 리스트에 기본 값 갱신
            }

            xy = new int[k][2];
            for (int i = 0; i < k; i++) { // 건설 순서 xy (건물 X를 지은 다음에 건물 Y를 짓는 것이 가능)
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                xy[i][0] = x;
                xy[i][1] = y;

                jinipChasoo.put(y, jinipChasoo.get(y) + 1);// 진입 차수 갱신
                nodeList.get(x - 1).children.add(nodeList.get(y - 1)); //노드 리스트에 다음 지을 건물 갱신
                nodeList.get(y - 1).parents.add(nodeList.get(x - 1));
            }
            w = Integer.parseInt(br.readLine());

            Queue<Integer> q = new ArrayDeque<>();
            for (int i = 1; i <= jinipChasoo.size(); i++) {// 집입차수 0인 것들 큐에 넣기
                if (jinipChasoo.get(i) == 0) {
                    q.offer(i);
                }
            }

            while (!q.isEmpty()) { // 큐가 빌때까지
                int node = q.poll(); // 노드 하나 꺼내서
                Node currNode = nodeList.get(node - 1);

                currNode.totalTime = currNode.constructionTime;
                for (Node parent : currNode.parents) {
                    currNode.totalTime = Math.max(currNode.totalTime,
                        parent.totalTime + currNode.constructionTime);
                }

                for (Node child : currNode.children) {
                    jinipChasoo.put(child.val, jinipChasoo.get(child.val) - 1);
                    if (jinipChasoo.get(child.val) == 0) {
                        q.offer(child.val);
                    }
                }
            }
            bw.write(nodeList.get(w - 1).totalTime + "\n");
            bw.flush();
        } // end tc
        bw.close();
    }

    static class Node {

        int val;
        int constructionTime;
        int totalTime;
        ArrayList<Node> parents;
        ArrayList<Node> children;

        public Node(int val, int constructionTime) {
            this.val = val;
            this.constructionTime = constructionTime;
            this.totalTime = 0;
            this.parents = new ArrayList<>();
            this.children = new ArrayList<>();
        }
    }

}
