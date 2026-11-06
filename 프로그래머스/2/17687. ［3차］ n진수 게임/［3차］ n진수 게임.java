class Solution {
    public String solution(int n, int t, int m, int p) {
        // t*m개의 번호를 구할 때까지 0부터 n진수로 문자열 계산
        StringBuilder all = new StringBuilder();
        for(int i=0; all.length()<=t*m; i++) {
            all.append(Integer.toString(i, n));
        }
        // 그 중 튜브의 순서인 것만 꺼내서 answer에 담기
        StringBuilder answer = new StringBuilder();
        for(int i=0; i<t; i++) {
            answer.append(all.charAt((p-1) + i*m));
        }
        return answer.toString().toUpperCase();
    }
}

// 41분까지