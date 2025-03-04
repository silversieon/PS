import java.io.*;
import java.util.*;

public class Main {
    static int N, minLo=0, minHi = 0, minValue = Integer.MAX_VALUE;
    static int[] liquid;
    static boolean Check(int lo, int hi){
        int value = liquid[lo] + liquid[hi];
        if(Math.abs(value)<=Math.abs(minValue)){
            minLo = lo;
            minHi = hi;
            minValue = value;
            return true;
        } else {
            return false;
        }
    }
    static void findTwoLiquid(){
        int lo = 0;
        int hi = N-1;
        while(lo+1<hi){
            int mid = (lo+hi)/2;
            if(Check(lo, hi)){
                hi = mid;
            } else {
                lo = mid;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        liquid = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            liquid[i] = Integer.parseInt(st.nextToken());
        }
        findTwoLiquid();
        System.out.println(liquid[minLo] + " " + liquid[minHi]);
    }
}
