import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static long lo = 0, hi = 0;
    static long[] lessons;
    static boolean Check(long mid){
        long sum = 0;
        int count = 1;
        for(long lesson : lessons){
            sum +=lesson;
            if(sum>mid){
                sum = lesson;
                count++;
            }
        }
        return count<=M;
    }
    static long binarySearch(){
        while(lo + 1 < hi){
            long mid = (lo+hi) / 2;
            if(Check(mid)){
                hi = mid;
            } else {
                lo = mid;
            }
        }
        return Check(hi) ? hi : lo;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        lessons = new long[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            lessons[i] = Integer.parseInt(st.nextToken());
            lo = Math.max(lo, lessons[i]);
            hi += lessons[i];
        }
        System.out.println(binarySearch());
    }
}
