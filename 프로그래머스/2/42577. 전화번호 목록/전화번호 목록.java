import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        Set<String> numSet = new HashSet<>();
        Arrays.stream(phone_book).forEach(numSet::add);
        for(String phone_num: phone_book){
            for(int i=1; i<phone_num.length(); i++){
                if(numSet.contains(phone_num.substring(0, i))) return false;
            }
        }
        return true;
    }
}