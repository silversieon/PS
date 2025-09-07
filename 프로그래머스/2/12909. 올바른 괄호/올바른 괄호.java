class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int openStack = 0;
        for(int i=0; i<s.length(); i++){
            String bracket = s.substring(i, i+1);
            if(bracket.equals("(")){
                openStack++;
            } else {
                openStack--;
            }
            if(openStack<0){
                answer = false;
                break;
            }
        }
        if(openStack != 0){
            answer = false;
        }
        return answer;
    }
}