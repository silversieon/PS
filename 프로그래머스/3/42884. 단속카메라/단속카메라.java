import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        Arrays.sort(routes, Comparator.comparingInt((int[] a) -> a[0]).thenComparingInt(a -> a[1]));
        int start = routes[0][0];
        int end = routes[0][1];
        answer++;
        for(int i=1; i<routes.length; i++){
            start = routes[i][0];
            if(routes[i][0] > end){
                answer++;
                end = routes[i][1];
            } else if(routes[i][1] < end){
                end = routes[i][1];
            }
        }
        return answer;
    }
}