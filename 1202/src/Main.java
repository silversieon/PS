import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static long result = 0;
    static Integer[] C;
    static PriorityQueue<Integer[]> priorityWeight = new PriorityQueue<>(Comparator.comparingInt((Integer[] a)->a[0]));
    static PriorityQueue<Integer[]> priorityValue = new PriorityQueue<>(Comparator.comparingInt((Integer[] a)->a[1]).reversed());
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        //1. 보석의 수 N, 가방의 수 K
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        C = new Integer[K];
        //2. 보석의 무게, 가치를 입력 받아 무게가 낮은 순대로 내보내는 우선순위큐에 저장
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            priorityWeight.add(new Integer[]{x, y});
        }
        //3. 가방의 최대 무게 저장, 오름차순 정렬
        for(int i=0; i<K; i++){
            C[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(C);
        //4. 각 가방에 대하여 하나씩 넣을 수 있는 보석 리스트를 재활용
        for(int i=0; i<K; i++){
            //4-1. 해당 가방의 무게보다 작거나 같은 보석을 모두 가치가 높은 순대로 내보내는 우선순위큐에 저장
            while(!priorityWeight.isEmpty()){
                if(priorityWeight.peek()[0] > C[i]){
                    break;
                }
                priorityValue.add(priorityWeight.poll());
            }
            //4-2. 보석 리스트에서 최대 가치의 보석을 꺼내어 저장
            if(!priorityValue.isEmpty()){
                result+=priorityValue.poll()[1];
            }
        }
        //5. 최대 가격 출력
        System.out.println(result);
    }
}