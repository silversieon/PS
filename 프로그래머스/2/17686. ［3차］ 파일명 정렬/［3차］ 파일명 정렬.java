import java.util.*;
class Solution {
    public String[] solution(String[] files) {
        // files를 순회하며 HEAD, NUMBER, TAIL 구간으로 나눔
        // HEAD는 숫자 만나기 전까지 값, NUMBER는 이후 문자열이 나오기까지 값, TAIL은 이후 문자열 값(빈 문자열도 가능)
        // Arrays.sort로 String 2차원 배열을 기준에 맞게 정렬
        // HEAD는 대소문자 구분 없음, NUMBER는 앞자리 0 제거 숫자 취급
        Arrays.sort(files, (a, b) -> {
            String[] pa = split(a);
            String[] pb = split(b);
            
            int headCmp = pa[0].toLowerCase().compareTo(pb[0].toLowerCase());
            if(headCmp != 0) return headCmp;
            
            return Integer.compare(Integer.parseInt(pa[1]), Integer.parseInt(pb[1]));
        });
        return files;
    }
    private String[] split(String file) {
        int i = 0;
        while(i<file.length() && !Character.isDigit(file.charAt(i))) i++;
        int j=i+1;
        while(j<file.length() && Character.isDigit(file.charAt(j))) j++;
        return new String[]{file.substring(0, i), file.substring(i, j)};
    }
}
// 15분까지