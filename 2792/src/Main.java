import java.io.*;
import java.util.*;

public class Main {
    static int N, M, max = -1;
    static int[] numOfjewel;
    static boolean Check(int mid){
        int numOfstudent = N;
        for(int i=0; i<M; i++){
            numOfstudent-= Math.ceil((double)numOfjewel[i]/(double)mid);
            if(numOfstudent<0){
                break;
            }
        }
        return numOfstudent>=0 ? true : false;
    }
    static int caculateJealousy(){
        int lo = 0;
        int hi = max;
        while(lo+1<hi){
            int mid = (lo+hi) / 2;
            if(Check(mid)){
                hi = mid;
            } else {
                lo = mid;
            }
        }
        return Check(lo) ? lo : hi;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        numOfjewel = new int[M];

        for(int i=0; i<M; i++){
            numOfjewel[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, numOfjewel[i]);
        }
        System.out.println(caculateJealousy());
    }
}
