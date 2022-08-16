package com.psol.algorithm.오픈채팅방;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    private Map<String, String> user = new HashMap<>();
    private class Chat {
        String command;
        String userId;

        public Chat(String command, String userId) {
            this.command = command;
            this.userId = userId;
        }

        @Override
        public String toString() {
            switch (command) {
                case "Enter":
                    return user.get(userId) + "님이 들어왔습니다.";
                case "Leave":
                    return user.get(userId) + "님이 나갔습니다.";
                default:
                    return null;
            }
        }
    }
    public String[] solution(String[] record) {
//        String[] answer = {};
        List<String> answer = new ArrayList<>();

        List<Chat> chatList = new ArrayList<>();

        for (String str : record) {
            String[] command = str.split(" ");
            if (command.length == 3) {
                user.put(command[1], command[2]);
            }
            chatList.add(new Chat(command[0], command[1]));
        }

        for (Chat chat : chatList) {
            String str = chat.toString();
            if (str != null) {
                answer.add(chat.toString());
            }
        }

        return answer.toArray(new String[0]);
    }
}
