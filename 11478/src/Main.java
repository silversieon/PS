import java.io.*;
import java.util.*;

public class Main {
    static String S;
    static HashSet<String> hs = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        S = br.readLine();

        for(int i=0; i<S.length(); i++){
            for(int j=i+1; j<S.length()+1; j++){
                hs.add(S.substring(i, j)); //i ~ j-1 인덱스 위치의 String까지 삽입
            }
        }
        System.out.println(hs.size());
    }
}