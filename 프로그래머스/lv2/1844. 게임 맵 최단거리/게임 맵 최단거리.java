import java.util.LinkedList;
import java.util.Queue;

class Solution {
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};

    int min = Integer.MAX_VALUE;
    public int solution(int[][] maps) {
        boolean[][] visit = new boolean[maps.length][maps[0].length];
//        visit[maps.length - 1][maps[0].length - 1] = true;
        bfs(maps, visit);

//        dfs(maps, visit, maps.length - 1, maps[0].length - 1, 1);

        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private class XY {
        int x;
        int y;
        int move;

        public XY(int x, int y, int move) {
            this.x = x;
            this.y = y;
            this.move = move;
        }
    }

    private void bfs(int[][] maps, boolean[][] visit) {
        Queue<XY> q = new LinkedList<>();
        q.add(new XY(0,0, 1));
        visit[0][0] = true;

        while (!q.isEmpty()) {
            XY xy = q.poll();
            if (xy.x == maps.length - 1 && xy.y == maps[0].length - 1) {
                if (xy.move < min) {
                    min = xy.move;
                }
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = xy.x + dx[i];
                int ny = xy.y + dy[i];
                if (nx < 0 || nx >= maps.length || ny < 0 || ny >= maps[0].length || visit[nx][ny] || maps[nx][ny] == 0) {
                    continue;
                }
                visit[nx][ny] = true;
                q.add(new XY(nx, ny, xy.move + 1));
            }
        }
    }


    private void dfs(int[][] maps, boolean[][] visit, int x, int y, int move) {
        System.out.println("x = " + x + ", y = " + y + " --> " + move);

        if (maps[x][y] == 0) {
            return;
        }

        if (x == 0 && y == 0) {
            if (move < min) {
                min = move;
            }
            System.out.println("min = " + min);
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx >= maps.length || ny < 0 || ny >= maps[0].length || visit[nx][ny]) {
                continue;
            }
            visit[nx][ny] = true;
            dfs(maps, visit, nx, ny, move + 1);
            visit[nx][ny] = false;
        }
    }
}