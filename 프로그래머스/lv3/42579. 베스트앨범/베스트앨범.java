import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();

        Map<String, Integer> genresSum = new HashMap<>();
        Map<String, List<Integer>> genresNum = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            genresSum.put(genres[i], genresSum.getOrDefault(genres[i], 0) + plays[i]);

            List list;
            if (genresNum.containsKey(genres[i])) {
                list = genresNum.get(genres[i]);
            } else {
                list = new ArrayList();
            }
            list.add(i);
            genresNum.put(genres[i], list);
        }

        List<String> keySet = new ArrayList<>(genresSum.keySet());
        Collections.sort(keySet, (v1, v2) -> (genresSum.get(v2).compareTo(genresSum.get(v1))));
        for (String key : keySet) {
            List<Integer> list = genresNum.get(key);
            Collections.sort(list, (v1, v2) -> (plays[v2] < plays[v1] ? -1 : ((plays[v2] == plays[v1])) ? 0 : 1));

            for (int i = 0; i < list.size() && i < 2; i++) {
                answer.add(list.get(i));
            }
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}