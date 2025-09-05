import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int count = 0;

        while(N-->0){
            HashSet<Character> hash = new HashSet<>();
            
            String str = br.readLine();
            char start = str.charAt(0);
            hash.add(start);

            boolean isError = false;

            for(int i=1; i<str.length(); i++){
                char c = str.charAt(i);
                if(!hash.contains(c)){
                    hash.add(c);
                    start = c;
                } else if (hash.contains(c) && c!=start){
                    isError = true;
                    break;
                }
            }

            if(!isError){
                count++;
            }
        }
        System.out.println(count);
    }
}