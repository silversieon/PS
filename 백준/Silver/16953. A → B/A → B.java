import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int count = 0;
        while(B>A){
            if(B%10!=1 && B%2!=0){
                break;
            }
            if(B%10==1){
                B/=10;
            } else {
                B/=2;
            }
            count++;
        }
        int result = B==A ? count + 1 : -1;
        System.out.println(result);
    }
}
