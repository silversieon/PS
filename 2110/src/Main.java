import java.util.*;
import java.io.*;

public class Main {
    static int N, C;
    static int[] houses;
    static boolean[] router;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        houses = new int[N];
        router = new boolean[N];

        for(int i=0; i<N; i++){
            houses[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(houses);

    }
}
