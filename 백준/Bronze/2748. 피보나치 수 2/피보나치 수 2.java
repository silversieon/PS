import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static long arr[]=new long[91];
    static long fibo(int N){
        arr[0] = 0;
        arr[1] = 1;
        if(N<=1){
            return arr[N];
        }
        else{
            for(int i=2; i<N+1; i++){
                arr[i] = arr[i-1] + arr[i-2];
            }
            return arr[N];
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        System.out.println(fibo(N));
    }
}
