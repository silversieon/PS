import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int max = Integer.MIN_VALUE;
        int result = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            int X = Integer.parseInt(st.nextToken());
            result+=X;
            if(X>result){
                result = X;
            }
            max = Math.max(max, result);
        }
        System.out.println(max);
    }
}
