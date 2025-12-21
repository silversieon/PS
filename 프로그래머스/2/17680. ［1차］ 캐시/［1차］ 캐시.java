import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        if(cacheSize == 0) return cities.length * 5;
        int answer = 0;
        Queue<String> cache = new LinkedList<>();
        for(String city : cities){
            city = city.toUpperCase();
            if(cache.contains(city)){
                cache.remove(city);
                cache.offer(city);
                answer+=1;
            } else {
                if(cache.size() < cacheSize){
                    cache.offer(city);
                } else {
                    cache.poll();
                    cache.offer(city);
                }
                answer+=5;
            }
        }
        return answer;
    }
}