import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        Map<Integer, List<Integer>> tree = new HashMap<>();
        for (int[] wire : wires) {
            put(tree, wire, 0, 1);
            put(tree, wire, 1, 0);
        }

        int min = Integer.MAX_VALUE;
        for (int[] wire : wires) {
            int[] visit = new int[n + 1];

            int[] value = new int[2];
            int c = 0;
            for (int i = 1; i <= n; i++) {
                int v = bfs(tree, visit, i, wire[0], wire[1]);
                if (v != 0) {
                    value[c++] = v;
                }
            }
            Arrays.sort(value);
            if (value[1] - value[0] < min) {
                min = value[1] - value[0];
            }
        }

        return min;
    }

    private int bfs(Map<Integer, List<Integer>> tree, int[] visit, int start, int a, int b) {
        int network = 0;

        Queue<Integer> q = new LinkedList<>();
        q.offer(start);

        while (!q.isEmpty()) {
            int n = q.poll();
            if (!tree.containsKey(n) || visit[n] != 0) {
                continue;
            }

            network++;
            visit[n]++;
            for (int i : tree.get(n)) {
                if ((n == a && i == b) || (n == b && i == a)) {
                    continue;
                }

                if (visit[i] == 0) {
                    q.offer(i);
                }
            }
        }

        return network;
    }

    private void put(Map<Integer, List<Integer>> tree, int[] wire, int a, int b) {
        List<Integer> list;
        if (tree.containsKey(wire[a])) {
            list = tree.get(wire[a]);
        } else {
            list = new ArrayList<>();
        }
        list.add(wire[b]);
        tree.put(wire[a], list);
    }
}