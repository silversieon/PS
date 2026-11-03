class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int minLength = Integer.MAX_VALUE;
        int sum = 0;
        int left = 0;
        
        for(int right=0; right<sequence.length; right++) {
            sum +=sequence[right];
            
            while (sum > k) {
                sum -= sequence[left++];
            }
            
            if (sum==k && right-left < minLength) {
                answer[0] = left;
                answer[1] = right;
                minLength = Math.min(minLength, answer[1] - answer[0]);
            }
        }
        return answer;
    }
}