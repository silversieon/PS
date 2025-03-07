import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, M, min = 10001, max = 0;
    static int[] nums;
    static boolean Check(int mid){
        int countInterval = 1;
        int minValue = 10001;
        int maxValue = 0;
        int maxInterval = 0;
        for(int i=0; i<N; i++){
            minValue = Math.min(minValue, nums[i]);
            maxValue = Math.max(maxValue, nums[i]);
            maxInterval = maxValue - minValue;
            if((maxInterval<=mid) && (countInterval<M)){
                countInterval++;
                maxInterval = Math.max(maxInterval, maxValue-minValue);
                minValue = 10001;
                maxValue = 0;
            } else {
                maxInterval = Math.max(maxInterval, maxValue-minValue);
            }
        }
        return maxInterval>=mid;
    }
    static int binarySearch(){
        int lo = 0;
        int hi = max - min;
        while(lo+1<hi){
            int mid = (lo+hi)/2;
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

        st= new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nums = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        System.out.println(binarySearch());
    }
}
