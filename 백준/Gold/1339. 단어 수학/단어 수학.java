import java.io.*;
import java.util.*;

public class Main {
    static int N, result = 0, value = 9;
    static String[] word;
    static HashMap<Character, Integer> countMap = new HashMap<>();
    static PriorityQueue<Character> pq = new PriorityQueue<>(Collections.reverseOrder(Comparator.comparingInt(c -> countMap.get(c))));
    static void calcResult(){
        for(int i=0; i<N; i++){
            for(int j=0; j<word[i].length(); j++){
                Character c = word[i].charAt(j);
                if(countMap.containsKey(c) && !pq.contains(c)){
                    pq.add(c);
                }
            }
        }
        while(!pq.isEmpty()){
            Character c = pq.poll();
            result += value * countMap.get(c);
            value--;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        word = new String[N];

        for(int i=0; i<N; i++){
            word[i] = br.readLine();
            for(int k=0; k<word[i].length(); k++){
                double mulValue = Math.pow(10, word[i].length()-1-k);
                char c = word[i].charAt(k);
                if(countMap.containsKey(c)){
                    countMap.put(c, countMap.get(c)+(int)mulValue);
                } else {
                    countMap.put(c, (int)mulValue);
                }
            }
        }

        calcResult();
        System.out.println(result);
    }
}