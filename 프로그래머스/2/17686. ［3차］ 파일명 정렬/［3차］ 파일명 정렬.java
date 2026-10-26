import java.util.*;
class Solution {
    public String[] solution(String[] files) {
        // 1. HEAD 기준 정렬
        // 숫자가 나오기 전까지의 문자를 기준으로 최초 정렬
        // 2. NUMBER 기준 정렬
        // 0이 나온 부분은 제거하고 숫자만 비교해 정렬
        Arrays.sort(files, (a, b) -> {
           String[] pa = split(a);
            String[] pb = split(b);
            
            int headCmp = pa[0].toLowerCase().compareTo(pb[0].toLowerCase());
            if(headCmp != 0) return headCmp;
            
            int numberCmp = Integer.parseInt(pa[1]) - Integer.parseInt(pb[1]);
            return numberCmp;
        });
        return files;
    }
    
    private String[] split(String s) {
        int i = 0;
        
        while(i < s.length() && !Character.isDigit(s.charAt(i))) i++;
        
        int j = i;
        while(j < s.length() && Character.isDigit(s.charAt(j))) j++;
        return new String[]{s.substring(0, i), s.substring(i, j)};
    }
}