class Solution {
    public boolean solution(String s) {
        if(s.length() != 4 && s.length() !=6){
            return false;
        }
        String upper = s.toUpperCase();
        String lower = s.toLowerCase();
        if(!upper.equals(s) || !lower.equals(s)){
            return false;
        }
        return true;
    }
}