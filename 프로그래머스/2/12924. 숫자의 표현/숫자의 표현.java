class Solution {
    static int count = 0;
    public int solution(int n) {
        for(int i=1; i*(i-1)/2<n; i++){
            if((n-(i*(i-1)/2))%i==0) count++;
        }
        return count;
    }
}