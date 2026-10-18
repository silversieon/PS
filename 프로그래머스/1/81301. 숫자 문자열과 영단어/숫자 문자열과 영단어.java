import java.util.*;

class Solution {
    public int solution(String s) {
        String answer = "";
        Map<String, Integer> dic = new HashMap<>();
        dic.put("zero", 0); dic.put("one", 1); dic.put("two", 2); dic.put("three", 3); dic.put("four", 4);
        dic.put("five", 5); dic.put("six", 6); dic.put("seven", 7); dic.put("eight", 8); dic.put("nine", 9);

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) < 65) {
                answer += s.charAt(i);
            } else {
                sb.append(s.charAt(i));
                Integer num = dic.getOrDefault(sb.toString(), -1);
                if (num >= 0) {
                    answer += String.valueOf(num);
                    sb = new StringBuilder();
                }
            }
        }
        return Integer.parseInt(answer);
    }
}