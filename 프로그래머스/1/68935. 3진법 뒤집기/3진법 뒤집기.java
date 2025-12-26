class Solution {
    public int solution(int n) {
        int answer = 0;
        String result = "";
        while(n>0){
            result += String.valueOf(n%3);
            n /= 3;
        }
        for(int i=0; i<result.length(); i++){
            answer += Integer.parseInt(result.substring(i, i+1)) * Math.pow(3, result.length() - (i + 1));
        }
        return answer;
    }
}