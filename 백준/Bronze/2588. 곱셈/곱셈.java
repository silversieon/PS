import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int A = Integer.parseInt(br.readLine());
        String B = br.readLine();
        
        for(int i=B.length()-1; i>=0; i--){
            System.out.println(A*(B.charAt(i)-'0'));
        }
        System.out.println(A*Integer.parseInt(B));
    }
}
