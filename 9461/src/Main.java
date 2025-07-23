import java.io.*;

public class Main {
    static int T, N;
    static long[] lengths = new long[100];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        
        lengths[2] = lengths[1] = lengths[0] = 1;
        lengths[4] = lengths[3] = 2;

        while(T-->0){
            N = Integer.parseInt(br.readLine());

            for(int i=5; i<N; i++){
                lengths[i] = lengths[i-1] + lengths[i-5];
            }
            sb.append(lengths[N-1]).append("\n");
        }

        System.out.print(sb.toString());
    }
}
