import java.io.*;
import java.util.*;

//1. 블럭을 채우기만하기
//2. 블럭을 제거하기만하기
//3. 블럭을 제거하고 채우기 (블럭을 높은 순부터 제거-채우기 과정 반복())
public class Main {
    static int N, M, B, countTime = 0, minTime = Integer.MAX_VALUE, resultHeight, minHeight= 256, maxHeight = 0;
    static int[][] ground;
    static int[][] copyGround;
    static StringTokenizer st;
    static void calcTime(int height){
        int ownBlock = B;
        
        
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(copyGround[i][j] > height){
                    int countDig = copyGround[i][j] - height;
                    copyGround[i][j] -= countDig;
                    ownBlock += countDig;
                    countTime += countDig*2;
                } else if (copyGround[i][j] < height) {
                    
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        ground = new int[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                ground[i][j] = Integer.parseInt(st.nextToken());
                minHeight = Math.min(minHeight, ground[i][j]);
                maxHeight = Math.max(maxHeight, ground[i][j]);
            }
        }

        for(int i=minHeight; i<=maxHeight; i++){
            for(int k=0; k<N; k++){
                copyGround[k] = ground[k].clone();
            }
            calcTime(i);
        }

        System.out.print(minTime + " " + resultHeight);
    }
}
