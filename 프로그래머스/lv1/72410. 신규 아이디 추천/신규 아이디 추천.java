class Solution {
    public String solution(String new_id) {
        // 1단계
        new_id = new_id.toLowerCase();
        // 2단계

        StringBuffer sb = new StringBuffer();
        for (char c : new_id.toCharArray()) {
            if (Character.isLetterOrDigit(c) || c == '-' || c == '_' || c == '.') {
                sb.append(c);
            }
        }

        new_id = sb.toString();

        // 3단계
        sb.setLength(0);
        boolean flag = true;
        for (char c : new_id.toCharArray()) {
            if (c == '.' && flag) {
                flag = false;
                sb.append(c);
            } else if (c == '.' && !flag) {
                continue;
            } else {
                sb.append(c);
                flag = true;
            }
        }
//        new_id = sb.toString().replaceAll(".&", "").replaceAll(".^", "");
        new_id = sb.toString();


        // 4단계
        if (new_id.length() >= 2) {
            boolean first = false;
            boolean last = false;
            if (new_id.charAt(0) == '.') {
                first = true;
            }
            if (new_id.charAt(new_id.length() - 1) == '.') {
                last = true;
            }

            if (first && last) {
                new_id = new_id.substring(1, new_id.length() - 1);
            } else if (first) {
                new_id = new_id.substring(1);
            } else if (last) {
                new_id = new_id.substring(0, new_id.length() - 1);
            }
        } else if (new_id.length() == 1) {
            if (new_id.charAt(0) == '.') {
                new_id = "";
            }
        }
//        if (sb.charAt(0) == '.') {
//            sb.deleteCharAt(0);
//        } else if (sb.lastIndexOf(".") == sb.length() - 1) {
//            sb.deleteCharAt(sb.length() - 1);
//        }
//        new_id = sb.toString();


        // 5단계
        if (new_id.length() == 0) {
            new_id = "a";
        }

        // 6단계
        if (new_id.length() >= 16) {
            if (new_id.charAt(14) == '.') {
                new_id = new_id.substring(0, 14);
            } else {
                new_id = new_id.substring(0, 15);
            }
        }

        // 7단계
        if (new_id.length() <= 2) {
            sb.setLength(0);

            sb.append(new_id);
            char ch = new_id.charAt(new_id.length() - 1);
            sb.append(ch).append(ch);
            new_id = sb.substring(0, 3);
        }

        return new_id;
    }
}