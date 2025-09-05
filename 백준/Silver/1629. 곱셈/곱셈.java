import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static long A, B, C, result = 1;
    static void calc(long k){
        if(k==1){
            result = (result * A) % C;
            return;
        } 
        if(k%2==1){
            result = (result * A) % C;
            k-=1;
            calc(k);
        } else {
            A=(A*A) % C;
            calc(k/2);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        calc(B);
        System.out.println(result%C);
    }
}