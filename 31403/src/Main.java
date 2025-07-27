import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String A = (br.readLine());
        String B = (br.readLine());
        String C = (br.readLine());

        sb.append(Integer.parseInt(A) + Integer.parseInt(B) - Integer.parseInt(C)).append("\n");
        sb.append(Integer.parseInt(A+B)-Integer.parseInt(C));
        System.out.println(sb.toString());
    }
}
