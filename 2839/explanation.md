## 문제

![](https://velog.velcdn.com/images/keumsiun0503/post/09b0d537-855d-4248-8401-bf1a2ef62160/image.png)
https://www.acmicpc.net/problem/2839

### 문제 설명
>
1. 설탕을 정확하게 **N킬로그램 배달**하는데, 사용할 수 있는 **봉지는 3kg, 5kg**가 있다.
2. **최대한 적게 봉지를 들고 가려고** 하는데, 만약 18kg 배달해야 한다면 3kg 봉지로 6개를 가져가도 되지만, 5kg 봉지 3개, 3kg 봉지 1개 하여 총 4개를 가져간다면 더 적은 수의 봉지로 배달할 수 있다.
3. N이 주어졌을 때, 봉지를 최소로하여 몇 개 가져가면 되는지 출력. 만약 정확하게 N킬로그램을 만들 수 없다면 -1 출력.

💡그리디
그리디는 각 단계마다 지역 최적해를 찾는 방식.
각 단계마다 최대한 **욕심내어** 취할 수 있는 만큼 값을 취하고, 
각 단계의 해를 모아 **최적 해의 근사 값**을 구함.

문제를 예로 생각해보자
봉지를 최대한 적게 들고 간다 == 5kg 봉지(또는 더 무거운 무게를 담을 수 있는 봉지)를 최대한 많이 활용한다는 의미

💭그렇다면 풀이 방식은 이렇게 생각할 수 있다.
1. N이 주어졌을 때 5kg 봉지를 최대한 활용한다.
2. 5kg 봉지를 최대한 활용하고 남는 무게가 있다면 3kg 봉지를 활용
3. 만약 5kg 봉지를 최대한 활용하고, 3kg 봉지를 활용할 수 없다면(3으로 나누어 떨어지지 않음), 5kg 봉지의 개수를 하나 줄임.
4-1. 3번 과정을 반복하여 가장 먼저 2번 과정이 성립 될 때, 결과 값은 (5kg 봉지의 개수 + 3kg 봉지의 개수)
4-2. 만약 3번 과정을 끝까지 반복해도 3kg 봉지를 활용할 수 없다면, 결과 값은 -1

📖테스트 케이스에 적용해보자.
![](https://velog.velcdn.com/images/keumsiun0503/post/0a1ca9bf-6c0a-4d10-b04a-fe91b9ace2e1/image.png)


1. 18kg이 주어졌을 때 5kg 봉지를 최대한 활용하기 위해서는 18kg/5kg를 하여 나온 정수값 **3**부터 활용하면 된다.
2. 5kg 봉지를 최대한 활용, 18kg-(5kg***3**) = 3kg
3. 3kg 봉지는 **한 개** 활용 가능 따라서 결과 값은 **3 + 1 = 4**

![](https://velog.velcdn.com/images/keumsiun0503/post/8c1c532b-75b7-4184-bf3e-9c6126b84b8c/image.png)
1. 11kg이 주어졌을 때 5kg 봉지를 최대한 활용, 11kg/5kg = 정수값 **2**
2. 5kg 봉지를 최대한 활용, 11-(5kg***2**) = **1kg**
3. 5kg 봉지를 최대한 활용하고, 3kg 봉지를 활용할 수 없다면(**1**은 3으로 나누어 떨어지지 않음) 5kg 봉지의 개수를 하나 줄임
4. 5kg 봉지를 최대한 활용, 11-(5kg***1**) = **6kg**
5. 3kg 봉지 **두 개** 활용 가능 따라서 결과 값은 **1 + 2 = 3**

### 문제 풀이 설계
>
1. 배달해야 할 설탕 무게 N을 입력 받음 
2. N에 대하여 5kg 봉지의 무게를 최대(최대 값을 저장할 변수 greedy)에서 
하나씩 줄여가며(0까지) 최대한 많이 활용하기(봉지의 개수를 셀 변수 count)
3. 5kg 봉지를 최대한 활용하고, 남는 무게를 3kg 봉지를 활용하여 들 수 있다면, 결과 값 count = (5kg 봉지 개수 + 3kg 봉지 개수)
4. 만약 3kg 봉지를 활용할 수 없다면(3으로 나누어 떨어지지 않음) 5kg 봉지 개수 - 1 반복
5. 만약 위 과정을 거쳤을 때 
**count 값이 0이 아니라면 count값 출력**, 
**0이라면(5kg, 3kg 봉지 모두 활용 불가능) -1 출력**

## 문제 풀이

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int caculate(int N){
        //2. 5kg을 최대한 활용할 수 있는 최대값 greedy, 봉지의 개수를 셀 count
        int greedy = N/5;
        int count = 0;
        //2. 5kg 봉지(greedy)를 하나씩 줄여가며(0까지) 최대한 많이 활용하기
        for(int i=greedy; i>=0; i--){
            int weight = N;
            weight-=i*5;
            //3, 4. 5kg 봉지를 활용하고 남는 무게를 3kg 봉지로 들 수 있다면 count값 저장, 그렇지 않다면 반복
            if(weight%3==0){
                count = i + weight/3;
                break;
            }
        }
        //5. count값이 있다면 count 값 출력, 없다면(5kg, 3kg 봉지로 딱 나누어 떨어지지 않음) -1 출력
        return count!=0 ? count : -1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //1. 배달할 설탕 무게 N 입력 받기
        int N = Integer.parseInt(br.readLine());

        System.out.println(caculate(N));
    }
}
```
![](https://velog.velcdn.com/images/keumsiun0503/post/f5a09f61-eda8-415d-a398-12498302141c/image.png)
### 느낀점
>
실버4 문제인데, 생각보다 구현이 까다로워서 놀랬던 문제다. 아마 그리디 문제에 대한 연습 부족때문인 것 같다. 기본적인 그리디 문제(동전 거스름돈, 배낭 문제 등)를 풀어본 사람한테 추천하고 싶은 문제이다. 나도 다양한 그리디 문제를 많이 풀어 보면서 기초를 탄탄하게 다져야 할 것 같다.