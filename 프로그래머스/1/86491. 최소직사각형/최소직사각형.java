class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int firstLength = 0;
        int secondLength = 0;
        for(int i=0; i<sizes.length; i++) {
            if(sizes[i][0] >= sizes[i][1]) {
                firstLength = Math.max(firstLength, sizes[i][0]);
                secondLength = Math.max(secondLength, sizes[i][1]);
            } else {
                firstLength = Math.max(firstLength, sizes[i][1]);
                secondLength = Math.max(secondLength, sizes[i][0]);
            }
        }
        
        return firstLength * secondLength;
    }
}