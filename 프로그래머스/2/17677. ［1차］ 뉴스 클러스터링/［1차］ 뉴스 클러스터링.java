import java.util.*;
class Solution {
    private List<String> stringSplit(String str){
        List<String> list = new ArrayList<>();
        str = str.toUpperCase();
        for(int i=0; i<str.length() -1; i++){
            String substring = str.substring(i, i+2);
            if(substring.matches("[a-zA-Z]+")) list.add(substring);
        }
        return list;
    }
    public int solution(String str1, String str2) {
        List<String> list1 = stringSplit(str1);
        List<String> list2 = stringSplit(str2);
        if(list1.isEmpty() && list2.isEmpty()) return 65536;
        
        double interCount = 0;
        for(String s1 : list1){
            if(list2.remove(s1)) interCount++;
        }
        double unionCount = list1.size() + list2.size();
        return (int)(interCount/unionCount*65536);
    }
}