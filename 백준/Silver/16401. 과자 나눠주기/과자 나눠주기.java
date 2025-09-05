import java.io.*;
import java.util.*;

public class Main {
    static int M, N, max=0;
    static int[] snacks;
    static boolean Check(int mid){
        int numOfpiece = 0;
        for(int snack : snacks){
            numOfpiece += snack/mid;
        }
        return numOfpiece>=M;
    }
    static int caculateMaxlength(){
        int lo = 0;
        int hi = max;
        while(lo+1<hi){
            int mid = (lo + hi)/2;
            if(Check(mid)){
                lo = mid;
            } else {
                hi = mid;
            }
        }
        return Check(hi) ? hi : lo;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        snacks = new int[N];

        st=new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            snacks[i] = Integer.parseInt(st.nextToken());
            max = Integer.max(max, snacks[i]);
        }

        System.out.println(caculateMaxlength());
    }
}