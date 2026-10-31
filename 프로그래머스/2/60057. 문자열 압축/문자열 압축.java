class Solution {
    public int solution(String s) {
        int answer = s.length();
        // 문자열을 1개부터 s의 길이 절반만큼 압축한다. (2중 for문)
        // StringBuilder에 담으면서, 이전 문자열과 같으면 맨 앞에 숫자를 증가시킨다 (시작은 2)
        // 문자열 길이를 담을 변수를 하나 놓고, 비교하며 더 짧은 것을 저장
        for(int k=1; k<=s.length()/2; k++) {
            StringBuilder sb = new StringBuilder();
            String prev = s.substring(0, k);
            int count = 1;
            
            for(int i=k; i<s.length(); i+=k) {
                String cur = s.substring(i, Math.min(i+k, s.length()));
                
                if(cur.equals(prev)) {
                    count++;
                } else {
                    if (count > 1) sb.append(count);
                    sb.append(prev);
                    prev = cur;
                    count = 1;
                }
            }
            if (count > 1) sb.append(count);
            sb.append(prev);
            answer = Math.min(answer, sb.length());
        }
        return answer;
    }
}