class Solution {
    public int solution(String s) {
        if (s.length() == 1) {
            return 1;
        }
        
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= s.length() / 2; i++) {
            int len = Compress(s, i);
            if (len < min) {
                min = len;
            }
        }

        return min;
    }

    private int Compress(String s, int length) {

        int count = 1;
        StringBuffer newString = new StringBuffer();
        for (int i = 0; i < s.length(); ) {
            String str = i + length < s.length() ? s.substring(i, i + length) : s.substring(i);
            for (int j = i + length; j < s.length(); ) {
                if (str.equals(j + length < s.length() ? s.substring(j, j + length) : s.substring(j))) {
                    count++;
                    j += length;
                } else {
                    break;
                }
            }

            if (count > 1) {
                newString.append(count).append(str);
                i += count * length;
                count = 1;
            } else {
                newString.append(str);
                i += length;
            }
        }

        return newString.length();
    }

}