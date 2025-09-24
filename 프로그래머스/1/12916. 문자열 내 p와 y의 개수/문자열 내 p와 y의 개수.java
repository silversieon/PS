class Solution {
    boolean solution(String s) {
        int count = 0;
        s = s.toLowerCase();
        for(int i=0; i<s.length(); i++){
            if(s.substring(i, i+1).equals("p")){
                count++;
            } else if (s.substring(i, i+1).equals("y")){
                count--;
            }
        }
        return count == 0 ? true : false;
    }
}