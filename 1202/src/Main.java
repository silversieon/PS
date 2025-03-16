import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static long result = 0;
    static Integer[] C;
    static PriorityQueue<Integer[]> priorityJewelryWeight = new PriorityQueue<>(Comparator.comparingInt((Integer[] a)->a[0]));
    static PriorityQueue<Integer[]> priorityJewelryValue = new PriorityQueue<>(Comparator.comparingInt((Integer[] a)->a[1]).reversed());
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        C = new Integer[K];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            priorityJewelryWeight.add(new Integer[]{x, y});
        }
        
        for(int i=0; i<K; i++){
            C[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(C);
        
        for(int i=0; i<K; i++){
            while(!priorityJewelryWeight.isEmpty()){
                if(priorityJewelryWeight.peek()[0] > C[i]){
                    break;
                }
                priorityJewelryValue.add(priorityJewelryWeight.poll());
            }
            if(!priorityJewelryValue.isEmpty()){
                result+=priorityJewelryValue.poll()[1];
            }
        }
        System.out.println(result);
    }
}