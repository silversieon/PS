import java.util.*;
class Solution {
    public int solution(String[] friends, String[] gifts) {
        // 이름을 idx로 매핑하는 Map 필요
        // 각 사람이 누구에게 몇 개 줬는지 확인하는 2차원 배열 give와 각 사람의 선물 지수를 저장할 score 1차원 배열 필요
        // gifts를 순회하며 누가 누구에게 몇 개 줬는지, 받았는지 저장, 선물 지수도 갱신
        // friends를 2중 순회하며 최종적으로 받을 선물 개수 저장
        // 선물 개수의 최대값 반환
        int n = friends.length;
        Map<String, Integer> idx = new HashMap<>();
        for(int i=0; i<n; i++) idx.put(friends[i], i);
        
        int[][] give = new int[n][n];
        int[] score = new int[n];
        
        for(String gift : gifts) {
            String[] s = gift.split(" ");
            int from = idx.get(s[0]);
            int to = idx.get(s[1]);
            
            give[from][to]++;
            score[from]++;
            score[to]--;
        }
        
        int[] total = new int[n];
        for(int a=0; a<n; a++){
            for(int b=a+1; b<n; b++) {
                if (give[a][b] > give[b][a]) total[a]++;
                else if (give[b][a] > give[a][b]) total[b]++;
                else {
                    if(score[a] > score[b]) total[a]++;
                    else if (score[b] > score[a]) total[b]++;
                }
            }
        }
        int answer = 0;
        for(int t : total) answer = Math.max(answer, t);
        return answer;
    }
}