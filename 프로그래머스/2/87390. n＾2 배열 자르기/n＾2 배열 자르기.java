class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)(right-left) + 1];
        int[] arr = new int[n];
        int idx = 0;
        int cnt = 0;
        boolean isClear = false;
        for(int i=0; i<n; i++){
            arr[i] = i+1;
        }
        for(long i=left; i<=right; i++){
            int quot = (int)Math.floor(i/n);
            int remain = (int)(i%n);
            if(remain>=quot){
                answer[idx] = arr[remain];
            } else {
                answer[idx] = quot + 1;
            }
            idx++;
        }
        return answer;
    }
}