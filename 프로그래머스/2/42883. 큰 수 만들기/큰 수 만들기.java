class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        for(char c : number.toCharArray()) {
            while(k>0 && sb.length()>0 && sb.charAt(sb.length() - 1) < c) {
                sb.deleteCharAt(sb.length() - 1);
                k--;
            }
            sb.append(c);
        }
        return sb.substring(0, sb.length() - k);
    }
}