## 문제
![](https://velog.velcdn.com/images/keumsiun0503/post/fc9aa449-a313-43c8-bab3-b2def60227bf/image.png)
https://www.acmicpc.net/problem/2096

### 문제 설명
>
1. N개의 줄에 0 이상 9 이하의 숫자가 세 개씩 적혀있다.
2. 내려가기 게임을 하는데, 첫 줄에서 시작해서 마지막 줄에서 끝난다.
3. 첫 줄에 적혀있는 세 개의 숫자 중 하나를 골라서 시작하고, 다음 줄로 내려간다.
4. 다음 줄로 내려갈 때는 바로 아래의 수 또는 바로 아래의 수와 붙어 있는 수로만 이동할 수 있다. (그림 속에서 ☆의 위체에서 내려갈 수 있는 위치는 O, 내려갈 수 없는 위치는 X)
5. 숫자 표가 주어졌을 때, 얻을 수 있는 최대 점수, 최소 점수를 출력
- 조건 1: 줄의 수 N<= 100,000
- 조건 2: 숫자는 0~9

📖테스트 케이스 살펴보기
![](https://velog.velcdn.com/images/keumsiun0503/post/03e7c527-a4a0-4b07-9f64-26c38c8c3d6a/image.png)

예제 입력 1번의 최대, 최소 점수가 나온 과정을 살펴보자.
최대 점수 3->6->9 = 18
최소 점수 1->5->0 = 6

🤔그렇다면 가장 큰 값, 가장 작은 값만 구해서 내려가면 되는 게 아닐까?
하지만 최소 점수를 구하는 과정을 살펴 보면, 
1에서 내려갈 때, 가장 작은 값인 4를 선택하면, 다음 경우에서 0을 선택할 수 없으므로 위와 같은 풀이는 알맞지 않다.
결국 다음과 같은 알고리즘이 필요하다

💡**DP(Dynamic Programming)**
동적 계획 기법(DP)이란 각 지역해의 값을 이전 지역해의 값을 참고하며
동적으로 할당하는 알고리즘 기법을 얘기한다.

최대, 최소의 경우를 구할 때, 그냥 최대, 최소값만 골라 더하는 것이 아닌, 
이전의 값을 최소가 되도록 더해주고, 이를 활용하여 다음 구간에서도 최소가 되도록 더해주는 방식을 반복하여 해당 구간에서 최소가 될 수 있도록 계속 값을 할당해주는 것이다.

🔥예제에 적용하여 이해해보자
각 위치에서 최대, 최소값을 저장할 dp 2차원 배열을 하나 만들어주는 것이 필요하다.
최대가 되는 과정만 살펴보자(최소도 원리는 같음)
수 배열 nums
1 2 3
4 5 6
4 9 0
(dp[0]의 0, 1, 2 인덱스 위치의 값은 0으로 두고 시작한다.)
i= 1~N까지 반복
dp[i][0] = dp[i-1]**[0]** + nums[i][0], dp[i-1]**[1]** + nums[i][0] 중 큰 값
dp[i][1] = dp[i-1]**[1]** + nums[i][1], dp[i-1]**[0]** + nums[i][1], dp[i-1]**[2]** + nums[i][1] 중 큰 값
dp[i][2] = dp[i-1]**[2]** + nums[i][2], dp[i-1]**[1]** + nums[i][2] 중 큰 값
(왜 이렇게 구해지는지는 현재 위치에서 **내려갈 때의 조건**을 이해했다면 알 수 있다.)
따라서 최종적으로 dp 배열의 값은 이렇게 나타난다.
0 0 0
1 2 3
6 8 9
12 18 9
따라서 N번째 줄에서 가장 큰 수가 최대 점수가 되는 것이다. (최소도 다음과 같은 방식으로 작은 값들을 dp배열에 저장하며 구할 수 있음)

### 문제 풀이 설계
>
1. 숫자 표의 행의 개수 N을 입력 받음
2. 숫자를 저장할 nums 배열의 0, 1, 2번 인덱스에 숫자를 입력 받음
3. dp배열에 다음과 같은 조건으로 현재 위치에서의 최대, 최소값을 저장하고 출력
4. i = 1 ~ N까지
dp[i][0] = dp[i-1]**[0]** + nums[i][0], dp[i-1]**[1]** + nums[i][0] 중 최대(최소) 값
dp[i][1] = dp[i-1]**[1]** + nums[i][1], dp[i-1]**[0]** + nums[i][1], dp[i-1]**[2]** + nums[i][1] 중 최대(최소) 값
dp[i][2] = dp[i-1]**[2]** + nums[i][2], dp[i-1]**[1]** + nums[i][2] 중 최대(최소) 값
5. dp배열 마지막 줄(N)에서 최대(최소)값을 반환 받아 출력

## 문제 풀이
```java
import java.io.*;
import java.util.*;
public class Main {
    static int N;
    static int[][] nums, dp;
    static int calculateMaxScore(){
        for(int i=1; i<=N; i++){
            dp[i][0] = Integer.max(dp[i-1][0] + nums[i][0], dp[i-1][1] + nums[i][0]);
            dp[i][1] = Integer.max(dp[i-1][1] + nums[i][1], Integer.max(dp[i-1][0] + nums[i][1], dp[i-1][2] + nums[i][1]));
            dp[i][2] = Integer.max(dp[i-1][2] + nums[i][2], dp[i-1][1] + nums[i][2]);
        }
        int max = -1;
        for(int numOflastline : dp[N]){
            max = Integer.max(max, numOflastline);
        }
        return max;
    }
    static int calculateMinScore(){
        for(int i=1; i<=N; i++){
            dp[i][0] = Integer.min(dp[i-1][0] + nums[i][0], dp[i-1][1] + nums[i][0]);
            dp[i][1] = Integer.min(dp[i-1][1] + nums[i][1], Integer.min(dp[i-1][0] + nums[i][1], dp[i-1][2] + nums[i][1]));
            dp[i][2] = Integer.min(dp[i-1][2] + nums[i][2], dp[i-1][1] + nums[i][2]);
        }
        // 숫자의 최대값은 9이고, N<=100,000이므로 최대 값 900,000
        int min = 900001;
        for(int numOflastline : dp[N]){
            min = Integer.min(min, numOflastline);
        }
        return min;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //1. 숫자표 행의 개수 N
        N = Integer.parseInt(br.readLine());
        nums = new int[N+1][3];
        StringTokenizer st;
        //2. nums 배열의 0, 1, 2번 위치에 숫자 입력 받기 (숫자표)
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            nums[i][0] = Integer.parseInt(st.nextToken());
            nums[i][1] = Integer.parseInt(st.nextToken());
            nums[i][2] = Integer.parseInt(st.nextToken());
        }
        //3. dp배열에 현재 위치에서 최대(최소) 값을 저장하며 최종적인 해 도출
        dp = new int[N+1][3];
        System.out.println(calculateMaxScore() + " " + calculateMinScore());
    }
}
```
![](https://velog.velcdn.com/images/keumsiun0503/post/9228d7fc-c47b-426a-9f2f-febe94fde64a/image.png)
### 느낀점
>
DP를 이해하는 데에 좋은 문제라고 생각한다. 메모리 제한을 까다롭게 두어서 신경써서 풀어야 하는 문제이다. 알고 있는 풀이 방식이어도 자주 풀면서 잊지 않으려고 노력해야겠다.