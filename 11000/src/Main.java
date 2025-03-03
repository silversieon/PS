import java.io.*;
import java.util.*;

public class Main {
    static int N, countRoom = 1;
    static int[][] lesson;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    static int caculateNumOfRoom(){
        int start = lesson[0][0];
        int end = lesson[0][1];
        pq.add(end);
        for(int i=1; i<N; i++){
            int currentStart = lesson[i][0];
            int currentEnd = lesson[i][1];
            if(currentStart>=start && currentStart<pq.peek()){
                countRoom++;
                pq.add(currentEnd);
            } else {
                pq.poll();
                pq.add(currentEnd);
            }
        }
        return countRoom;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        lesson = new int[N][2];

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            lesson[i][0] = Integer.parseInt(st.nextToken());
            lesson[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(lesson, 0, N, Comparator.comparingInt(a->a[0]));
    
        System.out.println(caculateNumOfRoom());
    }
}