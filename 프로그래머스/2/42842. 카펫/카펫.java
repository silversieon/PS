class Solution {
    public int[] solution(int brown, int yellow) {
        int size = brown + yellow;
        for(int height=3; height < size; height++) {
            if(size%height==0) {
                int width = size/height;
                if ( (width - 2) * (height - 2) == yellow) {
                    return new int[]{Math.max(width, height), Math.min(width, height)};
                }
            }
        }
        return new int[]{};
    }
}