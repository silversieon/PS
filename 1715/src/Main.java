import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //1. 카드 묶음들의 수 N
        int N = Integer.parseInt(br.readLine());
        //2. 카드 묶음의 각 크기 우선순위 큐에 삽입
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<N; i++){
            pq.add(Integer.parseInt(br.readLine()));
        }
        //3. N의 조건에 따라 다음 과정 수행
        if(N!=1){
            int result = 0;
            //3-1. 우선순위 큐에 값이 1개 남을 때까지 카드 묶음 두 개씩 비교.
            while(pq.size()!=1){
                int X = pq.poll() + pq.poll();
                result+=X;
                pq.add(X);
            }
            System.out.println(result);
        } 
        //4. N==1이라면, 0 출력
        else {
            System.out.println(0);
        }
    }
}