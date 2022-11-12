import java.util.*;

class Solution {
    private class Node {
        String city;
        boolean visit;

        public Node(String city, boolean visit) {
            this.city = city;
            this.visit = visit;
        }
    }

    private List<String> all = new ArrayList<>();

    public String[] solution(String[][] tickets) {
        String[] answer;

        Map<String, List<Node>> city = new HashMap<>();
        Arrays.sort(tickets, Comparator.comparing(o -> o[1]));
        for (String[] ticket : tickets) {
            String start = ticket[0];
            String end = ticket[1];

            List list;
            if (city.containsKey(start)) {
                list = city.get(start);
            } else {
                list = new ArrayList();
                city.put(start, list);
            }
            list.add(new Node(end, false));
        }

        dfs(city, "ICN", 0, tickets.length, "ICN");
        // System.out.println(all);
//
//        Queue<String> queue = new LinkedList<>();
//        queue.offer("ICN");
//
//        while (!queue.isEmpty()) {
//            String cur = queue.poll();
//
//            for (Node next : city.get(cur)) {
//                if (next.visit) {
//                    continue;
//                }
//
//                queue.offer(next.city);
//            }
//        }
        // System.out.println(all.get(0));
        answer = all.get(0).split(" ");
        // System.out.println(Arrays.toString(answer));
        return answer;
    }

    private void dfs(Map<String, List<Node>> city, String cur, int count, int complete, String answer) {
        if (count == complete) {
            all.add(answer);
        }

        if (city.containsKey(cur)) {
            for (Node next : city.get(cur)) {
                if (next.visit) {
                    continue;
                }

                next.visit = true;
                dfs(city, next.city, count + 1, complete, answer + " " + next.city);
                next.visit = false;
            }
        }
    }

}