package com.psol.algorithm;

import com.psol.algorithm.hash_03.Solution;

public class Main {

    public static void main(String[] args) {
        /**
         *  hash_01
         */
//        String[] participant = {"mislav", "stanko", "mislav", "ana"};
//        String[] completion = {"stanko", "ana", "mislav"};
//        System.out.println(Solution.solution(participant, completion));

        /**
         *  hash_02
         */
//        String[] phone_book = {"123","456","789"};
//        System.out.println(Solution.solution(phone_book));

        /**
         *  hash_03
         */
        String[][] clothes = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
        System.out.println(Solution.solution(clothes));
    }
}
