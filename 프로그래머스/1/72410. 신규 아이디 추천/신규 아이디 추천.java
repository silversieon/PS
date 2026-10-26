class Solution {
    public String solution(String new_id) {
        // 1
        new_id = new_id.toLowerCase();
        
        // 2
        StringBuilder sb = new StringBuilder();
        int k=0;
        for(int i=0; i<new_id.length(); i++) {
            char c = new_id.charAt(i);
            if(Character.isAlphabetic(c) || Character.isDigit(c) || c=='-' || c=='_' || c=='.') {
                sb.append(c);
            }
        }
        String s3 = sb.toString();
        sb.setLength(0);
        for(int i=0; i<s3.length(); i++) {
            char c = s3.charAt(i);
            sb.append(c);
            if (c=='.') {
                    while(i<s3.length()-1 && s3.charAt(i+1) == '.') i++;
                }
        }
        String s4 = sb.toString();
        if (s4.charAt(0) == '.') s4 = s4.substring(1, s4.length());
        if (s4.length() != 0 && s4.charAt(s4.length()-1) == '.') s4 = s4.substring(0, s4.length() -1);
        
        String s5 = s4;
        if(s5.isEmpty()) s5 = "a";
        String s6 = s5;
        if(s6.length() >= 16 ) s6 = s6.substring(0, 15);
        if (s6.charAt(s6.length()-1) == '.') s6 = s6.substring(0, s6.length() -1);
        String s7 = s6;
        if (s7.length() <= 2) {
            while(s7.length() <= 2) {
                s7 += s7.charAt(s7.length() -1);
            }
        }
        return s7;
    }
}

// 3자 이상 15자 이하, 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.) 문자만 사용
// 마침표(.)는 처음과 끝에 사용할 수 없으며 또한 연속으로 사용할 수 없습니다.