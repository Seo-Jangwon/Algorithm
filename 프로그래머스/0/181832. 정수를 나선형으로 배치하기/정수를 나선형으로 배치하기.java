class Solution {

    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};

    public static int[][] solution(int n) {
        int[][] answer = new int[n][n];

        int y = 0;
        int x = 0;
        int d = 0;
        answer[0][0] = 1;
        for (int i = 2; i <= n * n; i++) {
            int ny = y + dy[d];
            int nx = x + dx[d];


            if (ny >= 0 && ny < n && nx >= 0 && nx < n && answer[ny][nx] == 0) {
                answer[ny][nx] = i;

                y = ny;
                x = nx;
            } else {
                d = (d += 1) % (4);
                ny = y + dy[d];
                nx = x + dx[d];
                y=ny;
                x=nx;
                answer[ny][nx] = i;

            }

        }

        return answer;
    }

}