import java.io.*;

public class Main {
    static int N, max = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        if(N<=2){
            int result = 0;
            for(int i=0; i<N; i++){
                result += Integer.parseInt(br.readLine());
            }
            System.out.println(result);
        } else {
            int[] result = new int[N+3];
            for(int i=3; i<=N+2; i++){
                int number = Integer.parseInt(br.readLine());
                result[i] += Math.max(result[i-2], result[i-3]) + number;
                max = Math.max(max, result[i]);
            }
            System.out.println(max);
        }
    }
}
