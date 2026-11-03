import java.util.*;
class Solution {
    public String[] solution(String[] players, String[] callings) {
        // 각 선수의 현재 인덱스를 담는 HashMap
        // callings 순회, 이름 불린 선수의 index와 index-1 선수의 위치를 players에서 스위치, HashMap도 갱신
        // players 반환
        Map<String, Integer> idx = new HashMap<>();
        for(int i=0; i<players.length; i++) idx.put(players[i], i);
        
        for (String call : callings) {
            int k = idx.get(call);
            
            String temp = players[k];
            players[k] = players[k-1];
            players[k-1] = temp;
            
            idx.put(players[k-1], k-1);
            idx.put(players[k], k);
        }
        return players;
    }
}