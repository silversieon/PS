import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] list;
    static HashSet<Integer> friend1 = new HashSet<>();
    static HashSet<Integer> friend2 = new HashSet<>();
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        list = new int[M][2];
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            list[i][0] = Integer.parseInt(st.nextToken());
            list[i][1] = Integer.parseInt(st.nextToken());
            if(list[i][0]== 1){
                friend1.add(list[i][1]);
            }
        }

        for(int i=0; i<M; i++){
            if(list[i][0]!=1){
                if(friend1.contains(list[i][0]) && !friend1.contains(list[i][1])){
                    friend2.add(list[i][1]);
                } else if(friend1.contains(list[i][1]) && !friend1.contains(list[i][0])){
                    friend2.add(list[i][0]);
                }
            }
        }
        
        System.out.println(friend1.size() + friend2.size());
    }
}