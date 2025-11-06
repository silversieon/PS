class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)(right-left) + 1];
        int idx = 0;
        for(long i=left; i<=right; i++){
            int quot = (int)Math.floor(i/n);
            int remain = (int)(i%n);
            if(remain>=quot){
                answer[idx] = remain + 1;
            } else {
                answer[idx] = quot + 1;
            }
            idx++;
        }
        return answer;
    }
}
