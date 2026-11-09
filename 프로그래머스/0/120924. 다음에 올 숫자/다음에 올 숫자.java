class Solution {
    public int solution(int[] common) {
        int n = common.length;
        return common[2]-common[1] == common[1]-common[0] ? common[n-1]+common[1]-common[0] : common[n-1]*(common[1]/common[0]);
    }
}