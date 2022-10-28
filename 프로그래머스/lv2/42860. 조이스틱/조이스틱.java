class Solution {
    public int solution(String name) {
        int answer = 0;

        int move = name.length() - 1;
        int index;
        for (int i = 0; i < name.length(); i++) {
            answer += updown(name.charAt(i));

            index = i + 1;
            while (index < name.length() && name.charAt(index) == 'A') {
                index++;
            }

            move = Math.min(move, (i * 2) + name.length() - index);
            move = Math.min(move, (name.length() - index) * 2 + i);
        }
        return answer + move;
    }
    private int updown(char c) {
        return c - 'N' < 0 ? c - 'A' : 'Z' - c + 1;
    }
}