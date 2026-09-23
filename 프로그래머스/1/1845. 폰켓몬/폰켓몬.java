import java.util.*;

class Solution {
    public int solution(int[] nums) {
        // 1. nums 배열에 담긴 수를 HashSet에 put
        // 2. HashSet의 크기 size와 N/2를 비교, N/2 > size라면 size가 최대값, 그렇지 않다면 N/2가 최대값
        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            set.add(num);
        }
        if(set.size() > nums.length/2) {
            return nums.length/2;
        } else {
            return set.size();
        }
    }
}