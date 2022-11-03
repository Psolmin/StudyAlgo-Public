import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    int[] dr = {-1, 0, 1, 0};
    int[] dc = {0, 1, 0, -1};

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        int[][] map = new int[101][101];
        for (int i = 0; i < 101; i++) {
            Arrays.fill(map[i], -2);
        }
//        boolean[][] visit = new boolean[101][101];

        for (int[] rec : rectangle) {
            int leftCol = 2 * rec[0];
            int leftRow = 2 * rec[1];
            int rightCol = 2 * rec[2];
            int rightRow = 2 * rec[3];

            for (int c = leftCol; c <= rightCol; c++) {
                // (c, leftRow), (c, rightRow)
                map[leftRow][c] = -1;
                map[rightRow][c] = -1;
            }

            for (int r = leftRow; r <= rightRow; r++) {
                // (c, leftRow), (c, rightRow)
                map[r][leftCol] = -1;
                map[r][rightCol] = -1;
            }
        }

        for (int[] rec : rectangle) {
            int leftCol = 2 * rec[0];
            int leftRow = 2 * rec[1];
            int rightCol = 2 * rec[2];
            int rightRow = 2 * rec[3];

            for (int c = leftCol + 1; c < rightCol ; c++) {
                for (int r = leftRow + 1; r < rightRow; r++) {
                    map[r][c] = -2;
                }
            }
        }

        Queue<RC> queue = new LinkedList<>();
        RC rc = new RC(2 * characterY, 2 * characterX);
        queue.offer(rc);
        map[rc.r][rc.c] = 0;

        while (!queue.isEmpty()) {
            RC cur = queue.poll();
            if (cur.r == (2 * itemY) && cur.c == (2 * itemX)) {
                return map[cur.r][cur.c] / 2;
            }

            for (int i = 0; i < 4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];

                if (nr < 0 || nr >= 101 || nc < 0 || nc >= 101 || map[nr][nc] != -1) {
                    continue;
                }
                queue.offer(new RC(nr, nc));
                map[nr][nc] = map[cur.r][cur.c] + 1;
            }
        }

        return -1;
    }

    private class RC {
        int r;
        int c;

        public RC(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}