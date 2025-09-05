import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        int k = (int)Math.log10(B) + 1;
        sb.append(A+B-C).append("\n").append(A*(int)(Math.pow(10, k))+B-C);
        
        System.out.println(sb.toString());
    }
}