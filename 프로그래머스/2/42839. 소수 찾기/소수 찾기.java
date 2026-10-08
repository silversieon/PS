import java.util.*;
class Solution {
    private final Set<Integer> made = new HashSet<>();
    private static int count = 0;
    public int solution(String numbers) {
        boolean[] visited = new boolean[numbers.length()];
        dfs("", numbers.toCharArray(), visited);
        return count;
    }
    
    private void dfs(String cur, char[] digits, boolean[] visited) {
        if(!cur.isEmpty() && !made.contains(Integer.parseInt(cur)) && isPrime(Integer.parseInt(cur))) {
            count++;
            made.add(Integer.parseInt(cur));
        }
        for(int i=0; i<digits.length; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            dfs(cur+digits[i], digits, visited);
            visited[i] = false;
        }
    }
    
    private boolean isPrime(int n) {
        if (n < 2) return false;

        for (int i=2; i*i<=n; i++) {
            if(n%i==0) return false;
        }
        return true;
    }
}