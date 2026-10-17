class Solution {
    private int answer = 0;
    public int solution(int[] numbers, int target) {
        // 1. 전역 변수로 answer=0을 만든다.
        // 2. 숫자 배열, 목표 숫자, 현재까지 도달한 인덱스의 값, 현재까지 합을 인자로 하는 dfs 함수 생성
        // 3. dfs 함수는 숫자 배열을 순회하는데 더하거나 빼면서 진행
        // 4. 만약 배열의 끝에 도달했을 때 목표 숫자와 일치하면 answer++;
        dfs(numbers, target, 0, 0);
        return answer;
    }
    private void dfs(int[] numbers, int target, int idx, int sum) {
        if(idx== numbers.length) {
            if (sum==target) answer++;
            return;
        }
        dfs(numbers, target, idx+1, sum+numbers[idx]);
        dfs(numbers, target, idx+1, sum-numbers[idx]);
    }
}