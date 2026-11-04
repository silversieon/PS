import java.util.*;
class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        // 1. data를 col-1 기준 오름차순, 동일 시 기본키(0번째 컬럼) 내림차순 정렬
        Arrays.sort(data, (a, b) -> {
            if (a[col-1] != b[col-1]) {
                return Integer.compare(a[col-1], b[col-1]);    
            }
            return Integer.compare(b[0], a[0]);
        });
        
        // 2. row_begin 행부터 row_end 행까지 S_i 구하고 누적 XOR 수행
        for(int r=row_begin-1; r<=row_end-1; r++) {
            int S_i = 0;
            for(int c=0; c<data[0].length; c++){
                S_i += data[r][c]%(r+1);
            }
            answer ^= S_i;
        }
        return answer;
    }
}