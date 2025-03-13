## 문제
![](https://velog.velcdn.com/images/keumsiun0503/post/52330aa7-22b4-4eb7-9a86-377b9e995bf3/image.png)
https://www.acmicpc.net/problem/1987
### 문제 설명
>
1. 세로 R칸, 가로 C칸 표 모양의 보드가 있다.
2. 보드의 각 칸에는 대문자 알파벳이 하나씩 있고, 좌측 상단 칸에는 말이 놓여있다.
3. 말은 상하좌우 인접한 네 칸 중 한 칸으로 이동할 수있는데, 해당 칸의 알파벳으로 이동하기 위해서는 지금까지 지나온 칸에 적혀있는 알파벳과 달라야한다.(같은 알파벳 두 번 지날 수 없음)
4. 좌측 상단에서 시작해서, 말이 최대 몇 칸을 지날 수 있는지 출력
- 조건 1: 좌측 상단의 칸도 포함하여 최대 칸 수 출력
- 조건 2: 시간 제한 2초

📖**테스트 케이스 살펴보기**
![](https://velog.velcdn.com/images/keumsiun0503/post/69e0f990-ca2c-4f0f-a57c-da1117a07544/image.png)

예제 입력 1 : C -> A -> D (3칸)
예제 입력 2 : H -> A -> D -> G -> J -> F (6칸) (또는 같은 조합의 6칸)

💡**DFS(Depth-First Search)**
깊이 우선 탐색 방식은, 하나의 정점에서 시작하여 해당 정점과 인접한 정점 중 하나를 방문하고, 방문한 정점에 대해서 계속 이를 반복하며 탐색하는 방식이다.

해당 문제는 **BFS(너비 우선 탐색)**보다 **DFS**가 적절해 보이는데,
BFS는 해당 정점과 인접한 정점 모두를 방문 처리 하는데, "지나온 칸의 알파벳과 달라야 한다."는 조건 때문에 아직 이동하지 않은 알파벳을 방문 처리한 상태에서 탐색을 진행하면 이동할 수 있는 곳에서도 막힐 수 있다.

🔥**백트래킹과 HashSet**
**백트래킹** : 해를 찾는 도중 이 경우가 해가 될 수 없다고 판단되면, 돌아가서 해를 다시 찾는 기법(되추적)
>백트래킹 기법은 DFS로 구현 가능한 기법 중 하나.

**HashSet** : 자바의 컬렉션 프레임워크 중 하나로 집합(Set)을 구현한 클래스. 내부적으로 속도 측면에서 강력한 **해시테이블**을 사용!
- (하나의 타입) 객체 저장
- 중복 허용 X
- 순서 보장 X

백트래킹(DFS)과 HashSet을 활용하면 풀 수 있다.

### 문제 풀이 설계
>
1. 세로 **R**, 가로 **C** 값 입력 받음, 
최대 이동 칸 수를 저장할 **max**(코드 참고),
한 위치에서 상하좌우 위치를 방문하기 위한 **dx, dy** 배열(코드 참고)
2. 알파벳을 저장할 배열에 **board**에 알파벳을 각각 저장
3. **DFS(0, 0, 0)** (int x, int y, int count)
3-1. **HashSet**에 현재 칸 알파벳(board[x][y]) 삽입
3-2. 해당 위치에서 상하좌우 위치를 탐색. 
만약 조건에 만족한다면(배열의 범위에서 벗어나지 않으며, HashSet에 해당 값이 없을 때)
DFS(nextX, nextY, count+1)
3-3. 만약 조건에 만족하지 않는다면 HashSet에서 해당 칸 알파벳(board[x][y]) 삭제 **(백트래킹)**
3-4. 지금까지 이동한 최대 값 계산 max = Integer.max(max, count+1) 
4. **DFS가 종료되면 max값 출력**

## 문제 풀이
```java
import java.io.*;
import java.util.*;

public class Main {
    static int R, C, max = 1;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static char[][] board;
    static HashSet<Character> hashset = new HashSet<>();
    static void DFS(int x, int y, int count){
        //3-1. Hashset에 해당 알파벳 저장
        hashset.add(board[x][y]);
        //3-2. 상하좌우 위치를 탐색, 조건에 만족하는 위치는 DFS 탐색
        for(int i=0; i<4; i++){
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if(nextX>=0 && nextX<R && nextY>=0 && nextY<C && !hashset.contains(board[nextX][nextY])){
                DFS(nextX, nextY, count+1);
            }
        }
        //3-3. 조건에 만족하지 않는 다면 HashSet에서 해당 알파벳 제거(백트래킹)
        hashset.remove(board[x][y]);
        //3-4. 지금까지 이동한 칸 최대 값 저장
        max = Integer.max(max, count+1);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //1. 세로 R, 가로 C 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new char[R][C];
        //2. 알파벳을 배열 board에 저장
        for(int i=0; i<R; i++){
            board[i] = br.readLine().toCharArray();
        }
        //3. DFS 탐색 시작
        DFS(0, 0, 0);
        System.out.println(max);
    }
}
```
![](https://velog.velcdn.com/images/keumsiun0503/post/b46bb0fb-69bc-4c46-93b8-459c44726ad2/image.png)

### 느낀점
>
처음 문제를 풀 때, HashSet이 아니라 불필요하게 Stack 자료구조를 사용하여 시간초과가 나서 고민했다. 문제의 조건과 상황에 따라 자료구조를 잘 선택하는 능력을 길러야겠다.  
해시테이블을 내부적으로 사용하는 클래스들은 속도가 빠르기 때문에 사용 가능하다면 해시테이블을 사용해야한다. 문제를 다시 풀면서 메모리도 줄여보고, 많은 것을 배워가는 문제였다.