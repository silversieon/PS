import java.util.*;
class Solution {
    private boolean isPrime(long num){
        if(num<2) return false;
        for(int i=2; i<=Math.sqrt(num); i++){
            if(num%i==0) return false;
        }
        return true;
    }
    public int solution(int n, int k) {
        int answer = 0;
        String kNum = "";
        while(n>=1){
            kNum = String.valueOf(n%k) + kNum;
            n/=k;
        }
        String[] arr = kNum.split("0");
        for(String s : arr){
            if(s.equals("")) continue;
            long num = Long.parseLong(s);
            if(isPrime(num)) answer++;
        }
        return answer;
    }
}