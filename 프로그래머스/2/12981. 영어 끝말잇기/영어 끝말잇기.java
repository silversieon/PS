import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[]{0, 0};
        HashSet<String> hs = new HashSet<>();
        int num = 1;
        int turn = 1;
        String lastWord = "";
        for(String word : words){
            if(hs.contains(word) || 
               (!lastWord.equals("") && !word.substring(0, 1).equals(lastWord))){
                answer[0] = num;
                answer[1] = turn;
                return answer;
            }
            hs.add(word);
            lastWord = word.substring(word.length()-1, word.length());
            num++;
            if(num>n){
                num = 1;
                turn++;
            }
        }
        return answer;
    }
}