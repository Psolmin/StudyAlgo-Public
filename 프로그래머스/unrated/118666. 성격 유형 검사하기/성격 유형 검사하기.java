import java.util.HashMap;
import java.util.Map;

class Solution {
    public String solution(String[] survey, int[] choices) {
        StringBuffer answer = new StringBuffer();

        Map<Character, Integer> result = new HashMap<>();

        for (int i = 0; i < survey.length; i++) {
            char disagree = survey[i].charAt(0);
            char agree = survey[i].charAt(1);

            int choice = choices[i] - 4;
            if (choice < 0) {
                if (result.containsKey(disagree)) {
                    result.put(disagree, result.get(disagree) - choice);
                } else {
                    result.put(disagree, -choice);
                }
            } else if (choice > 0) {
                if (result.containsKey(agree)) {
                    result.put(agree, result.get(agree) + choice);
                } else {
                    result.put(agree, choice);
                }
            }
        }

        // RT | CF | JM | AN
        char[][] index = {{'R', 'T'}, {'C', 'F'}, {'J', 'M'}, {'A', 'N'}};
        for (int i = 0; i < 4; i++) {
            answer.append(result.getOrDefault(index[i][0], 0) >= result.getOrDefault(index[i][1], 0) ? index[i][0] : index[i][1]);
        }

        return answer.toString();
    }
}