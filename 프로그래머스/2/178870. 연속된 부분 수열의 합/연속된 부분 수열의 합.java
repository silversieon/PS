class Solution {
    public int[] solution(int[] sequence, int k) {
        // 좌측 인덱스 l, 우측 인덱스 r
        // l, r을 0부터 시작해서 r을 증가하는데, k를 넘어서면 l++
        // 만약 현재까지 합이 k와 같고, 길이가 기존 길이보다 짧다면 l, r 갱신
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