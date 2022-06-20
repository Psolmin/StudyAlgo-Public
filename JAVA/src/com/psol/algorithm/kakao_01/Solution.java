package com.psol.algorithm.kakao_01;
//
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import java.util.Stack;
//
//public class Solution {
//    class Node {
//        public String date;
//        public int rate;
//        public int money;
//
//        public Node(String date, int rate, int money){
//            this.date = date;
//            this.rate = rate;
//            this.money = money;
//        }
//    }
//
//    public int solution(String[] ledgers) throws ParseException {
//        int answer = 0;
//
//        Stack<Node> stack = new Stack<>();
//
//        for (String str : ledgers) {
//            String[] arr = str.split(" ");
//
//            String date = "2022/" + arr[0];
//            int rate = Integer.parseInt(arr[1]);
//            int money = Integer.parseInt(arr[2]);
//
//            if (money > 0) {
//                stack.push(new Node(date, rate, money));
//            } else {
//                withdraw(stack, date, money, answer);
//            }
//        }
//        return answer;
//    }
//    private void withdraw(Stack<Node> stack, String date, int money, int answer) throws ParseException {
//        Node n = stack.pop();
//        Date d = new SimpleDateFormat("yyyy/MM/dd").parse(n.date);
//        Date cur = new SimpleDateFormat("yyyy/MM/dd").parse(date);
//
//        long day = ((d.getTime() - cur.getTime()) / 1000) / (24*60*60);
//
//        if (money < n.money) {
//            answer += (money * n.rate) * (day / 365);
//            System.out.println(answer);
//            stack.push(new Node(n.date, n.rate, n.money-money));
//        } else {
//            answer += (n.money * n.rate) * (day / 365);
//            withdraw(stack, date, money - n.money, answer);
//        }
//    }
//}

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class Solution {
    public static int solution(String[] logs) {
        int answer = 0;

        for (String str : logs) {
            if (str.length() > 100) {
                System.out.println("@@@" + str);
                answer++;
                continue;
            }
            String[] log = str.split(" ");
            if (log.length != 12) {
                System.out.println("@@@" + str);
                answer++;
                continue;
            }

            Map<String, String> map = new HashMap<>();
            boolean flag = true;
            for (int i = 0; i < log.length; i++) {
                if (i % 3 == 0) {
                    switch (log[i]) {
                        case "team_name":
                        case "application_name":
                        case "error_level":
                        case "message":
                            break;
                        default:
                            flag = false;
                            break;
                    }
                    if (flag == false || map.containsKey(log[i])) {
                        flag = false;
                        break;
                    }
                    if (!Pattern.matches("[a-zA-Z]*", log[i+2])) {
                        flag = false;
                        break;
                    }

                    map.put(log[i], log[i+2]);
                }
            }

            if (flag == false) {
                System.out.println("@@@" + str);
                answer++;
            } else {
                System.out.println(str);
            }
        }


        return answer;
    }
}

