import java.io.*;
import java.util.*;

public class Main {
    static int N, count=0;
    static HashMap<String, Integer> hashmap = new HashMap<>();
    static HashSet<String> hashset = new HashSet<>();
    static String[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        list = new String[N];

        for(int i=0; i<N; i++){
            String carNum = br.readLine();
            hashmap.put(carNum, i);
        }

        for(int i=0; i<N; i++){
            String carNum = br.readLine();
            list[i] = carNum;

            int originOrder = hashmap.get(carNum);
            if(originOrder < i){
                for(int j=0; j<i; j++){
                    if(!hashset.contains(list[j]) && hashmap.get(list[j]) > originOrder){
                        hashset.add(list[j]);
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }
}