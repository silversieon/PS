import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Queue<String> cache = new LinkedList<>();
        for(String city : cities){
            city = city.toUpperCase();
            if(cache.contains(city)){
                cache.remove(city);
                if((cacheSize - cache.size()) > 0){
                        cache.offer(city);
                    }
                answer+=1;
            } else {
                if(cache.size() < cacheSize){
                    if((cacheSize - cache.size()) > 0){
                        cache.offer(city);
                    }
                } else {
                    cache.poll();
                    if((cacheSize - cache.size()) > 0){
                        cache.offer(city);
                    }
                }
                answer+=5;
            }
        }
        return answer;
    }
}