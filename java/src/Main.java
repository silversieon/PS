import java.awt.Point;
import java.io.*;
public class Main {
    static String str1, str2, answer ="";
    static int lcs[][];
    static int N, M;
    static void backtrack(Point p){
        int curX = (int)p.getX();
        int curY = (int)p.getY();
        if(curX==0 || curY ==0){
            return;
        }
        if(lcs[curX][curY-1] == lcs[curX-1][curY]){
            if((lcs[curX-1][curY-1]+1) == lcs[curX][curY]){
                answer = str1.substring(curX-1, curX) + answer;
            }
            if((lcs[curX-1][curY]) == 0 && (lcs[curX][curY-1]) == 0){
                return;
            }
            backtrack(new Point(curX-1, curY-1));
        } else {
            if(lcs[curX-1][curY] == lcs[curX][curY]){
                backtrack(new Point(curX-1, curY));
            } else  if (lcs[curX][curY-1] == lcs[curX][curY]){
                backtrack(new Point(curX, curY-1));
            }
        }
    }
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

        if(lcs[N][M] != 0){
            backtrack(new Point(N, M));
            System.out.println(answer);
        }
    }
}
