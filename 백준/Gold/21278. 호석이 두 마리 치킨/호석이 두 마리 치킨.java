import java.io.*;
import java.util.Arrays;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int INF = 1000000;
    static int N, M;
    static int map[][];

    public static void main(String[] args) throws IOException {

        String in1[] = br.readLine().split(" ");
        N = Integer.parseInt(in1[0]);
        M = Integer.parseInt(in1[1]);
        map = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            Arrays.fill(map[i], INF);
            map[i][i] = 0;
        }

        for (int i = 0; i < M; i++) {
            String in2[] = br.readLine().split(" ");
            int p1 = Integer.parseInt(in2[0]);
            int p2 = Integer.parseInt(in2[1]);
            map[p1][p2] = 1;
            map[p2][p1] = 1;
        }

        // 플로이드-워셜 알고리즘
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (map[i][j] > map[i][k] + map[k][j]) {
                        map[i][j] = map[i][k] + map[k][j];
                    }
                }
            }
        }

        int minDistance = INF;
        int building1 = 0;
        int building2 = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = i + 1; j <= N; j++) {
                int dist = 0;
                for (int k = 1; k <= N; k++) {
                    dist += Math.min(map[k][i], map[k][j])*2;
                }
                if(dist < minDistance) {
                    minDistance = dist;
                    building1 = i;
                    building2 = j;
                }
            }
        }
        bw.write(building1 + " " + building2 + " " + minDistance);
        bw.flush();
        bw.close();
    }
}