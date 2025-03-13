## 문제
![](https://velog.velcdn.com/images/keumsiun0503/post/9a75e4fd-ea48-4cd3-bbd2-f3695211454f/image.png)
https://www.acmicpc.net/problem/16401
### 문제 설명
>
1. M명의 조카에게 막대 과자를 나눠 주려고 한다.
2. 최대한 긴 과자를 나눠주려고 하는데, 나눠준 과자의 길이가 모두 같아야 한다.
3. N개의 과자가 각 길이별로 있을 때, 조카 1명에게 줄 수 있는 막대 과자의 최대 길이를 출력
- 조건 1: 막대 과자는 길이와 상관없이 여러 조각으로 나눌 수 있음
- 조건 2: 나눈 과자를 합칠 수는 없다.
- 조건 3: 조카에게 같은 길이의 과자를 나눠줄 수 없다면 0을 출력

📖테스트 케이스 살펴보기
![](https://velog.velcdn.com/images/keumsiun0503/post/62cfaaf2-75b0-460b-ba9d-33b376d648d6/image.png)

- 예제 입력1에서 조카 3명에게 막대 과자를 나눠 줘야하므로, 8 길이의 막대 과자 3개 (9, 10을 나누어)를 나눠주는 것이 최대 길이이다.
- 예제 입력2에서 조카 4명에게 막대 과자를 나눠 줘야하므로, 7 길이의 막대 과자 4개 (10에서 한 개씩, 15에서 두 개)를 나눠주는 것이 최대 길이이다.

그렇다면 조카의 수와 과자들의 길이가 주어졌을 때, 똑같이 나눠줄 수 있는 과자 길이의 최대값을 어떻게 구할 수 있을까?

💡**이분 탐색(Binary Search)**
이분 탐색은 **정렬된 배열**에서 특정 값을 찾는 탐색 방식이다.
1. 배열의 중앙값을 검사하여 **특정 조건에 만족**하는지 확인한다.
2. 조건 만족 여부에 따라 다음에 검사할 배열의 크기가 1/2로 줄어든다.
3. 시간 복잡도는 **O(logN)**으로 배열 전체를 탐색하는 O(N)보다 효율적이다.
이분 탐색에서 탐색할 수들은 모두 F(false)와 T(true)로 구분된다.
예제를 통해서 살펴보자.

- 0, 1, 2, 3, 4, 5, 6, 7, 8과 같은 배열이 있고, 이분 탐색을 통해서 **6**을 찾으려고 한다.
- 조건을 **"탐색된 수가 6이상인가?"**로 둔다면 각 숫자들은 F, F, F, F, F, F, T, T, T와 같이 구분될 수 있다.
- 만약 **탐색된 수가 F**에 해당한다면, 해당 수를 기준으로 오른쪽에 있는 배열(T가 속해있을)을 탐색해야 한다.
- 만약 **탐색된 수가 T**에 해당한다면, 해당 수를 기준으로 왼쪽에 있는 배열을 탐색하여 **조건에 만족하면서 탐색하려는 수인 6**에 근접하도록 오차 범위를 줄여나가야 한다.

🔥**예제에 적용해보자**
각 과자들을 특정 길이로 나누면, 특정 길이의 과자가 몇 개 나오는지 알 수 있다.
예를 들어, 1, 7, 9 길이의 과자가 있다고 가정하면
- 3길이의 과자로 나누고 싶을때, 1/3 = **0**, 7/3 = **2**, 9/3 = **3** 을 통해서 총 5개의 길이 3인 과자를 얻을 수 있다.
- 7길이의 과자로 나누고 싶을 때, 1/7 = **0**, 7/7 = **1**, 9/7 = **1** 을통해서 총 2개의 길이 7인 과자를 얻을 수 있다.

그런데 우리는 정확히 조카 M명에게 과자를 나눠줘야 하므로 조건을 다음과 같이 세울 수 있다.
**"해당 길이로 과자를 나누었을 때 나오는 과자의 수가 조카의 수 M보다 크거나 같은가?"**
- 만약 과자의 수<조카의 수라면 최대값보다 긴 길이로 과자를 나누어 과자의 수가 부족한 것이므로 길이를 줄여서 나누어 준다.
- 만약 과자의 수>=조카의 수라면 최대값보다 짧은 길이로 과자를 나누어 과자의 수가 많은 것이므로 길이를 늘려서 나누어 준다.

### 문제 풀이 설계
>
1. 조카의 수 M, 과자의 수 N 입력 받기
2. 과자들의 길이를 snacks 배열에 저장(가장 긴 과자 길이 max 체크)
3. 이분 탐색을 통해서 똑같은 길이로 나누어 줄 수 있는 과자 길이 최대값 구하기
(lo = 0, hi = max, mid = (lo+hi)/2 에서 시작)
4. **"해당 길이로 과자를 나누었을 때, 나오는 과자의 수가 조카의 수 M보다 크거나 같은가?"** 조건을 확인할 함수 Check
4-1. 만약 Check(mid) == true라면 과자의 길이를 현재 탐색 값보다 늘려 나누기 위해서 
lo = mid
4-2. 만약 Check(mid) == false라면 과자의 길이를 현재 탐색 값보다 줄여 나누기 위해서
hi = mid
5. 이분 탐색이 끝나면 lo, hi는 F와 T의 경계선에 놓이게 되는데,  최종적으로
return Check(hi) ? hi : lo 를 통해 조건을 검사하여 만족하는 값을 출력

## 문제 풀이
```java
import java.io.*;
import java.util.*;

public class Main {
    static int M, N, max=0;
    static int[] snacks;
    static boolean Check(int mid){
        //4. 과자들을 특정 값으로 나누어 나오는 총 과자의 수 구하기
        int numOfpiece = 0;
        for(int snack : snacks){
            numOfpiece += snack/mid;
        }
        //4. 총 과자의 수가 많다면 T(과자 길이 늘리기), 그렇지 않다면 F(과자 길이 줄이기)
        return numOfpiece>=M;
    }
    static int caculateMaxlength(){
        int lo = 0;
        int hi = max;
        while(lo+1<hi){
            int mid = (lo + hi)/2;
            //4. 조건 만족 여부에 따른 탐색 범위 재설정
            if(Check(mid)){
                lo = mid;
            } else {
                hi = mid;
            }
        }
        //5. 최종적으로 hi, lo중 만족하는 값을 반환
        return Check(hi) ? hi : lo;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        //1. 조카의 수 M, 과자의 수 N
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        snacks = new int[N];
        //2. 과자들의 길이 저장(가장 긴 길이 max 체크)
        st=new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            snacks[i] = Integer.parseInt(st.nextToken());
            max = Integer.max(max, snacks[i]);
        }
        //3. 이분 탐색을 통한 최대 과자 길이 반환 받아 출력
        System.out.println(caculateMaxlength());
    }
}
```
![](https://velog.velcdn.com/images/keumsiun0503/post/bef040ae-7331-42f4-baa7-8caa70598b59/image.png)
### 느낀점
>
이분 탐색은 시간 복잡도가 낮기 때문에 여러 탐색 문제에서 활용하면 효과를 볼 수 있다. 사용 방식을 익히고 다양한 문제에 적용해보는 것이 매우 중요할 것 같다.