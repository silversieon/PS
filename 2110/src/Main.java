import java.io.*;
import java.util.*;

public class Main {
    static int N, C;
    static int min = Integer.MAX_VALUE, max = -1;
    static int[] houses;
    static boolean Check(int mid){
        int count = 1;
        int minDistance = Integer.MAX_VALUE;
        int nowRouter = houses[0];
        for(int i=1; i<N-1; i++){
            int distance = houses[i] - nowRouter;
            if(distance>=mid && count<C-1){
                count++;
                minDistance = Math.min(minDistance, distance);
                nowRouter = houses[i];
            }
        }
        minDistance = Math.min(minDistance, houses[N-1] - nowRouter);
        return minDistance<=mid; 
    }
    static int binarySearch(){
        int lo = 0;
        int hi = max - min;
        while(lo+1<hi){
            int mid = (lo+hi)/2;
            System.out.println(mid);
            if(Check(mid)){
                hi = mid;
            } else {
                lo = mid;
            }
        }
        return Check(hi) ? hi : lo;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        houses = new int[N];

        for(int i=0; i<N; i++){
            houses[i] = Integer.parseInt(br.readLine());
            min = Math.min(min, houses[i]);
            max = Math.max(max, houses[i]);
        }
        Arrays.sort(houses);
        System.out.println(binarySearch());
    }
}
