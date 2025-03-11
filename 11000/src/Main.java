import java.io.*;
import java.util.*;

public class Main {
    static int N, countRoom = 1;
    static int[][] lesson;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    static int caculateNumOfRoom(){
        //3. 첫 수업의 종료 시간 pq에 넣고 모든 수업을 거치면서 강의실 빌림
        int end = lesson[0][1];
        pq.add(end);
        for(int i=1; i<N; i++){
            int currentStart = lesson[i][0];
            int currentEnd = lesson[i][1];
            //3-1. 현재 진행 중인 강의와 겹칠 때
            if(currentStart<pq.peek()){
                countRoom++;
            } 
            //3-2. 그렇지 않을 때(강의 하나 종료)
            else {
                pq.poll();
            }
            pq.add(currentEnd);
        }
        //4. 최소 강의실의 수 출력
        return countRoom;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //1. 수업의 수 N 
        N = Integer.parseInt(br.readLine());
        lesson = new int[N][2];
        //2. 수업의 시작, 종료 시간 저장, 시작 시간 순으로 오름차순 정렬
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            lesson[i][0] = Integer.parseInt(st.nextToken());
            lesson[i][1] = Integer.parseInt(st.nextToken());
        }
<<<<<<< HEAD
        
=======
>>>>>>> a395a6939d0e7279614f591eddc5e88056d746da
        Arrays.sort(lesson, 0, N, Comparator.comparingInt(a->a[0]));
        
        System.out.println(caculateNumOfRoom());
    }
}