import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int caculate(int N){
        int count = 0;
        int big = N/5;
        for(int i=big; i>0; i--){
            int weight = N;
            weight-=i*5;
            if(weight%3==0){
                count = i + weight/3;
                break;
            }
        }
        return count!=0 ? count : ((N%3==0) ? N/3 : -1);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int result = 0;

        System.out.println(caculate(N));
    }
}