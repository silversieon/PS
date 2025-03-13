## 문제

![](https://velog.velcdn.com/images/keumsiun0503/post/d8dd42a8-bba8-4f37-b19b-197a8f9125a5/image.png)
https://www.acmicpc.net/problem/1446

### 문제 설명
>
1. D킬로미터 길이의 고속 도로를 지나가야 한다.
2. 고속도로에는 지름길이 존재하는데, 모든 지름길은 일방통행이고, 고속도로를 역주행할 수는 없다.
3. 지름길이 주어지면 세준이가 운전해야하는 거리의 최솟값을 출력하시오.

![](https://velog.velcdn.com/images/keumsiun0503/post/e66288d7-51f4-4821-9a02-55437acf2d95/image.png)

첫째 줄에는 지름길의 개수 N과 고속도로의 길이 D가 주어진다.
둘째 줄부터 지름길이 한 줄씩 주어지는데, 
지름길의 시작 위치, 지름길의 끝 위치, 지름길을 이동하는데 걸리는 거리 순으로 주어진다.

💡**DP(Dynamic Programming) 동적 계획 기법**
예제 입력1을 보면, 
같은 위치에서 시작하고 같은 위치에서 끝나는 지름길(0 50)도 있고, 
거리상으로 손해를 보는 지름길도 있다.(110 140 90은 30의 거리를 90만큼 가야하므로 손해)
따라서 각 지름길에 대해서 해당 지름길을 고려했을 때 나올 수 있는 최소 거리값을 동적으로 늘려가며 계산해줘야 한다.
🔥여기서 중요한 점은 **모든 지름길은 일방 통행이고, 고속도로를 역주행할 수는 없다**라는 조건이다. 따라서 각 지름길을 고려할 때, **시작 위치를 기준으로 오름차순 정렬**이 필요하다.

### 문제 풀이 설계
>
1. 지름길의 개수 N, 고속도로의 길이 D를 입력 받음
2. 지름길을 저장할 2차원 배열 **shortCut** 정의 및 값 할당
*idx* 0 : 지름길의 시작 위치
*idx* 1 : 지름길의 끝 위치
*idx* 2 : 지름길의 거리
3. 지름길을 **시작 위치를 기준으로 오름차순 정렬**
4. 각 지름길을 고려할 때, 해당 위치 값에서의 총 이동 거리값을 저장할 **dp배열** 정의
(dp[0][k] 값은 아무 지름길도 고려하지 않을 때, k위치 값에서 총 이동거리)
5. 2중 반복문을 통해서 i=1~N(지름길들), k=0~D까지 dp[i][k] 값 구하기
5-1. 만약 k가 현재 고려하는 지름길의 도착위치보다 크다면, 
**dp[i][k] = Math.min(dp[i-1][k], 지름길을 이용했을 때의 이동 거리)**
5-2. 그렇지 않다면 
**dp[i][k] = Math.min(dp[i-1][k], k)**
6. **dp[N][D]**(모든 지름길을 고려했을 때, 위치 값 D까지의 최소 이동 거리) **출력**

## 문제 풀이
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        //1. 지름길의 개수 N, 고속도로의 길이 D
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        //2. 지름길을 저장할 배열 (idx 0: 지름길 시작 위치, idx 1: 지름길 끝 위치, idx 2: 지름길 거리)
        int[][] shortCut = new int[N+1][3];
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            shortCut[i][0] = Integer.parseInt(st.nextToken());
            shortCut[i][1] = Integer.parseInt(st.nextToken());
            shortCut[i][2] = Integer.parseInt(st.nextToken());
        }
        //3. 지름길을 시작 위치를 기준으로 오름차순 정렬 (1~N+1 인덱스까지 0번 인덱스를 기준으로 오름차순)
        Arrays.sort(shortCut, 1, N+1, Comparator.comparingInt(a->a[0]));
        //4. 각 지름길에 대한, 해당 위치값 k에서의 총 이동 거리값 저장 배열 dp
        int[][] dp = new int[N+1][D+1];
        //4. dp[0]은 아무 지름길도 고려하지 않았을 때 k위치에서 총 이동 거리값(k)
        for(int k=0; k<=D; k++){
            dp[0][k] = k;
        }
        //5. 각 지름길을 순차적으로 고려하며, 위치값 k에서의 총 이동거리 값 저장
        for(int i=1; i<=N; i++){
            int start = shortCut[i][0];
            int end = shortCut[i][1];
            for(int k=0; k<=D; k++){
                //5-1 지름길을 이용한 거리(k>=지름길 끝 위치)까지 왔을 때, 이전 dp값과 현재 지름길을 이용했을 때의 거리를 비교하여 최소값을 저장
                if(k>=end){
                    dp[i][k] = Math.min(dp[i-1][k], dp[i][start] + shortCut[i][2] + (k - end));
                } else {
                    dp [i][k] = Math.min(dp[i-1][k], k);
                }
            }
        }
        //6. 모든 지름길을 고려했을 때, 위치 값 D에서의 최소 이동 거리
        System.out.println(dp[N][D]);
    }
}
```
![](https://velog.velcdn.com/images/keumsiun0503/post/e9b4a025-3f91-44d2-9d7e-329adb8363c2/image.png)
### 느낀점
>
고속도로를 역주행 할 수 없다는 조건의 이유를 제대로 파악하지 못 하고, 입력 받은 순서대로 지름길을 고려하다가 시간을 많이 날린 문제다. 문제가 주어졌을 때 각 조건을 제대로 파악하고, 조건을 그렇게 준 이유가 무엇인지 생각하는 습관을 들일 필요가 있다. 또한 자바에서 기본적으로 제공하는 Arrays 클래스의 다양한 메소드들을 꾸준히 공부해야겠다.