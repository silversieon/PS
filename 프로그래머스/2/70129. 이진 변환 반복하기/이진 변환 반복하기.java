class Solution {
    static int count = 0, totalZeroCount = 0;
    public int[] solution(String s) {
        int[] answer = new int[2];
        while(!s.equals("1")){
            int zeroCount = 0;
            for(int i=0; i<s.length(); i++){
                if(s.substring(i, i+1).equals("0")){
                    zeroCount++;
                }
            }
            int changedLength = s.length() - zeroCount;
            s = Integer.toBinaryString(changedLength);
            totalZeroCount+=zeroCount;
            count++;
        }
        answer[0] = count;
        answer[1] = totalZeroCount;
        return answer;
    }
}