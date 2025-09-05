import java.io.*;
import java.util.*;

//초기화 되는 거리 distance
//이동시마다 distance를 구한 후 이전 distance보다 작다면 이것을 해로 사용
//방법1 (X+Y)*W
//방법2 ()
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long x = Long.parseLong(st.nextToken());
        long y = Long.parseLong(st.nextToken());
        long w = Long.parseLong(st.nextToken());
        long s = Long.parseLong(st.nextToken());

        //방법1
        long case1 = (x+y)*w;
        //방법2
        long case2 = 0;
        if((x+y) %2==0){
            case2 = Math.max(x, y) * s;
        }
        else{
            case2 = (Math.max(x, y)- 1)*s + w;
        }
        //방법3
        long case3 = (Math.min(x, y))*s+(Math.abs(x-y))*w;

        System.out.println(Math.min(case1, Math.min(case2, case3)));
    }
}