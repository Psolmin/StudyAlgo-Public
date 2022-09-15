import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public String solution(int[] numbers) {
        boolean flag = false;

        List<String> strNums = new ArrayList<>();
        for (int number : numbers) {
            if (flag || number > 0) {
                flag = true;
            }
            strNums.add(String.valueOf(number));
        }
        Collections.sort(strNums, (v1, v2) -> ((v2 + v1).compareTo(v1 + v2)));

        StringBuffer buffer = new StringBuffer();
        for (String s : strNums) {
            buffer.append(s);
        }

        return flag ? buffer.toString() : "0";
    }
}