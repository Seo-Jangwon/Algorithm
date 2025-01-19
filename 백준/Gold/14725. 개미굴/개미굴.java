import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Map;
import java.util.TreeMap;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N;
    static Node root;

    public static void main(String[] args) throws IOException {

        root = new Node("");
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            int len = Integer.parseInt(input[0]);
            String[] foods = new String[len];
            for (int j = 0; j < len; j++) {
                foods[j] = input[j + 1];
            }
            makeTree(foods);
        }

        printTree(root, 0);
        bw.flush();
        bw.close();

    }

    static void makeTree(String[] foods) {
        Node curr = root;
        for (String food : foods) { // 먹이 정보 돌면서
            if (!curr.node.containsKey(food)) { //현재 노드 자식 중 이 먹이 정보가 없으면
                curr.node.put(food, new Node(food)); // 현재 노드 자식으로 추가
            }
            curr = curr.node.get(food); // 현재 위치는 자식 노드로
        }
    }

    static void printTree(Node curr, int dep) throws IOException {

        if (dep > 0) {
            for (int i = 0; i < dep - 1; i++) {
                bw.write("--");
            }
            bw.write(curr.food);
            bw.newLine();
        }

        for (Node n : curr.node.values()) {
            printTree(n, dep + 1);
        }
    }

    static class Node {

        String food;
        Map<String, Node> node;

        public Node(String food) {
            this.food = food;
            node = new TreeMap<>();
        }
    }
}
