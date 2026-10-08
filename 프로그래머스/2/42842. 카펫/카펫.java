class Solution {
    public int[] solution(int brown, int yellow) {
        // 가로 * 세로 - 노란색 = brown
        // 노란색은 반드시 (가로-1) * (세로-1) 한 값
        // 총 크기는 brown + yellow
        int[] answer = new int[2];
        for(int i=3; i<2498; i++) {
            for(int j=3; j<2498; j++){
                if (i*j-yellow == brown && (i-2) * (j-2) == yellow && i*j==brown + yellow && i>=j) {
                    answer[0] = i;
                    answer[1] = j;
                    return answer;
                }
            }
        }
        return answer;
    }
}