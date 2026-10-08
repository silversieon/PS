import java.util.*;
class Solution {
    public static int answer = 0;
    public static Set<Integer> numList = new HashSet<>();
    public static boolean isPrime(int n) {
        if (n < 2) return false;

        for (int i=2; i*i<=n; i++) {
            if(n%i==0) return false;
        }
        return true;
    }
    
    public static void dfs(String num, String[] nums, boolean[] visited) {
        if (!numList.contains(Integer.parseInt(num)) && isPrime(Integer.parseInt(num))) {
            answer++;
            numList.add(Integer.parseInt(num));
        }
        for(int i=0; i<visited.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(num+nums[i], nums, visited);
                visited[i] = false;
            }
        }
    }

    public int solution(String numbers) {
        String[] nums = new String[numbers.length()];
        for(int i=0; i<numbers.length(); i++){
            nums[i] = numbers.substring(i, i+1);
        }

        boolean[] visited = new boolean[numbers.length()];
        for(int i=0; i<numbers.length(); i++){
            if(nums[i].equals("0")) continue;
            visited[i] = true;
            dfs(nums[i], nums, visited);
            visited[i] = false;
        }
        
        return answer;
    }
}