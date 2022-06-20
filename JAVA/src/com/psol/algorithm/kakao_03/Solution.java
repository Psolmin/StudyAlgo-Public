package com.psol.algorithm.kakao_03;

import java.util.*;

public class Solution {
    public static int[] solution(int num_teams, String[] remote_tasks, String[] office_tasks, String[] employees) {
        Map<String, String> taskMap = new HashMap<>();
        for(String s : remote_tasks) {
            taskMap.put(s, "remote");
        }
        for(String s : office_tasks) {
            taskMap.put(s, "office");
        }

        ArrayList<Integer> employeeList = new ArrayList<>();
        Map<Integer, ArrayList<Integer>> office = new HashMap<>();
        Map<Integer, ArrayList<Integer>> team = new HashMap<>();
        for(int i = 0; i < employees.length; i++) {
            employeeList.add(i + 1);
            String[] str = employees[i].split(" ");

            int teamNum = Integer.parseInt(str[0]);
            if (team.containsKey(teamNum)) {
                team.get(teamNum).add(i + 1);
            } else {
                ArrayList<Integer> arr = new ArrayList<>();
                arr.add(i + 1);
                team.put(teamNum, arr);
            }
            for (int j = 1; j < str.length; j++) {
                if ("office".equals(taskMap.get(str[j]))) {
                    if (office.containsKey(teamNum)) {
                        office.get(teamNum).add(i + 1);
                    } else {
                        ArrayList<Integer> arr = new ArrayList<>();
                        arr.add(i + 1);
                        office.put(teamNum, arr);
                    }
                }
            }
        }

        for (int i = 1; i < num_teams + 1; i++) {
            if(office.containsKey(i)) {
                employeeList.removeAll(office.get(i));
            } else {
                employeeList.remove(team.get(2).get(0));
            }
        }

        int[] answer = new int[employeeList.size()];
        for (int i = 0; i < employeeList.size(); i++) {
            answer[i] = employeeList.get(i);
        }
        return answer;
    }
}