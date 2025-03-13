## 문제
![](https://velog.velcdn.com/images/keumsiun0503/post/425a3014-f144-46e2-a2e0-ef3326d7eedf/image.png)
https://www.acmicpc.net/problem/1744

### 문제 설명
>
1. 각 숫자가 정수인 수열이 주어졌을 때, 수들을 더하는데, 두 수를 묶거나, 묶지 않고 더할 수 있음
2. 묶는다는 것은 숫자 두 개를 곱하는 것을 의미함
3. 예를 들어 수열 0, 1, 2, 4, 3, 5가 주어지면 2와 3을 묶고, 4와 5를 묶어서 0+1+(2x3)+(4x5) = 27이 되어 최대가 됨
4. 수를 합이 최대가 나오게 묶었을 때 합 출력
- 조건 1: 모든 수는 한 번만 묶거나, 묶지 않아야 한다.
- 조건 2: 정답은 항상 2^31보다 작다.

📖**테스트 케이스 살펴보기**
![](https://velog.velcdn.com/images/keumsiun0503/post/63047151-5c74-4053-ba0f-ca6f9e33eaa4/image.png)

- 예제 입력 1
(3x2) + 1 + (-1) = 6
- 예제 입력 2
(5x4) + (3x2) + 1 + 0 = 27

두 케이스를 살펴보면 가장 큰 수끼리는 곱하고, 남는 수들은 더해주는 게 최대값을 찾는 방식임을 알 수 있다. 
🤔그렇다면 큰 수끼리 뽑아서 곱해주면 되는 것일까?
![](https://velog.velcdn.com/images/keumsiun0503/post/4f850c05-7fde-4e9b-b10d-e60e3f44ad4b/image.png)

- 예제 입력 4
1+(0x-1) = 1

해당 케이스를 보면 큰 수인 1과 0을 곱하면 안 된다는 것을 알 수 있고, 또한 음수가 여러개(-5, -4, ... )등과 같이 나오면 음수는 작은 것끼리 곱해야 최대가 됨을 알 수 있다.

💡**그리디와 우선순위큐**
따라서 각 단계별 최적해를 모아 최종 해의 근사값을 찾는 **그리디** 알고리즘과
자료에 우선순위를 매겨 우선순위별로 자료를 내보내는 **우선순위큐**를 사용하여 문제를 해결 할 수 있다.

🔥**문제에 적용해보기**
양수, 음수를 나누어 계산해야함을 알 수 있다.
양수는 숫자가 큰 순서대로 2개씩 뽑아 곱하고
음수는 숫자가 작은 순서대로 2개씩 뽑아 곱하는 과정이 필요하다.
만약 숫자가 하나 남는다면, 해당 숫자를 더해주면 된다.

### 문제 풀이 설계
>
1. 수열의 크기 **N** 입력 받기, 최대 결과값 **maxResult**
2. 수열의 각 숫자를 입력 받는데, 양수와 음수를 구분하여 서로 다른 우선순위큐에 저장(양수는 큰 순서대로 자료가 나오는, 음수는 작은 순서대로 자료가 나오는)
3. 양수의 경우 가장 큰 숫자 2개를 뽑아 더한 값과 곱한 값 중 큰 값을 를 비교하는 과정이 필요(2와 1이 있을 경우 2+1>2*1 이기 때문)
3-1. 만약 숫자가 하나 남는다면, 해당 숫자를 결과값에 더해줌
4. 음수의 경우 가장 작은 숫자 2개를 뽑아 곱하기만 함
4-1. 만약 숫자가 하나 남는다면, 해당 숫자를 결과값에 더해줌
5. 최대 결과값 출력

## 문제 풀이
```java
import java.io.*;
import java.util.*;

public class Main {
    //1. 최대 결과값 maxResult
    static int maxResult = 0;
    static PriorityQueue<Integer> positivePQ = new PriorityQueue<>(Collections.reverseOrder());
    static PriorityQueue<Integer> negativePQ = new PriorityQueue<>();
    //3. 양수는 합과 곱의 크기 비교 필요(2+1>2*1)
    static void calculatePositive(){
        while(positivePQ.size()>=2){
            int num1 = positivePQ.poll();
            int num2 = positivePQ.poll();
            maxResult += Math.max(num1 * num2, num1 + num2);
        }
        if(!positivePQ.isEmpty()){
            maxResult+=positivePQ.poll();
        }
    }
    //4. 음수는 곱만 구해주면 됨
    static void calculateNegative(){ 
        while(negativePQ.size()>=2){
            maxResult += negativePQ.poll() * negativePQ.poll();
        }
        if(!negativePQ.isEmpty()){
            maxResult += negativePQ.poll();
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //1. 수열의 크기 N
        int N = Integer.parseInt(br.readLine());
        //2. 수열의 각 수 양수, 음수 나누어 우선순위큐에 저장
        while(N-->0){
            int num = Integer.parseInt(br.readLine());
            if(num>0){
                positivePQ.add(num);
            } else {
                negativePQ.add(num);
            }
        }
        calculatePositive();
        calculateNegative();
        System.out.println(maxResult);
    }
}
```
![](https://velog.velcdn.com/images/keumsiun0503/post/044048ba-81b9-4760-b68d-cb5a3071af96/image.png)

### 느낀점
>
골드 4 문제 치고 쉬운편의 문제였다. 우선순위큐를 사용할 줄 알고, 테스트케이스만 머릿속으로 굴려보면 정답이 쉽게 나온다. 다른 사람들이 푼 걸 보면 리스트를 쓰고 정렬을 하기도 하는데, 로직은 같다.