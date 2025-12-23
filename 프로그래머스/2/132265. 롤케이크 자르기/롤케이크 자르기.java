import java.util.*;
class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        Set<Integer> a = new HashSet<>();
        Map<Integer, Integer> b = new HashMap<>();
        for(int i=0; i<topping.length; i++) b.put(topping[i], b.getOrDefault(topping[i], 0) + 1);
        for(int i=0; i<topping.length-1; i++){
            if(b.get(topping[i]) != 0) b.put(topping[i], b.get(topping[i]) - 1);
            if(b.get(topping[i]) == 0) b.remove(topping[i]);
            a.add(topping[i]);
            answer += a.size() == b.keySet().size() ? 1 : 0;
        }
        return answer;
    }
}