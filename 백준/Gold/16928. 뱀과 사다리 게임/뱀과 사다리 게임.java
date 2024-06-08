import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[] board = new int[101]; // 보드판을 나타내는 배열
	static boolean[] visited; // 방문 여부를 추적하는 배열

	public static void main(String[] args) throws IOException {
		String[] in1 = br.readLine().split(" ");
		int n = Integer.parseInt(in1[0]);
		int m = Integer.parseInt(in1[1]);

		// 보드판 초기화
		for (int i = 1; i <= 100; i++) {
			board[i] = i;
		}

		// 사다리 정보 입력
		for (int i = 0; i < n; i++) {
			String[] in2 = br.readLine().split(" ");
			int x = Integer.parseInt(in2[0]);
			int y = Integer.parseInt(in2[1]);
			board[x] = y;
		}

		// 뱀 정보 입력
		for (int i = 0; i < m; i++) {
			String[] in2 = br.readLine().split(" ");
			int u = Integer.parseInt(in2[0]);
			int v = Integer.parseInt(in2[1]);
			board[u] = v;
		}

		System.out.println(bfs());
	}

	static int bfs() {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(1);
		visited = new boolean[101];
		visited[1] = true;

		int moves = 0;

		while (!queue.isEmpty()) {
			int size = queue.size();

			for (int i = 0; i < size; i++) {
				int current = queue.poll();

				if (current == 100) {
					return moves;
				}

				for (int dice = 1; dice <= 6; dice++) {
					int next = current + dice;

					if (next <= 100 && !visited[next]) {
						visited[next] = true;
						queue.add(board[next]);
					}
				}
			}

			moves++;
		}

		return -1; // 도달할 수 없는 경우
	}
}