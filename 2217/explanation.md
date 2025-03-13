## 문제

![](https://velog.velcdn.com/images/keumsiun0503/post/9077ab43-3f49-4aed-9b7a-34dfb4f0e538/image.png)
https://www.acmicpc.net/problem/2217

### 문제 설명
>
1. N개의 로프가 있고, 각각의 로프들은 입력되는 숫자만큼 **들 수 있는 중량이 다름**
2. 하지만 여러 개의 로프를 병렬로 연결하면 각각의 로프에는 고르게 중량이 걸림
3. 예를 들어 중량이 20인 물체를 두 개의 로프로 들어올리면 중량이 20/2 =10으로 양쪽 로프 모두 10만큼의 중량이 걸리게 됨
4. 각 로프들이 들 수 있는 중량에 대한 정보가 주어졌을 때, 로프들로 들어올릴 수 있는 최대 중량을 출력. (**단 모든 로프를 사용해야 할 필요는 없음**)

![](https://velog.velcdn.com/images/keumsiun0503/post/efb37486-51de-487b-9e43-e77b82ee0f69/image.png)
예제 입력을 보면, 로프가 2개 있고 각각의 로프는 10, 15만큼의 중량을 들 수 있다. 
예제 출력을 보면 당연하게 알 수 있듯이 중량이 20이라면, 로프가 2개이므로 20/2 = 10으로 양쪽 로프에 10만큼의 중량이 걸리게 되고, 두 로프 모두 10만큼의 중량을 들 수 있으므로 10x2= 20이 정답이 된다. 그렇다면 **로프 중 최솟값에 로프의 수를 곱한 게** 정답이 되는 게 아닐까?
먼저 예제 입력에 40짜리 로프를 추가해보았다. 그렇다면 로프는 3개가 되고, 각 로프가 들 수 있는 무게는 10, 15, 40이 된다. **하지만 이 예에서는 정답이 40일테고(모든 로프를 사용해야할 필요 없음) 10x3이 정답이 아니다.**
여기서 💡아이디어를 떠올릴 수 있었는데, 로프를 중량순으로 내림차순 정렬한 다음, 중량이 높은 로프부터 하나씩 추가해서 사용한다고 가정하고 그 때 들 수 있는 무게를 저장하는 것이다.
위 예에서는 
1. 40을 하나 사용하면 40의 무게를 들 수 있다.(40, 40)
2. 여기서 15짜리 로프를 추가해서 40과 15 로프로 만들 수 있는 무게를 생각하는 것이다. 이때 적용되는 게 **(로프 최소값x사용하는 로프의 수)** 인 것이다. 40과 15 로프로는 15x2 = 30이 될 것이다. (15, 30) 
3. 다음으로 10짜리 로프를 추가해서 40, 15, 10 로프로 만들 수 있는 무게는 10x3= 30 (10, 30)

### 문제 풀이 설계
>
1. 로프의 수 N을 입력 받음
2. 로프의 수만큼 반복문을 통해서 각 로프의 중량을 입력 받아 rope배열에 삽입
3. 로프를 중량순으로 내림차순 정렬
4. 사용하는 로프의 수를 나타낼 int count=1 변수, 최대값 int max=0 변수 정의
5. 중량이 높은 로프부터 count값과 곱하고, 이 값을 max값과 비교하여 더 크다면 max값에 저장, count++.
6. max값 출력

## 문제 풀이

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //1. 로프의 수 N 입력 받기
        int N = Integer.parseInt(br.readLine());
        //2. 반복문을 통해서 rope 배열에 삽입
        Integer[] rope = new Integer[N];
        for(int i=0; i<N; i++){
            rope[i] =Integer.parseInt(br.readLine());
        }
        //3. Collections 클래스의 reverseOrder 메소드를 사용하여 중량을 내림차순 정렬
        Arrays.sort(rope, Collections.reverseOrder());
        //4. 사용하는 로프의 수를 나타낼 count변수, 최대값 max 변수 정의
        int count = 1;
        int max = 0;
        //5. 중량이 높은 순서대로 count값과 곱하고, 이 값을 max값과 비교, 저장
        for(int i=0; i<N; i++){
            max = Integer.max(rope[i]*count, max);
            count++;
        }
        //6. max값 출력
        System.out.println(max);
    }
}
```
### 느낀점
>
문제를 해결하기 전에 테스트 케이스를 꼭 확인하고, 나만의 테스트 케이스도 만들어서 로직을 돌려보는 것은 중요한 것 같다. 또한 주어진 조건을 잘 확인하면서, 코드 간결화, 메모리 최적화를 생각하면서 문제 해결 설계를 하는 과정을 꼭 거치고 코드를 짜는 습관을 들여야겠다. 쉬운 문제라서 성공했지만 어려운 문제가 나온다면 설계를 하는 과정을 거쳐도 틀릴 것이다. 그래도 글을 작성하면서 로직을 짜본다는 것은, 상대방도 납득할만한 생각 과정을 거치기 때문에 좋은 방법인 것 같다.