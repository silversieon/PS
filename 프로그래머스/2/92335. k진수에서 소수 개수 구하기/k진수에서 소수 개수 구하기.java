class Solution {
    public int solution(int n, int k) {
        // 수 n을 k진수로 변환해서 문자열 형태로 저장 (while문)
        // 해당 문자열을 0이 아닌 구간까지 이어 붙이며, 0을 만나면 소수인지 판별
        // 소수면 answer++, answer 반환
        String converted = Integer.toString(n, k);
        
        int answer = 0;
        for(String token : converted.split("0")) {
            if(token.isEmpty()) continue;
            if(isPrime(Long.parseLong(token))) answer++;
        }
        return answer;
    }
    private boolean isPrime(long num) {
        if(num < 2) return false;
        for(long i=2; i*i<=num; i++) {
            if(num%i==0) return false;
        }
        return true;
    }
}
// 25분까지