package com.psol.algorithm.짝지어_제거하기;

public class Solution
{
    public int solution(String s)
    {
        String str = s;
        while (true) {
            if (s.length() == 0) {
                return 1;
            }

            str = remove(s);
            System.out.println("s = " + s + ", str = " + str);
            if (str == s) {
                break;
            }

            s = str;
        }

        return 0;
    }

    String remove(String s) {

        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        for (int i = 1; i < chars.length; i++) {
            if (chars[i - 1] != chars[i]) {
                sb.append(chars[i - 1]);
                System.out.println(i + " " + sb.toString());
            } else {
                i += 2;
            }
        }

        return sb.toString();
    }
}
