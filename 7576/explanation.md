## 문제
![](https://velog.velcdn.com/images/keumsiun0503/post/b68bb842-8604-4e34-b213-ac3efd2aba10/image.png)
https://www.acmicpc.net/problem/7576
### 문제 설명
>
1. 토마토 상자(2차원 배열)에는 잘 익은 토마토(1)와, 익지 않은 토마토(0)가 있다.
2. 익은 토마토들의 인접한 곳에 있는 익지 않은 토마토들은 익은 토마토의 영향을 받아서 다음날 익게 된다.(인접한 곳은 상하좌우 네 방향을 의미, 토마토가 저절로 익는 경우는 없음)
3. 또한 토마토가 아예 없는 빈 공간도 있다(-1).
4. 토마토 상자의 크기와, 상자 내부의 익은 토마토, 익지 않은 토마토, 빈 공간에 대한 정보가 주어졌을 때, 며칠이 지나면 토마토들이 모두 익는지 최소 일수를 출력
(만약 토마토가 모두 익지 못 하는 상황이라면 -1을 출력)

![](https://velog.velcdn.com/images/keumsiun0503/post/797e8986-89af-493f-8716-487585fd0f38/image.png)
💭문제를 이해하기 위해서 좋은 테스트 케이스들을 가져왔다.
- 예제 입력1번의 경우, 
빈 공간은 없고 우측 하단에 익은 토마토(1)가 하나 있다.
1번의 영향을 받아서 위와 왼쪽의 토마토가 다음 날 익게 될 것이다.
또 그 영향을 받아 익은 토마토들에 인접한 토마토들이 다음 날 익게 될 것이다.
계산해보면 모두 익는데에는 8일이 걸린다.
- 예제 입력2번의 경우,
익지 않은 토마토(0)이 좌측 상단에 빈 공간에 둘러싸여있다.
이런 경우에는 며칠이 지나더라도 익은 토마토에 인접할 수 없다(-1 출력)
- 예제 입력 3번의 경우, 두 개의 익은 토마토가 있다.
다음 날이 되면 두 토마토의 아래, 위에 있는 익지 않은 토마토가 익게 될 것이다.
이렇게 반복 되다 보면 6일이 지난 후에는 모든 토마토가 익게 된다.

💡**BFS(Breadth-First Search) 너비 우선 탐색**
각 익은 토마토들에 대해서 인접한 모든 익지 않은 토마토들에 대한 탐색이 이루어져야 하므로, BFS 탐색 기법을 사용한다.
익은 토마토가 한 개라면 BFS 탐색이 쉬워 보이는데, **"익은 토마토가 두 개 이상이라면 동시에 BFS를 진행하여 날짜를 구해야 하는데, 이를 어떻게 구현하는가?"**가 핵심이다.
해결책으로는 BFS를 동시에 진행하는 것처럼 보이는 **큐**를 사용하면 된다.
🔥**큐**에 익은 토마토의 좌표값들을 넣고, BFS 탐색을 진행한다. 이때, 익지 않은 토마토가 탐색 되었을 때, 해당 토마토에 **(기준으로 탐색을 시작한 토마토의 값 + 1)** 값을 저장한다.
- 예를 들어 예제 입력1번의 경우, 
익은 토마토를 기준으로 첫 번째 BFS 탐색을 했을 때, 익은 토마토에 인접한 익지 않은 토마토들은 
**(익은 토마토의 값(1) + 1)** = 2가 저장된다.
다음 익은 토마토들에 대해서 두 번째 BFS 탐색을 하면, 익은 토마토에 인접한 익지 않은 토마토들은 
**(익은 토마토의 값(2) + 1)** = 3이 저장된다.

이런 방식을 처음부터 큐에 **익은 토마토들의 초기 좌표값**을 모두 넣고 시작하면, 토마토가 여러 개여도 인접한 익지 않은 토마토들은 **(익은 날짜 + 1)**의 값을 부여 받는다.(동시에 탐색하는듯한 효과)

📖**좌표 값은 Java의 awt 라이브러리에 포함된 Point 클래스 활용**
- 생성자 new Point(x, y)는 x, y의 좌표 값을 가지는 Point 객체 생성
- 객체.getX() 메소드는 객체의 x좌표 값을 불러옴
- 객체.getY() 메소드는 객체의 y좌표 값을 불러옴
### 문제 풀이 설계
>
1. tomatoBox의 크기 M(열), N(행)을 입력 받고, tomatoBox 크기 할당
2. tomatoBox 내부의 정보( 토마토(1), 익지 않은 토마토(0), 빈 공간(-1) ) 입력 받아서 저장
3. 토마토 박스 내부에 익은 토마토의 좌표 값을 모두 큐에 삽입
4. 큐가 비어있는 상태가 될 때까지 **BFS 탐색** 반복
4-1. 익은 토마토(기준)의 상하좌우 위치를 탐색. 
해당 위치가 배열의 범위를 벗어나지 않고, 아직 익지 않은 토마토라면 
해당 토마토의 좌표값을 큐에 삽입, 해당 토마토 위치에 **(익은 토마토(기준)값 + 1) 값** 부여 
5. 모두 익는 최소 일수를 출력하기 위해서 각 토마토 위치를 방문, 부여된 값을 계산 **caculateDays**
5-1. 만약 익지 않은 토마토(0)가 하나라도 발견되면 즉시 -1을 출력
5-2. 그렇지 않다면 
토마토 위치에 부여된 값 중 가장 큰 값(가장 마지막으로 토마토에 부여된 값) - 1을 하여 출력(1일부터 시작하여 익은 날짜가 아닌 익는데 걸리는 일수를 구해야함. 기준값+1을 해왔으므로 최종값-1이 필요)

## 문제 풀이
```java
import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int M, N, day = Integer.MIN_VALUE;
    static int[][] tomatoBox;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static Queue<Point> queue = new LinkedList<>();
    static void BFS(){
        //4. 큐가 비어있을 때 까지
        while(!queue.isEmpty()){
            Point currentPoint = queue.poll();
            int currentX = (int)(currentPoint.getX());
            int currentY = (int)(currentPoint.getY());
            //4-1. 익은 토마토(기준)의 상하좌우 위치 탐색
            for(int i=0; i<4; i++){
                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];
                //4-1. 만약 조건에 부합하면 큐에 삽입, 해당 토마토 위치에 (기준값 + 1) 부여
                if(nextX>=0 && nextX<N && nextY>=0 && nextY<M && tomatoBox[nextX][nextY]==0){
                    queue.offer(new Point(nextX, nextY));
                    tomatoBox[nextX][nextY] = tomatoBox[currentX][currentY] + 1;
                }
            }
        }
    }
    static int caculateDays(){
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                //5-1. 익지 않은 토마토 발견시 즉시 -1 출력
                if(tomatoBox[i][j]==0){
                    return -1;
                }
                //5-2. 박스 내부에서 마지막으로 익은 토마토의 값을 day 변수에 저장
                day = Math.max(tomatoBox[i][j], day);
            }
        }
        //5-2. 익는 데에 걸리는 일수이므로 day-1 반환
        return day-1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        //1. M(열) N(행) 입력 받고 박스 크기 할당
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        tomatoBox = new int[N][M];
        //2. 토마토 박스 정보 저장
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                tomatoBox[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //3. 익은 토마토들의 좌표 값을 모두 큐에 삽입
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(tomatoBox[i][j]==1){
                    queue.offer(new Point(i, j));
                }
            }
        }
        //4. BFS 탐색 시작, 토마토 위치에 값 부여
        BFS();
        //5. 모두 익는 최소 일수 구하여 출력
        System.out.println(caculateDays());
    }
}
```
![](https://velog.velcdn.com/images/keumsiun0503/post/d177d824-7d8f-4613-9aff-4ffe53b32c93/image.png)
### 느낀점
>
BFS를 처음 배웠을 때 풀려고 시도했다가 못 풀었던 문제인데, 오랜만에 보고 다시 풀었더니 금방 풀려서 기분이 좋았던 문제다. 꾸준하게 문제를 풀면서 기본적인 풀이 방식을 익히다 보면, 풀이 방식에는 문제가 없으므로 조금 더 다양한 관점에서 문제 풀이 방향을 생각할 수 있게 되는 것 같다. 수학도 기본기가 탄탄해야 문제를 다양한 방식으로 풀 수 있듯이, 코딩테스트도 마찬가지인 것 같다. 