import java.io.*;
import java.util.*;

public class Main {
    static HashSet<Integer> hashSet = new HashSet<>();
    public static void main(String[] args) throws IOException {
        for(int i=1; ; i++){ 
            String result = String.valueOf(i);
            int tmp = Integer.parseInt(result);
            for(int k=0; k<result.length(); k++){
                tmp += Integer.parseInt(result.substring(k, k+1));
            }
            if(tmp>10035) break;
            hashSet.add(tmp);
        }
        for(int i=1; i<=10000; i++){
            if(!hashSet.contains(i)){
                System.out.println(i);
            }
        }
    }
}
