class Solution {
    public int[] solution(int[] sequence, int k) {
        // 2중 for문을 통해 sequence의 부분 수열의 합 구하기 (시간 초과)
        // l, r을 0부터 시작해서 r을 증가하는데, k를 넘어서면 l++
        int[] answer = new int[]{0, 1000000};
        int n = sequence.length;
        int length = 1000000;
        
        int temp = 0;
        int l = 0;
        int r = 0;
        while(l<n && r<n) {
            while(r<n && l<=r && temp+sequence[r] <= k) {
                temp+=sequence[r];
                if(temp == k && r-l<answer[1]-answer[0]) {
                    answer[0] = l;
                    answer[1] = r;
                }
                r++;
            }
            temp-=sequence[l++];
        }
        return answer;
    }
}