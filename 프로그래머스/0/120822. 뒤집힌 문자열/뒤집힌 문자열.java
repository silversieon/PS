import java.util.*;

class Solution {
    public String solution(String my_string) {
        String a = "";
        for(int i=my_string.length(); i>=1; i--){
            a +=my_string.substring(i-1, i);
        }
        return a;
    }
}