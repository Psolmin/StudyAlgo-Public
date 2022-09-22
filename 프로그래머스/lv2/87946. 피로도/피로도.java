class Solution {
    int max = Integer.MIN_VALUE;
    boolean[] visit;
    public int solution(int k, int[][] dungeons) {
//        int answer = -1;
        visit = new boolean[dungeons.length];
        dfs(dungeons, k, 0);

        return max;
    }

    private void dfs(int[][] dungeons, int k, int clear) {
        for (int i = 0; i < dungeons.length; i++) {
            if (visit[i] || k < dungeons[i][0]) {
                continue;
            }
            visit[i] = true;
            dfs(dungeons, k - dungeons[i][1], clear + 1);
            visit[i] = false;
        }

        if (clear > max) {
            max = clear;
        }
    }
}