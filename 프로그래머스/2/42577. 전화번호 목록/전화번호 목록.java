import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        // 1. 전화번호가 짧은 순대로 정렬한다.
        // 2. 가장 짧은 전화번호부터 해당 전화번호의 길이만큼 다른 번호들의 substring을 비교한다.
        // 3. 만약 같은 것이 있다면 true, 없다면 넘기고 최종 false
        Set<String> numSet = new HashSet<>();
        Arrays.stream(phone_book).forEach(numSet::add);
        for(String phone_num : phone_book){
            for(int i=1; i<phone_num.length(); i++){
                if(numSet.contains(phone_num.substring(0, i))) return false;
            }
        }
        return true;
    }
}