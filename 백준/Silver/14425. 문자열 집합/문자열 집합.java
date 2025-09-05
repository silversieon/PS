import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        int N = Integer.parseInt(st.nextToken());
        String[] arr = new String[N];
        for(int i=0; i<N; i++){
            arr[i] = br.readLine();
        }
        Arrays.sort(arr);
        int M = Integer.parseInt(st.nextToken());
        int count = 0;
        for(int i=0; i<M; i++){
            String s1 = br.readLine();
            for(int j=0; j<N; j++){
                if(s1.equals(arr[j])){
                    count++;
                    break;
                }
            }
        }
        System.out.println(count);
    }
}
