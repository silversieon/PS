import java.io.*;
import java.util.*;

public class Main {
    static int T, n, d;
    static int[][] array;
    static StringBuilder sb = new StringBuilder();
    static void rotate(int _numOfRotate, int[][] _array){
        if(_numOfRotate==0){
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    sb.append(_array[i][j]).append(" ");
                }
                sb.append('\n');
            }
            return;
        }
        int[][] tempArray = new int[n][n];
        int mid = n/2;
        int col_count = n-1;
        int row_count = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                //1. 주 대각선을 가운데 열로
                if(i==j){
                    tempArray[i][mid] = _array[i][j];
                }if (j==mid){
                    tempArray[i][col_count] = _array[i][j];
                    col_count--;
                }
                if ((i+j+1)/2==mid){
                    tempArray[mid][j] = _array[i][j];
                }
                if (i==mid) {
                    tempArray[row_count][j] = _array[i][j];
                    row_count++;
                }
                if(tempArray[i][j]==0){
                    tempArray[i][j] = _array[i][j];
                }
            }
        }
        int numofRotate = _numOfRotate;
        rotate(numofRotate-1, tempArray);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while(T-->0){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            array = new int[n][n];
            
            for(int i=0; i<n; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<n; j++){
                    array[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            if(d<0){
                d +=360;
            }
            rotate(d/45, array);
        }
        System.out.print(sb.toString());
    }
}