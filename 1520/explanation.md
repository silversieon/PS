## 문제
![](https://velog.velcdn.com/images/keumsiun0503/post/c1e08757-7750-41b0-b7f6-c172b146ee29/image.png)
https://www.acmicpc.net/problem/1520
### 문제 설명
>
1. 직사각형 모양 지도가 여러 칸으로 나뉘어져있고, 각 칸에 숫자가 써있다.
2. 각 숫자는 해당 지점의 높이를 나타내고, 지점 사이의 이동은 항상 내리막길만 가능하다.(큰 곳에서 작은 곳으로만)
3. 왼쪽 위 칸에서 시작하여 오른쪽 아래 칸으로 가려고할 때, 경로의 개수를 출력
- 조건 1: M과 N <=500 자연수, 시간 제한 2초
- 조건 2: 이동 가능한 경로의 수 H<=10억 인 음이 아닌 정수

📖**테스트 케이스 살펴보기**
![](https://velog.velcdn.com/images/keumsiun0503/post/3eb51531-ccdc-4f5c-aa15-224031da72f6/image.png)
![](https://velog.velcdn.com/images/keumsiun0503/post/4a78f343-9ba4-46c8-9a7f-639b4d0ea124/image.png)

예제는 문제의 보기와 같은 것이 주어졌고, 경로는 다음 그림과 같다.
단순하게 생각하면 왼쪽 위 칸에서 시작하여 네 방면을 탐색하고, 숫자가 작은 곳으로 이동하면 될 것 같다.

💡**DFS(Depth-First Search)와 DP(Dynamic Programming)**
**DFS**는 깊이 우선 탐색 방식으로 한 정점에서 시작하여 인접한 정점을 탐색, 또 해당 정점에서 인접한 정점을 탐색하며 깊이를 우선으로 하는 탐색 방식.
**DP**는 큰 문제를 작은 부분 문제들로 나누어 부분 문제의 해를 이용하여 큰 부분 문제를 해결하고 이를 통해서 최종 해를 구하는 방식

1. 50(0, 0)에서 시작하여 네 방면을 순차적으로 탐색
2. 만약 현재 위치의 값(50)보다 작은 숫자가 있을 시 해당 위치로 이동
3. 1~2번 과정을 계속 반복하여 오른쪽 아래 칸 (M-1, N-1)에 도달시 하나의 경로 찾게 됨

❗중요한 점은 **조건 1**에 M, N<=500 인 자연수이므로 최대 500x500 크기의 지도가 형성될 수 있음. 그런데
500 499 498 ...
499 498 497 ...
498 497 496 ...
.   .   .
.   .   .
과 같이 경로가 수없이 많다면 일반적인 DFS 탐색 방식으로는 시간 초과가 발생할 수 있음.
⚠️**문제가 발생하는 예제 코드**
```java
static void DFS(int x, int y){
		//오른쪽 끝 위치라면 경로++, 경로 하나에 대한 탐색 종료
        if(x==M-1 && y==N-1){
            countCourse++;
            return;
        }
        for(int i=0; i<4; i++){
            int nextX = dx[i] + x;
            int nextY = dy[i] + y;
            if(nextX>=0 && nextX<M && nextY>=0 && nextY<N && (map[x][y]>map[nextX][nextY]) && !dp[nextX][nextY]){
                dp[nextX][nextY] = true;
                DFS(nextX, nextY);
            }
        }
        dp[x][y] = false;
    }   
  ```
  
  위 코드가 문제가 생기는 이유는 **이미 길이 정해진 경로를 처음부터 다시 방문하기 때문!!**
  
  ![](https://velog.velcdn.com/images/keumsiun0503/post/495ca190-f182-4a1d-8f50-16683a7b2297/image.png)
해당 그림 2개만 살펴보자.
첫 번째 경로 이후에 두 번째 경로를 탐색하게 되는데,
20 -> 17 ->15 ->10 과 같은 경로는 겹치게 되고, 위와 같은 방식이면 겹치는 경로를 또 하나씩 방문하여 경로를 찾는다.
**그런데 해당 경로는 이미 첫 번째에서 결정이 되었다.**
20부터 10까지 가는 경로는 첫 번째 탐색에 의해서 하나(또는 그 이상이 되어도 됨)라고 정해졌고,
두 번째 탐색에서는 20을 만나면 더 이상 탐색을 하지 않고, 경로를 추가해도 된다.
🤔왜 ? 20부터 10까지 가는 경로의 수는 이미 이전 탐색에서 세었으니까.

지금 같은 경우는 지도가 작기 때문에 문제가 안 될 것 같지만, 500x500크기에 
500 499 498 ...
499 498 497 ...
498 497 496 ...
.   .   .
.   .   .
이런 식으로 경로가 수없이 많아지면 경로가 정해진 길을 또 탐색하는 것은 비효율적.

🔥**문제에 적용해보기**
1. (0, 0)위치에서 시작하여 네 방면 탐색, 숫자가 낮은 곳으로 이동
2. 1번과정을 (M-1, N-1)까지 반복하고, 오른쪽 아래 도달시 return 1을 통해서 해당 경로의 모든 길(위치)에 **해당 위치에서 오른쪽 아래로 가는 길의 수** 저장
3. ❗만약 탐색 도중, 경로가 있는 길을 만난다면? 해당 위치부터는 탐색하지 않고, 해당 위치의 **오른쪽 아래로 가는 길의 수** 를 더하여 저장

말이 조금 난해할 수도 있으니, 풀이 설계와, 풀이를 통해서 확인해보기!

### 문제 풀이 설계
>
1. 지도의 크기** M, N** 입력 받기, 
지도를 저장할 2차원 배열 **map**.
각 위치에서 오른쪽으로 가는 경로의 수를 체크할 2차원 배열 **dp**.
2. map의 각 위치에 높이 저장, dp의 각 위치에 -1(경로 없음 의미)저장
3. DFS(x, y)을 통해서 x, y위치에서 오른쪽 아래를 가는 경로 탐색
3-1. **dp[x][y] = 0**(현재 탐색을 진행 중임을 의미)
3-2. 네 방면을 탐색했을 때, 숫자가 낮다면 이동.** dp[x][y] += DFS(nextX, nextY)**
3-3. 만약 오른쪽 아래 도달시 return 1; 
(**경로 1개가 추가되었다는 의미, 경로의 모든 위치에 +1 저장**)
3-4. 만약 -1이 아닌 수를 만날 시(**이미 경로가 정해진 길 발견**) return dp[x][y];
(해당 위치에서 오른쪽 아래로 가는 경로의 수를 +하여 저장)
3-5. 더 이상 모든 위치를 방문해도 길이 없을 시 return dp[x][y]**(해당 위치에서 오른쪽 아래로 가는 경로의 수)**;

```java
import java.io.*;
import java.util.*;

public class Main {
    static int M, N;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] map, dp;
    static int DFS(int x, int y){
        //3-3. 오른쪽 아래 도달시 
        if(x==M-1 && y==N-1){
            return 1;
        }
        //3-4. 이미 경로의 수가 정해진 위치 
        if(dp[x][y] != -1){
            return dp[x][y];
        }
        //3-1. 탐색 중임을 의미 
        dp[x][y] = 0;
        //3-2. 네 방면 탐색, 숫자가 낮다면 DFS탐색 이동
        for(int i=0; i<4; i++){
            int nextX = dx[i] + x;
            int nextY = dy[i] + y;
            if(nextX>=0 && nextX<M && nextY>=0 && nextY<N && (map[x][y]>map[nextX][nextY])){
                dp[x][y] += DFS(nextX, nextY);
            }
        }
        //3-5. 더 이상 길이 없을 시 해당 위치에서 오른쪽 아래로 가는 경로의 수 반환
        return dp[x][y];
    }   
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        st= new StringTokenizer(br.readLine());
        //1. M, N 입력 받기, map, dp 크기 지정
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        dp = new int[M][N];
        //2. map과 dp에 값 저장
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }
        //3. DFS 
        System.out.println(DFS(0, 0));
    }
}
```
![](https://velog.velcdn.com/images/keumsiun0503/post/39c8168e-4793-48b1-8d29-77d157936ed2/image.png)

### 느낀점
>
골드3 문제인만큼 어려웠던 것 같다. 평범하게 오른쪽 아래로 가는 경로의 수를 세는 DFS로는 시간초과가 발생한다는 것을 주의해야하는 문제이다. **이미 길이 정해진 곳은 더 이상 탐색하지 않는다**는 아이디어가 좋은 것 같고, 다른 문제에서도 분명히 쓸 일이 생길 것 같다. 많은 걸 배우게 되는 문제였다
  