package com.psol.algorithm.kakao_05;

import java.util.Stack;

public class Solution {
    public class Bracket {
        public char ch;
        public int index;

        public Bracket(char ch, int index) {
            this.ch = ch;
            this.index = index;
        }
    }
    public int solution(String s) {
        int answer = 0;
        Stack<Bracket> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            boolean isIncorrect = false;

            char insertChar = '_';
            switch (ch) {
                case '(': case '{': case '[':
                    stack.push(new Bracket(ch, i));
                    break;

                case ')':
                    if (stack.isEmpty() || (ch = stack.pop().ch) != '(') {
                        isIncorrect = true;
                        System.out.println(1 + "@@@" + ch);
                        insertChar = convert(ch);
                    }
                    break;

                case '}':
                    if (stack.isEmpty() || (ch = stack.pop().ch) != '{') {
                        isIncorrect = true;
                        System.out.println(2 + "@@@" + ch);
                        insertChar = convert(ch);
                    }
                    break;

                case ']':
                    if (stack.isEmpty() || (ch = stack.pop().ch) != '[') {
                        isIncorrect = true;
                        System.out.println(3 + "@@@" + ch);
                        insertChar = convert(ch);
                    }
                    break;
            }

            if(isIncorrect) {
                if (stack.isEmpty()) {
                    insertChar = convert(s.charAt(i));
                    String str = s.substring(0, i);


                } else {
                    Bracket b = stack.pop();
                    String str = s.substring(b.index + 1, i);
                    System.out.println(str);
                }


                System.out.println(insertChar);
                break;
            } else {

            }
        }
        return answer;
    }

//    public static boolean isCorrect(String s, ) {
//        if(s.length()%2 != 0) return false;
//        Stack<Character> stack = new Stack<Character>();
//        for(int i =0; i<s.length(); i++) {
//            switch(s.charAt(i)) {
//                case ')':
//                    if(stack.peek() == '(') stack.pop();
//                    break;
//                case '}':
//                    if(stack.peek() == '{') stack.pop();
//                    break;
//                case ']':
//                    if(stack.peek() == '[') stack.pop();
//                    break;
//                default :
//                    stack.push(s.charAt(i));
//                    break;
//            }
//        }
//        return stack.empty();
//    }

    public char convert(char ch) {
        switch (ch) {
            case '(':
                return ')';
            case '{':
                return '}';
            case '[':
                return ']';
            case ')':
                return '(';
            case '}':
                return '{';
            case ']':
                return '[';
        }
        return ch;
    }
}
