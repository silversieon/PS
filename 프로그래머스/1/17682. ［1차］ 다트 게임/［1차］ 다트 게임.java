class Solution {
    public int solution(String dartResult) {
        int[] scores = new int[3];
        int idx = -1;
        int i=0;
        int n = dartResult.length();
        
        while(i<n) {
            // 1. 점수 파싱
            int num = 0;
            while(i < dartResult.length() && Character.isDigit(dartResult.charAt(i))) {
                num = num * 10 + (dartResult.charAt(i) - '0');
                i++;
            }
            idx++;
            
            // 2. 보너스 계산
            char bonus = dartResult.charAt(i++);
            int exp = switch(bonus) {
                    case 'S' -> 1;
                    case 'D' -> 2;
                    case 'T' -> 3;
                    default -> throw new IllegalArgumentException();
            };
            scores[idx] = (int)Math.pow(num, exp);
            
            // 3. 옵션
            if (i<n) {
                char opt = dartResult.charAt(i);
                if(opt == '*') {
                    scores[idx] *=2;
                    if(idx > 0) scores[idx-1] *=2;
                    i++;
                } else if (opt == '#') {
                    scores[idx] *= -1;
                    i++;
                }
            }
        }
        return scores[0] + scores[1] + scores[2];
    }
}