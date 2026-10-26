class Solution {
    public String solution(String new_id) {
        String id = new_id.toLowerCase();
        
        StringBuilder sb = new StringBuilder();
        for(char c : id.toCharArray()) {
            boolean allowed = Character.isAlphabetic(c) || Character.isDigit(c) || c == '-' || c == '_' || c == '.';
            
            if (!allowed) continue;
            if (c == '.' && sb.length() > 0 && sb.charAt(sb.length() -1) == '.') continue;
            sb.append(c);
        }
        
        if(sb.length() > 0 && sb.charAt(0) == '.') sb.deleteCharAt(0);
        if(sb.length() > 0 && sb.charAt(sb.length() - 1) == '.') sb.deleteCharAt(sb.length() - 1);
        
        if(sb.length() == 0) sb.append('a');
        
        if(sb.length() >= 16) {
            sb.setLength(15);
            if (sb.charAt(14) == '.') sb.deleteCharAt(14);
        }
        
        while(sb.length() <= 2) sb.append(sb.charAt(sb.length()-1));
        
        return sb.toString();
    }
}

// 3자 이상 15자 이하, 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.) 문자만 사용
// 마침표(.)는 처음과 끝에 사용할 수 없으며 또한 연속으로 사용할 수 없습니다.