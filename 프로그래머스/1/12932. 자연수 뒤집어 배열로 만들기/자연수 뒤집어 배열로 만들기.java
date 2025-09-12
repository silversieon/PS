class Solution {
    public int[] solution(long n) {
        String num = String.valueOf(n);
        int size = num.length();
        int[] answer = new int[size];
        for(int i=0; i<size; i++){
            answer[i] = Integer.parseInt(num.substring(size-i-1, size-i));
        }
        return answer;
    }
}