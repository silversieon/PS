import java.util.*;
class Solution {
    private static char[] gathers = {'A', 'E', 'I', 'O', 'U'};
    public static int geometricSum(int a, int r, int n){
        if(r==1) return a * n;
        return a * ((int)Math.pow(r, n) - 1) / (r - 1);
    }
    public int solution(String word) {
        int answer = word.length();     
        Map<Character, Integer> dic = new HashMap<>();
        for(int i=0; i<gathers.length; i++){
            dic.put(gathers[i], i);
        }
        
        for(int i=0; i<word.length(); i++){
            char gather = word.charAt(i);
            int mulValue = dic.get(gather);
            answer += geometricSum(1, 5, 5 - i) * mulValue;
        }
        return answer;
    }
}