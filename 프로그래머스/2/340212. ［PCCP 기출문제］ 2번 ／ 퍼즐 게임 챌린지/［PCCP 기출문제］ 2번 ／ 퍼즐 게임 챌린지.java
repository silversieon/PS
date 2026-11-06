class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        // 숙련도 최대값부터 내려가며 퍼즐을 풀기 시작, limit 내로 끝내면 해당 숙련도 값 고정 후 반환
        // 퍼즐을 풀 때는 총 소요시간인 long totalTime = 0을 두고, 한 퍼즐을 풀 때마다 발생하는 소요 시간을 계산해 더하기. 중간에 limit를 넘으면 다음 숙련도부터
        int lo = 1, hi = 0;
        for (int diff : diffs) hi = Math.max(hi, diff);
        
        while(lo < hi) {
            int mid = (lo+hi)/2;
            if(canSolve(mid, diffs, times, limit)) hi = mid;
            else lo = mid+1;
        }
        return lo;
    }
    private boolean canSolve(int level, int[] diffs, int[] times, long limit) {
        long totalTime = 0;
        for(int i=0; i<diffs.length; i++) {
            if (level >= diffs[i]) totalTime += times[i];
            else totalTime += (times[i] + times[i-1] ) * (diffs[i] - level) + times[i];
            if(totalTime > limit) return false;
        }
        return true;
    }
}

// 5분까지