import java.io.*;
import java.util.*;

public class Main {
    static int N, count=0;
    static HashMap<String, Integer> hash = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            hash.put(br.readLine(), i);
        }

        for(int i=0; i<N; i++){
            if(hash.get(br.readLine()) < i){
                count++;
            }
        }
        System.out.println(count);
    }
}
