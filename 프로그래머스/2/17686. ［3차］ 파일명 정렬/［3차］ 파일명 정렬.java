import java.util.*;
class Solution {
    public String[] solution(String[] files) {
        // files를 순회하며 HEAD, NUMBER, TAIL 구간으로 나눔
        // HEAD는 숫자 만나기 전까지 값, NUMBER는 이후 문자열이 나오기까지 값, TAIL은 이후 문자열 값(빈 문자열도 가능)
        // Arrays.sort로 String 2차원 배열을 기준에 맞게 정렬
        // HEAD는 대소문자 구분 없음, NUMBER는 앞자리 0 제거 숫자 취급
        String[][] sortedFiles = new String[files.length][3];
        for(int i=0; i<files.length; i++) {
            String[] splited = split(files[i]);
            sortedFiles[i] = splited;
        }
        Arrays.sort(sortedFiles, (a, b) -> {
            String la = a[0].toLowerCase();
            String lb = b[0].toLowerCase();
            if (la.equals(lb)) {
                return Integer.compare(Integer.parseInt(a[1]), Integer.parseInt(b[1]));
            }
            return la.compareTo(lb);
        });
        String[] answer = new String[files.length];
        for(int i=0; i<files.length; i++) {
            answer[i] = sortedFiles[i][0]+sortedFiles[i][1]+sortedFiles[i][2];
        }
        return answer;
    }
    private String[] split(String file) {
        int i = 0;
        String[] s = new String[3];
            int j = i+1;
            while(j<file.length() && !Character.isDigit(file.charAt(j))) j++;
            s[0] = file.substring(i, j);
            int k = j+1;
            while(k<file.length() && Character.isDigit(file.charAt(k))) k++;
            s[1] = file.substring(j, k);
            s[2] = file.substring(k, file.length());
        return s;
    }
}
// 15분까지