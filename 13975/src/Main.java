import java.io.*;
import java.util.*;

public class Main {
    static int T, K;
    static PriorityQueue<Long> pq = new PriorityQueue<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        //1. 테스트 데이터 수 T
        T = Integer.parseInt(br.readLine());

        while(T-->0){
            //2. 각 장의 수 K와 각 장의 크기를 우선순위 큐에 삽입
            K = Integer.parseInt(br.readLine());
            long result = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            while(K-->0){
                pq.add(Long.parseLong(st.nextToken()));
            }
            //3. 우선순위 큐의 데이터가 한 개 남을때까지 반복
            while(pq.size()!=1){
                Long X = pq.poll() + pq.poll();
                result+=X;
                pq.add(X);
            }
            //4. 결과값 출력, 우선순위 큐 내부 데이터 삭제(남은 테스트 데이터에 사용해야하므로)
            sb.append(result).append('\n');
            pq.clear();
        }
        br.close();
        System.out.print(sb.toString());
    }
}