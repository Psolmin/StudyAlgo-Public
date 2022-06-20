package com.psol.algorithm;


import com.psol.algorithm.로또의_최고_순위와_최저_순위.Solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;


//import com.psol.algorithm.신고_결과_받기.Solution;
//import com.psol.algorithm.hash_01.Solution;
//import com.psol.algorithm.hash_02.Solution;
//import com.psol.algorithm.hash_03.Solution;
//import com.psol.algorithm.kakao_02.*;
//import com.psol.algorithm.kakao_05.Solution;

//import static com.psol.algorithm.kakao_05.Solution.solution;


public class Main {

//    public static class Node {
//        String name;
//        List<Node> children;
//        HashMap<String, Node> childrenMap;
//        public Node(String name) {
//            this.name = name;
//            this.children = new ArrayList<>();
//            this.childrenMap = new HashMap<>();
//        }
//
//        public Node getChild(String name) {
//            return this.childrenMap.get(name);
//        }
//        public void addChild(Node child) {
//            children.add(child);
//            childrenMap.put(child.name, child);
//        }
//
//        public void makeDir(String dir) {
//            if(dir.length() == 0) {
//                return;
//            }
//            String nodeName = getNodeName(dir);
//            String subPath = getSubPath(dir);
//
//            if(childrenMap.containsKey(nodeName)) {
//                childrenMap.get(nodeName).makeDir(subPath);
//                return;
//            }
//
//            Node child = new Node(nodeName);
//            addChild(child);
//            child.makeDir(subPath);
//        }
//
//        public String getNodeName(String dir) {
//            int idx = dir.indexOf("/");
//
//            if(idx == -1) {
//                return dir;
//            }
//
//            return dir.substring(0, idx);
//        }
//
//        public String getSubPath(String dir) {
//            int idx = dir.indexOf("/");
//
//            if(idx == -1) {
//                return "";
//            }
//
//            return dir.substring(idx).substring(1);
//        }
//
//        public Node findNode(String dir) {
//            Node node = this;
//            String nodeName = getNodeName(dir);
//
//            while(nodeName.length() > 0) {
//                node = node.getChild(nodeName);
//                dir = getSubPath(dir);
//                nodeName = getNodeName(dir);
//            }
//
//            return node;
//        }
//
//        public void removeDir(String dir) {
//            int index = dir.lastIndexOf("/");
//            String nodeName = dir.substring(index+1);
//            Node node;
//            if(index > 0) {
//                node = findNode(dir.substring(1, index));
//                System.out.println("###" + dir + ":" + index + ":" + node.name + ":" + nodeName);
//            }else{
//                node = this;
//            }
////            System.out.println("!@#nodeName!@!@@!" + nodeName);
//            node.removeChild(nodeName);
//        }
//
//        void removeChild(String name) {
//            Node child = this.getChild(name);
//
//            this.children.remove(child);
//            this.childrenMap.remove(name);
//        }
//        void getDirectories(List<String> dirs, String preDir) {
//            String fullDir;
//
//            if(name.equals("")) {
//                fullDir = "";
//                dirs.add("/");
//            }else {
//                fullDir = preDir + "/" + this.name;
//                dirs.add(fullDir);
//            }
//
//            Collections.sort(children, Comparator.comparing(o -> o.name));
//
//            for(Node child : children) {
//                child.getDirectories(dirs, fullDir);
//            }
//        }
//    }
//
//    public static String[] solution(String[] directory, String[] command) {
//        Node root = new Node("");
//
//        for (String dir : directory) {
//            root.makeDir(dir.substring(1));
//        }
//
//        for (int i = 0; i < command.length; i++) {
//            List<String> temp = new ArrayList<>();
//            root.getDirectories(temp, "");
//            temp.toArray(new String[temp.size()]);
//            for (String str : temp) {
//                System.out.println(str);
//            }
//            System.out.println("@@@@@@@@@@@@@");
//            String[] cmd = command[i].split(" ");
//
//            if(cmd[0].equals("mkdir")) {
//                root.makeDir(cmd[1].substring(1));
//                continue;
//            }
//
//            if(cmd[0].equals("rm")) {
//                root.removeDir(cmd[1]);
//                continue;
//            }
//
//            if(cmd[0].equals("cp")) {
//                List<String> aaa = new ArrayList<>();
//                root.getDirectories(aaa, cmd[1]);
//                aaa.toArray(new String[aaa.size()]);
//                System.out.println("########################" + cmd[1]);
//                for (String str : aaa) {
//                    System.out.println(str);
//                }
//                System.out.println("########################");
////                Node copyNode = root.findNode(cmd[2].substring(1));
////                Node dir = root.findNode(cmd[1].substring(1));
//                System.out.println(cmd[1].substring(1) + " : " + cmd[2].substring(1));
////                copyNode.addChild(dir);
//            }
//        }
//
//        List<String> answer = new ArrayList<>();
//        root.getDirectories(answer,"");
//
//        return answer.toArray(new String[answer.size()]);
//    }

    public static void main(String[] args) {

        /***
         * 로또의 최고 순위와 최저 순위
         */

        Solution solution = new Solution();
        int[] lottos = {44, 1, 0, 0, 31, 25};
        int[] win_nums = {31, 10, 45, 1, 6, 19};
        System.out.println(solution.solution(lottos, win_nums));

        /***
         * 신고 결과 받기
         */
/*
        Solution solution = new Solution();
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
        int k = 2;
        System.out.println(solution.solution(id_list, report, k));
*/
        /*
//        String[] directory = {
//                "/",
//                "/hello",
//                "/hello/tmp",
//                "/root",
//                "/root/abcd",
//                "/root/abcd/etc",
//                "/root/abcd/hello"
//        };
//        String[] command = {
//                "mkdir /root/tmp",
//                "cp /hello /root/tmp",
//                "rm /hello"
//        };
//        String[] directory = {
//                "/"
////                "/b",
////                "/b/c"
//        };
//        String[] command = {
//                "mkdir /a",
//                "mkdir /a/b",
//                "mkdir /a/b/c",
//                "cp /a/b /",
//                "rm /a/b/c"
//        };
//        for (String str : solution(directory, command)){
//            System.out.println(str);
//        }
//        System.out.println(solution(directory, command));
        */

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
//        String[][] clothes = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
//        System.out.println(Solution.solution(clothes));

        /**
         *  hash_04
         */
//        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
//        int[] plays = {500, 600, 150, 800, 2500};
//        System.out.println(Solution.solution(genres, plays));

        /**
         *  kakao_01, LINE_01
         */
//        String[] logs = {
////                "team_name : db application_name : dbtest error_level : info message : test", "team_name : test application_name : I DONT CARE error_level : error message : x", "team_name : ThisIsJustForTest application_name : TestAndTestAndTestAndTest error_level : test message : IAlwaysTestingAndIWillTestForever", "team_name : oberervability application_name : LogViewer error_level : error"
//                "team_name : MyTeam application_name : YourApp error_level : info messag : IndexOutOfRange", "no such file or directory", "team_name : recommend application_name : recommend error_level : info message : RecommendSucces11", "team_name : recommend application_name : recommend error_level : info message : Success!", "   team_name : db application_name : dbtest error_level : info message : test", "team_name     : db application_name : dbtest error_level : info message : test", "team_name : TeamTest application_name : TestApplication error_level : info message : ThereIsNoError"
//        };
//        System.out.println(Solution.solution(logs));
        /**
         *  kakao_02
         */
//        String[] sentences = {
////                "line in line", "LINE", "in lion"
//                "ABcD", "bdbc", "a", "Line neWs"
//        };
//        int n = 7;
//        System.out.println(Solution.solution(sentences, n));
        /**
         *  kakao_03
         */
//        int num_teams = 3;
//        String[] remote_tasks = {"development","marketing","hometask"};
//        String[] office_tasks = {"recruitment","education","officetask"};
//        String[] employees = {
//                "1 development hometask","1 recruitment marketing","2 hometask","2 development marketing hometask","3 marketing","3 officetask","3 development"
//        };
//        System.out.println(Solution.solution(num_teams, remote_tasks,office_tasks,employees));
        /**
         *  kakao_04
         */

        /**
         *  kakao_05
         */
//        String s = "[]([[]){}";
//        String s = "{([()]))}";

        /**
         * naver_01
         */
//        int[][] recruits = {{1, 50}, {1, 60},{3, 70},{
//            0, 65
//        },{
//            2, 50
//        },{1, 90}};
//        int[][] recruits = {{0, 2}, {0, 3}, {1, 0}, {1, 1}, {1, 2}, {2, 0}, {2, 1}, {2, 3}, {3, 2}};
//        int s1 = 2;
//        int s2 = 70;
//        System.out.println(solution.solution(recruits, s1, s2));
        /**
         * naver_02
         */
//        String[] cities = {"a", "b", "c", "d", "e", "f", "g"};
//        String[] roads = {"a b 1", "a c 1", "c d 3", "b d 5", "b e 6", "d e 2", "f g 8"};
//        String[] cars = {"a 100 10", "a 200 15", "b 100 5", "c 20 2", "c 300 30", "d 200 20", "e 500 100", "f 500 50", "g 100 40"};
//        String[] customers = {"g f 200", "c e 50", "d a 500", "a b 50"};
//        System.out.println(solution.solution(cities, roads, cars, customers));

        /**
         * ssg_01
         */

//        System.out.println(solution.solution());

        /**
         * ssg_02
         */

//        System.out.println(solution.solution());

        /**
         * ssg_03
         */

//        System.out.println(solution.solution());

        /**
         * ssg_04
         */

//        System.out.println(solution.solution());
    }
}
