
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int result = 0;
        int N = Integer.parseInt(br.readLine());
        for(int i=1; i<=N; i++){
            result +=i;
        }
        System.out.println(result);
    }
}
