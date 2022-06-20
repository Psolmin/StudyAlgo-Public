package com.psol.algorithm.kakao_02;

import java.util.*;

//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//public class Solution {
//    public void checkPrev(int index, int[] colors, List<Integer> removeList) {
//        if(colors[index - 2] == 0) {
//            return;
//        }
//
//        removeList.add(index);
//        colors[index] = colors[index - 2] == 1 ? 2 : 1;
//    }
//
//    public void checkNext(int index, int[] colors, List<Integer> removeList) {
//        if(colors[index + 2] == 0) {
//            return;
//        }
//
//        removeList.add(index);
//        colors[index] = colors[index + 2] == 1 ? 2 : 1;
//    }
//
//
//
//    public int[] solution(int[] black_caps) {
//        int[] colors = new int[black_caps.length];
//
//        for (int i = 0; i < black_caps.length; i++) {
//            if (i == 0) {
//                colors[i + 1] = black_caps[i] == 0 ? 2 : 1;
//                continue;
//            }
//
//            if (i == black_caps.length - 1) {
//                colors[i - 1] = black_caps[i] == 0 ? 2 : 1;
//                continue;
//            }
//
//            if (black_caps[i] == 2) {
//                colors[i - 1] = 1;
//                colors[i + 1] = 1;
//            }
//
//            if (black_caps[i] == 0) {
//                colors[i - 1] = 2;
//                colors[i + 1] = 2;
//            }
//        }
//
//        Set<Integer> indexSet = new HashSet<>();
//
//        for (int i = 0; i < colors.length; i++) {
//            if(colors[i] == 0) {
//                indexSet.add(i);
//            }
//        }
//
//        while (indexSet.size() > 0) {
//            List<Integer> removeList = new ArrayList<>();
//
//            for(int i : indexSet) {
//                if (i == 0) {
//                    checkNext(i, colors, removeList);
//                    continue;
//                }
//
//                if(i == colors.length - 1) {
//                    checkPrev(i, colors, removeList);
//                    continue;
//                }
//
//                checkPrev(i, colors, removeList);
//
//                if(colors[i] == 0) {
//                    checkNext(i, colors, removeList);
//                }
//            }
//
//            if (removeList.size() == 0) {
//                break;
//            }
//
//            indexSet.removeAll(removeList);
//        }
//
//        return colors;
//    }
//}

import java.util.regex.*;
public class Solution {
    public static class Key {
        Set<String> key;
        int score;

        public Key(Set<String> key, int score) {
            this.key = key;
            this.score = score;
        }
    }
    public static int solution(String[] sentences, int n) {
//        int answer = 0;

        List<Key> setList = new ArrayList<>();
        for (String str : sentences) {
            Set<String> key = new HashSet<>();

            for (char c : str.toCharArray()) {
                if (c == ' ') {
                    continue;
                }

                if (Pattern.matches("[A-Z]", String.valueOf(c))) {
                    key.add("shift");
                }
                key.add(String.valueOf(c).toLowerCase());
            }

            int sum = 0;
            if (key.size() <= n) {
                if (key.contains("shift")) {
                    sum += Pattern.compile("[A-Z]").matcher(str).results().count();
                }
                sum += str.length();
            }
            setList.add(new Key(key, sum));
        }
        Collections.sort(setList, (a, b) -> Integer.compare(b.key.size(), a.key.size()));

        for (Key key : setList) {
            System.out.println(key.key);
        }

        int[] visit = new int[setList.size()];
        int[] answer = new int[setList.size()];
        for (int i = 0; i < setList.size(); i++) {
            if (visit[i] == 1) {
                continue;
            }

            visit[i] = 1;
            answer[i] = setList.get(i).score;
            for (int j = i + 1; j < setList.size(); j++) {
                if (visit[j] == 1) {
                    continue;
                }

                if (setList.get(i).key.containsAll(setList.get(j).key)) {
                    visit[j] = 1;
                    answer[i] += setList.get(j).score;
                }
            }
        }

        Arrays.sort(answer);
        return answer[answer.length - 1];
    }
}