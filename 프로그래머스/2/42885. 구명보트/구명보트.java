import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        // 1. 몸무게 순 정렬
        Arrays.sort(people);
        
        int answer = 0;
        int left = 0;
        int right = people.length-1;
        while(left <= right) {
            int weight = people[right--];
            if (limit - weight >= people[left]) left++;
            answer++;
        }
        return answer;
    }
}