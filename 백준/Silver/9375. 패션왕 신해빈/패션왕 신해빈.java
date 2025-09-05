import java.io.*;
import java.util.*;

public class Main {
    static int T, N, result = 1;
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        while(T-->0){
            N = Integer.parseInt(br.readLine());

            HashMap <String, Integer> hashmap = new HashMap<>();
            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());

                st.nextToken();
                String type = st.nextToken();

                if(!hashmap.containsKey(type)){
                    hashmap.put(type, 2);
                } else {
                    hashmap.put(type, hashmap.get(type)+1);
                }
            }
            
            Set<String> set = hashmap.keySet();
            Iterator<String> iterator = set.iterator();
            
            while(iterator.hasNext()){
                result *= hashmap.get(iterator.next());
            }
            sb.append(result-1).append("\n");
            result = 1;
        }
        System.out.println(sb.toString());
    }
}