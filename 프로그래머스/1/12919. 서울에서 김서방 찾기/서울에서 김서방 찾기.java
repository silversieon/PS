class Solution {
    public String solution(String[] seoul) {
        int idx = 0;
        for(String name : seoul){
            if(name.equals("Kim")) break;
            idx++;
        }
        return "김서방은 " + idx +"에 있다";
    }
}