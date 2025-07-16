import java.io.*;
import java.util.*;

public class Main {
    static int N, curStartTime, curEndTime, progStartTime, progEndTime, result = 0;
    static int[][] meeting;
    static StringTokenizer st;
    static void calcMaxMeeting(){
        progStartTime = meeting[0][0];
        progEndTime = meeting[0][1];

        for(int i=1; i<N; i++){
            curStartTime = meeting[i][0];
            curEndTime = meeting[i][1];

            //마지막 회의의 경우 시작시간이 진행 중인 회의의 끝나는 시간과 크거나 같으면 +2, 아니면 +1
            if(i==N-1){
                if(curStartTime >= progEndTime){
                    result+=2;
                } else {
                    result++;
                }
                break;
            }

            //진행 중인 회의가 끝나는 시간이 왔을 때(현재 회의 시작 시간 >= 진행 회의 끝 시간) -> 결과+1, 현재 회의를 진행
            if(curStartTime >= progEndTime){
                result++;
                progStartTime = curStartTime;
                progEndTime = curEndTime;
            //현재 회의가 진행 중인 회의 시간 도중에 있고, 회의 시간이 더 짧은 경우 -> 현재 회의로 바꾸어 진행
            } else if((curEndTime-curStartTime < progEndTime - progStartTime) && curEndTime < progEndTime){
                progStartTime = curStartTime;
                progEndTime = curEndTime;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        meeting = new int[N][2];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            meeting[i][0] = Integer.parseInt(st.nextToken());
            meeting[i][1] = Integer.parseInt(st.nextToken());
        }

        // 0 ~ N-1 인덱스까지 2차원 배열의 0열 순 정렬, 같다면 1열순 정렬
        Arrays.sort(meeting, 0, N,
            Comparator.comparingInt((int[] a) -> a[0])
            .thenComparingInt((int[] a) -> a[1]));
        
        calcMaxMeeting();
        System.out.println(result);
    }
}