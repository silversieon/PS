import java.util.*;
class Solution {
    public long solution(long n) {
        String[] arr = Long.toString(n).split("");
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        for(String s:arr) sb.append(s);
        return Long.parseLong(sb.reverse().toString());
    }
}