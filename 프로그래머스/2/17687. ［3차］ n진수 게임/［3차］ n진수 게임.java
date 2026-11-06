class Solution {
    public String solution(int n, int t, int m, int p) {
        // 현재 차례를 구하는 count 1부터 증가하며 m+1으로 나눈 나머지 값이 현재 순서이며, m을 넘어서면 m으로 나눈다.
        // 한 차례가 지날 때마다 숫자 값을 증가시켜 부르는데, 숫자값 길이만큼 반복해서 count 증가를 시도한다.
        // 튜브가 부를 문자열 answer이 t개가 되면 종료한다.
        StringBuilder answer = new StringBuilder();
        int turn = 1;
        for(int i=0; ; i++) {
            // 숫자를 n진법 변환
            String num = Integer.toString(i, n);
            
            for(int k=0; k<num.length(); k++) {
                if(turn==p) {
                    answer.append(num.substring(k, k+1));
                    if(answer.length() == t) break;
                }
                turn++;
                if(turn>m) turn/=m;
            }
            if(answer.length() == t) break;
        }
        return answer.toString().toUpperCase();
    }
}

// 41분까지