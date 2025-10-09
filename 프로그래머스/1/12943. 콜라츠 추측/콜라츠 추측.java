class Solution {
    public int solution(int num) {
        int answer = 0;
        long n = num;
        if(n==1) return 0;
        while(answer<=500){
            if(n==1) break;
            if(n%2==0){
              n /=2;  
            } else {
              n = n * 3 + 1;   
            }
            answer++;
        }
        return n == 1 ? answer : -1;
    }
}