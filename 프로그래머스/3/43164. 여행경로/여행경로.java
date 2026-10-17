import java.util.*;
class Solution {
    String[][] tickets;
    boolean[] used;
    List<String> route = new ArrayList<>();
    String[] answer;
    
    public String[] solution(String[][] tickets) {
        this.tickets = tickets;
        used = new boolean[tickets.length];
        
        Arrays.sort(tickets, (a, b) -> a[1].compareTo(b[1]));
        
        route.add("ICN");
        dfs("ICN", 0);
        return answer;
    }
    private boolean dfs(String cur, int cnt) {
        if(cnt == tickets.length) {
            answer = new String[route.size()];
            for (int i=0; i<answer.length; i++) {
                answer[i] = route.get(i);
            }
            return true;
        }
        
        for(int i=0; i<tickets.length; i++) {
            if(!used[i] && tickets[i][0].equals(cur)) {
                used[i] = true;
                route.add(tickets[i][1]);
                
                if (dfs(tickets[i][1], cnt+1)) return true;
                
                route.remove(route.size() - 1);
                used[i] = false;
            }
        }
        return false;
    }
}