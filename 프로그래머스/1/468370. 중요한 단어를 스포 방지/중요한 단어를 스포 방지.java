import java.util.*;

class Solution {
    public int solution(String message, int[][] spoiler_ranges) {
        Set<String> normal = new HashSet<>();
        Set<String> spoiler = new HashSet<>();
        int n = message.length();
        int r = 0;
        int i = 0;
        
        while(i < n) {
            int start = i;
            while(i<n && message.charAt(i) != ' ') i++;
            int end = i-1;
            String word = message.substring(start, i);
            
            while(r<spoiler_ranges.length && spoiler_ranges[r][1] < start) r++;
            
            boolean hidden = r < spoiler_ranges.length && spoiler_ranges[r][0] <= end;
            
            if(hidden) spoiler.add(word);
            else normal.add(word);
            
            i++;
        }
        
        spoiler.removeAll(normal);
        return spoiler.size();
    }
}