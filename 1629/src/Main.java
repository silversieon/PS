import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int A, B, C;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        int result = 1;
        String binary = Integer.toBinaryString(B);
        A%=C;
        for(int i=0; i<binary.length(); i++){
            if(binary.substring(i, i+1).equals("0")) continue;
            result = (result % C * (int)Math.pow(A, (int)Math.pow(2, binary.length()- i - 1)) % C) % C;
        }
        System.out.println(result%C);
    }
}
