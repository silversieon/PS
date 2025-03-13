## 문제
![](https://velog.velcdn.com/images/keumsiun0503/post/ac709c3d-0a10-4e42-833e-586fa55e6f95/image.png)
https://www.acmicpc.net/problem/11000

### 문제 설명
>
1. S에서 시작하여 T에 끝나는 N개의 수업이 있음.
2. 최소의 강의실을 사용하여 모든 수업을 가능하게 해야함.
3. 최소 강의실의 개수 출력
- 조건 1: 수업이 끝난 직후에 다음 수업 시작 가능 ex) 3에 끝나는 수업과 3에 시작하는 수업은 같이 들을 수 있음.

📖테스트 케이스 살펴보기
![](https://velog.velcdn.com/images/keumsiun0503/post/4d9e15f6-6e50-4f05-a3c7-cf7c9f5a4dc8/image.png)

수업의 수는 3개
1 ~ 3 (1번 수업)
2 ~ 4 (2번 수업)
3 ~ 5 (3번 수업)
- 1번 수업과 3번 수업은 하나의 강의실에서 수업 가능
- 2번 수업은 다른 강의실 하나 필요 +1

따라서 결과 값은 2

💡**그리디와 우선순위큐**
- **그리디**
각 단계에서 욕심내어 값을 취하여 단계별 최적해를 모아 최종적인 해의 근사값을 얻는 방식.

수업을 하나씩 고려하며, 해당 수업을 들을 때 필요한 강의실의 개수를 계속 취함
- **우선순위큐**
큐는 선입선출의 구조 방식인데, 우선순위큐는 자료에 우선순위를 두어 우선순위가 높은 자료가 먼저 내보내지는 자료구조

🔥**문제에 적용해보기**

1. 수업들을 시작하는 순서대로 오름차순 정렬
(모든 수업을 듣는 것을 목표로 하기 때문에 첫 수업이 1~999시간이라고 하면, 이 범위 안에 들어있는 다음 수업들은 무조건 강의실을 추가로 빌려야 함! 따라서 시작순대로 오름차순 정렬 필요)

2. 첫 수업부터 시작하여 현재 수업이 끝나는 시간을 **end**로 두고, 첫 수업의 **end**를 **우선순위큐**에 넣고 시작(해당 수업이 진행 중).

3. 모든 수업을 하나씩 거치며 강의실을 빌려야하는지, 안 빌려도 되는지를 계산
3-1. 만약 현재 수업 시간이 진행 중인 수업과 겹치면, **강의실++**, **우선순위큐**에 현재 수업의 **end** 삽입
(해당 수업이 진행 중임)
3-2. 만약 그렇지 않다면 진행 중인 수업 하나가 마무리 됐다는 의미이므로 **우선순위큐**에서 숫자 하나를 뽑고(강의를 하나 끝내며) 현재 수업이 끝나는 시간 **end**를 **우선순위큐**에 삽입

4. 강의실 개수 출력

### 문제 풀이 설계
>
1. 수업의 수 **N** 입력 받기
2. 각 수업의 시작 시간과 종료 시간을 2차원 배열 **lesson**에 저장, 시작 시간 순으로 **오름차순 정렬**
3. 첫 수업의 종료 시간 **end**를 **pq**(우선순위큐)에 넣고, 모든 수업을 하나씩 거치며 다음 조건에 따라 강의실을 빌림
3-1. 만약 현재 수업의 시작 시간이 진행 중인 강의와 겹친다면,
**countRoom++, pq.add(currentEnd)** (현재 수업 시작)
3-1. 그렇지 않다면(진행 중인 수업 하나가 마무리 됐고, 해당 강의실 사용 가능)
**pq.poll()** (수업 끝), **pq.add(currentEnd)** (현재 수업 시작)
4. **최소 강의실의 수 countRoom** 출력

## 문제 풀이
```java
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
        Arrays.sort(lesson, 0, N, Comparator.comparingInt(a->a[0]));
    
        System.out.println(caculateNumOfRoom());
    }
}
```
![](https://velog.velcdn.com/images/keumsiun0503/post/ccfb8c2c-e580-4d30-bea0-53e94ee74a7d/image.png)
### 느낀점
>
실패해서 아쉬웠던 1931번 회의실 배정과 비슷한데, 생각보다 쉽게 풀려서 기분 좋았던 문제. 그리디와 정렬 문제를 많이 풀면서 풀이 감각을 익히고 빨리 1931번도 풀고 싶다..
