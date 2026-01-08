import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));
        int ans = 0;
        int last_camera = Integer.MIN_VALUE;
        for (int[] a : routes) {
            if (last_camera < a[0]) {
                ++ans;
                last_camera = a[1];
            }
        }
        return ans;
    }
}