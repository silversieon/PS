import java.io.*;

public class Main {
    static String str1, str2;
    static int lcs[][];
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str1 = br.readLine();
        str2 = br.readLine();
        N = str1.length();
        M = str2.length();
        lcs = new int[N+1][M+1];
        for(int i=0; i<N; i++){
            String s1 = str1.substring(i, i+1);
            for(int j=0; j<M; j++){
                String s2 = str2.substring(j, j+1);
                if(s2.equals(s1)){
                    lcs[i+1][j+1] = lcs[i][j] + 1;
                } else {
                    lcs[i+1][j+1] = Math.max(lcs[i][j+1], lcs[i+1][j]);
                }
            }
        }
        System.out.println(lcs[N][M]);
    }
}