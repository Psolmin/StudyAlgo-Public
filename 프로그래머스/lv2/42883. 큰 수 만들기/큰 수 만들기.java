class Solution {
    public String solution(String number, int k) {
        // 4177252841
        // 1. 앞에서부터 k + 1개 중 가장 큰 수 찾는다. -> 41772 의 첫 번째 7
        // 2. 찾은 숫자를 기준으로 앞의 수만큼 k에서 빼준다 -> 41 -> k-2
        // 3. 찾은 수 다음 인덱스부터 반복.

        int index = 0;
        while (k > 0) {
            if (index + k + 1 > number.length()) {
                number = number.substring(0, index);
                break;
            }
            String sub = number.substring(index, index + k + 1);
            int i = findMaxIndex(sub.toCharArray());
            k -= i;
            if (i > 0) {
                number = number.substring(0, index) + number.substring(index + i);
            }
            index++;
        }
        return number;
    }
        private int findMaxIndex(char[] chars) {
        int max = Integer.MIN_VALUE;
        int index = 0;
        for (int i = 0; i < chars.length; i++) {
            int v = chars[i];
            if (max < v) {
                max = v;
                index = i;
            }
        }

        return index;
    }
}