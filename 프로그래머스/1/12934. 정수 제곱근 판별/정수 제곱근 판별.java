class Solution {
    public long solution(long n) {
        for(long i=1; ; i++){
            if(i*i>n){
                break;
            }
            if(i*i==n){
                return (i+1) * (i+1);
            }
        }
        return -1;
    }
}