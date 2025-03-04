import java.io.*;
import java.util.*;

public class Main {
    static int N, H, minPass = Integer.MAX_VALUE, totalCourseCount = 0;
    static int[] obstacles, breakCount;
    // static boolean Check(long mid){
    //     int count = 0;
        
    // }
    // static int passCave(){
    //     int lo = 0;
    //     int hi = H;
    //     while(lo+1<hi){
    //         long mid = (lo+hi)/2;
    //         if(Check(mid)){

    //         }else{

    //         }
    //     }
    // }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        obstacles = new int[N];
        breakCount = new int[N];
        for(int i=0; i<N; i++){
            int obstacle = Integer.parseInt(br.readLine());
            obstacles[i] = i%2==0 ? obstacle : H - obstacle;
        }
        System.out.println();
    }
}
