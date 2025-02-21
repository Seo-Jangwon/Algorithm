import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        int[] networkAddr = new int[4];
        int[] networkMask = new int[4];

        for (int i = 0; i < n; i++) {
            String[] IpAddr = (br.readLine().split("\\."));
            int first = Integer.parseInt(IpAddr[0]);
            int second = Integer.parseInt(IpAddr[1]);
            int third = Integer.parseInt(IpAddr[2]);
            int fourth = Integer.parseInt(IpAddr[3]);

            if (i == 0) { // 초기화
                // 기본값으로
                networkAddr[0] = first;
                networkAddr[1] = second;
                networkAddr[2] = third;
                networkAddr[3] = fourth;

                networkMask[0] = 255;
                networkMask[1] = 255;
                networkMask[2] = 255;
                networkMask[3] = 255;
            } else {
                for (int j = 0; j < 4; j++) {
                    int current = 0;
                    switch (j) {
                        case 0:
                            current = first;
                            break;
                        case 1:
                            current = second;
                            break;
                        case 2:
                            current = third;
                            break;
                        case 3:
                            current = fourth;
                            break;
                    }
                    ;

                    int diff = networkAddr[j] ^ current;
                    if (diff != 0) { // 다른 곳이 존재한다면
                        int pos = 0; // 구체적으로 어디가 다른지 비트의 위치 찾기
                        while (diff > 0) {
                            diff >>= 1;
                            pos++;
                        }

                        int mask = -1 << pos; // -1은 모든 비트가 1, pos만큼 왼쪽으로 밀기
                        networkAddr[j] &= mask;
                        networkMask[j] &= mask;

                        // 이 바이트 뒤는 전부 0으로
                        for (int k = j + 1; k < 4; k++) {
                            networkAddr[k] = 0;
                            networkMask[k] = 0;
                        }
                        break;
                    }// end if

                } // end for
            } // end else

        }// end for

        StringBuilder addr = new StringBuilder();
        StringBuilder mask = new StringBuilder();

        for (int i = 0; i < 4; i++) {
            addr.append(networkAddr[i]);
            addr.append(".");
            mask.append(networkMask[i]);
            mask.append(".");
        }

        addr.replace(addr.length() - 1, addr.length(), "");
        mask.replace(mask.length() - 1, mask.length(), "");

        bw.write(addr.toString());
        bw.newLine();
        bw.write(mask.toString());
        bw.flush();
        bw.close();

    }
}
