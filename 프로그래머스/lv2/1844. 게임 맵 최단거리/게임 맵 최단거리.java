import java.util.LinkedList;
import java.util.Queue;

class Solution {
    int[] nr = {-1, 0, 1, 0};
    int[] nc = {0, 1, 0, -1};
    int n;
    int m;

    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;

        boolean[][] visit = new boolean[n][m];
        Queue<RC> queue = new LinkedList<>();
        queue.offer(new RC(0, 0, 1));
        visit[0][0] = true;

        while (!queue.isEmpty()) {
            RC cur = queue.poll();
            int r = cur.r;
            int c = cur.c;
            int move = cur.move;
            if (r == n - 1 && c == m - 1) {
                return move;
            }

            for (int i = 0; i < 4; i++) {
                int row = r + nr[i];
                int col = c + nc[i];
                if (checkRC(row, col) || visit[row][col] || maps[row][col] == 0) {
                    continue;
                }
                queue.offer(new RC(row, col, move + 1));
                visit[row][col] = true;
            }
        }

        return -1;
    }

    private boolean checkRC(int row, int col) {
        return row < 0 || row >= n || col < 0 || col >= m;
    }

    private class RC {
        int r;
        int c;
        int move;

        public RC(int r, int c, int move) {
            this.r = r;
            this.c = c;
            this.move = move;
        }
    }
}