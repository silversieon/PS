class Solution {
    public int[] solution(int brown, int yellow) {
        int total = brown + yellow;
        for(int height = 3; height <= total; height++){
            if(total % height == 0){
                int width = total / height;
                if((width - 2) * (height - 2) == yellow) {
                    return new int[]{Math.max(width, height), Math.min(width, height)};
                }
            }
        }
        return new int[]{};
    }
}