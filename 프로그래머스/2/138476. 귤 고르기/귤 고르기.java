import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int[] size = new int[10000001];
        for(int i=0; i<tangerine.length; i++){
            size[tangerine[i]] +=1;
        }
        Integer[] ssize = Arrays.stream(size).boxed().toArray(Integer[]::new);
        Arrays.sort(ssize, Collections.reverseOrder());
        int various = 0;
        while(k>0){
            k -= ssize[various];
            various++;
        }
        return various;
    }
}