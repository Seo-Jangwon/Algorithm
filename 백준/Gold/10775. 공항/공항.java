import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int G; // 게이트 개수
    static int P; // 비행기 개수

    static int[] gateAvalable;

    public static void main(String[] args) throws IOException {

        G = Integer.parseInt(br.readLine());
        P = Integer.parseInt(br.readLine());

        gateAvalable = new int[G + 1];
        for (int i = 1; i <= G; i++) {
            gateAvalable[i] = i;
        }

        int ans = 0;
        for (int i = 1; i <= P; i++) {
            int plane = Integer.parseInt(br.readLine());

            // 함수를 돌면서 gateAvalable에서 도킹 가능한 곳이 있다면 그 게이트 반환, 아니라면 0반환 및 break
            int gate = findGateAvalable(plane);
            if (gate > 0) {
                ans++;
                gateAvalable[gate] = findGateAvalable(gate - 1);

            } else {
                break;
            }
        }

        bw.write(ans + "");
        bw.flush();
        bw.close();
    }

    private static int findGateAvalable(int plane) {
        if (plane <= 0) {
            return 0;
        }
        if (gateAvalable[plane] == plane) { // 한 번도 안 쓰인 게이트
            return plane;
        }
        return gateAvalable[plane] = findGateAvalable(gateAvalable[plane]);
    }


}
