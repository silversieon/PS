## 문제
![](https://velog.velcdn.com/images/keumsiun0503/post/8a26cf9a-d505-43f2-98e3-029e4fae2c74/image.png)
https://www.acmicpc.net/problem/1149

### 문제 설명
>
1. RGB거리에는 집이 N개 있고, 1번~N번까지 집이 1열로 순서대로 있음.
2. 집은 빨강, 초록, 파랑 중 하나의 색으로 칠해야함.
3. 각 집은 양 옆의 집의 색과 같지 않아야 함(1번과 N번은 각각 2번, N-1번과 같지 않아야함)
4. 집의 수 N과, 각 집을 빨, 초, 파로 칠하는 비용이 주어졌을 때 모든 집을 칠하는 비용의 최솟값 출력

📖**테스트 케이스 살펴보기**
![](https://velog.velcdn.com/images/keumsiun0503/post/5ae67346-df67-410f-93a4-7379ba7bd214/image.png)

예제 입력 1번에서, 26 40 83은 1번 집을 칠할 때, 빨, 초, 파 각각의 비용을 의미
**26** 40 83
49 60 **57**
**13** 89 99
순으로 빨 파 빨로 칠하면 최소 비용이 된다.
예제 입력 2번은 빨 -> 초 -> 파

💡**DP(Dynamic Programming)**
DP 알고리즘은 큰 문제를 부분 문제로 나누어 각 부분 문제의 지역해를 찾고, 이를 활용하여 큰 문제를 해결하는 알고리즘이다.

전체 집을 칠하는 비용의 최솟값(큰 문제)
각 집 하나씩 칠하는 비용의 최솟값(작은 문제)
1번 집부터 최소가 되게 집을 칠하며, 이를 활용하여 다음 집을 칠하면 된다.

🔥**문제에 적용해보기**
각 집은 **양 옆의 집**과 색이 다르면 된다. 
따라서 1번 집부터 시작하여 이전 집의 다른 두 색깔 중 최솟값을 더하는 식으로 내려가면 된다.
**(0번 집의 빨, 초, 파 가격은 모두 0으로 설정)**

예를 들어 2번 집에 **빨간색을 칠한다고 가정하면**, 이전 집의 초록색, 파란색으로 칠한 비용 중 최솟값을 더하면 될 것이다. **초록색을 칠한다고 가정하면**, 이전 집의 빨간색, 파란색으로 칠한 비용 중 최솟값을 더하면 될 것이다. **파란색도 마찬가지**

이런 식으로 계산하여 **N번째**집의 각 색을 칠하는 비용 중 최솟값을 출력하면 되는 것이다.

### 문제 풀이 설계
>
1. 집의 수 **N** 입력 받기
2. 집을 RGB로 칠하는 비용의 최솟값을 저장할 **houses** 2차원 배열
3. 1~N번째 집까지 비용을 입력 받음과 동시에 이전 집의 다른 두 색깔을 더하며 최소 비용을 만들어 나감
4. N번째 집의 RGB 중 최소 비용을 출력

## 문제 풀이
```java
import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] houses;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //1. 집의 수 N
        N = Integer.parseInt(br.readLine());
        //2. RGB 최소 비용 저장할 변수
        houses = new int[N+1][3];
        //3. 1~N까지 비용 입력 받음과 동시에 이전 집의 다른 두 색깔 중 최소 비용을 더함으로써 최소 비용 계속 저장
        for(int i=1; i<=N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            houses[i][0] = Integer.parseInt(st.nextToken()) + Math.min(houses[i-1][1], houses[i-1][2]);
            houses[i][1] = Integer.parseInt(st.nextToken()) + Math.min(houses[i-1][0], houses[i-1][2]);
            houses[i][2] = Integer.parseInt(st.nextToken()) + Math.min(houses[i-1][0], houses[i-1][1]);
        }
        //4. N번째 집의 RGB 중 최소 비용 출력
        int result  = Math.min(houses[N][0], (Math.min(houses[N][1], houses[N][2])));
        System.out.println(result);
    }
}
```
![](https://velog.velcdn.com/images/keumsiun0503/post/d5da2951-8e27-4fab-bd81-cb5a33465cd1/image.png)
### 느낀점
>
난이도가 쉬운 DP 문제 중 하나라고 생각한다. 실버1 치고는 코드가 간결하게 떨어진다. 골드 4단계인 RGB 2도 고민해봤는데, 상당히 어려워 보였다. 꼭 풀어봐야겠다.

