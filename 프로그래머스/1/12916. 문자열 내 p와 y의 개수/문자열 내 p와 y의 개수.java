class Solution {
    boolean solution(String s) {
        int count = 0;
        for(int i=0; i<s.length(); i++){
            if(s.substring(i, i+1).equals("p") || s.substring(i, i+1).equals("P")){
                count++;
            } else if (s.substring(i, i+1).equals("y") || s.substring(i, i+1).equals("Y")){
                count--;
            }
        }
        return count == 0 ? true : false;
    }
}