## 문제

![](https://velog.velcdn.com/images/keumsiun0503/post/f6e292c2-a352-4126-8548-f2fb2557fbed/image.png)
https://www.acmicpc.net/problem/10828

### 문제 설명
>
1. 사용자가 입력한 문자열을 읽어들인다.
2. 문자열 내용에 따라서 **스택** 자료구조의 특성을 활용하여 값을 출력.
3. 그렇다면 스택 자료구조란?

![](https://velog.velcdn.com/images/keumsiun0503/post/ad7b4234-120e-4746-a09b-019660e53e02/image.png)
https://www.programiz.com/dsa/stack
* **Last In First Out** : 후입 선출의 특징을 가지고 있음
* 자료의 삽입, 삭제가 항상 스택의 최상단 **top**에서 일어남

### 문제 풀이 설계
>
1. 입력 받을 명령어 (push, pop, size, empty, top) 의 개수를 입력 받음
2. BufferedReader의 br.readLine()을 통해서 문자열 한 라인을 입력 받음
3. switch문을 통해서 명령어 읽기 (또는 if문과 .eqauls() 메소드를 통해서 명령어 읽기도 가능)
4. 주어진 명령어에 따라서 명령에 해당하는 값을 출력하는데, 자바의 **Stack** 클래스 활용
5. StringBuilder를 사용하여 출력 값을 버퍼에 하나씩 넣어둠
6. 위 과정을 for 반복문을 통해서 N번 반복
7. StringBuilder의 버퍼 값 출력

## 문제 풀이

```java
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        String cmd;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            cmd = st.nextToken();
            switch(cmd){
                case "push" :
                    int x = Integer.parseInt(st.nextToken());
                    stack.push(x);
                    break;
                case "pop" :
                    if(stack.isEmpty()) {
                        sb.append(-1).append("\n");
                    }
                    else{
                        sb.append(stack.pop()).append("\n");
                    }
                    break;
                case "size" :
                    sb.append(stack.size()).append("\n");
                    break;
                case "empty" :
                    if(stack.isEmpty()) {
                        sb.append(1).append("\n");
                    }
                    else{
                        sb.append(0).append("\n");
                    }
                    break;
                case "top" :
                    if(stack.isEmpty()) {
                        sb.append(-1).append("\n");
                    }
                    else{
                        sb.append(stack.peek()).append("\n");
                    }
                    break;
            }
        }
        br.close();
        System.out.print(sb.toString());
    }
}
```
![](https://velog.velcdn.com/images/keumsiun0503/post/c879f82d-5517-455d-b474-d4f4ae4a62d4/image.png)

### 느낀점
>
자바의 활용도 높은 클래스들과, 이에 속한 메소드들을 잘 알고 활용하는 것이 중요한 것 같다.
스택 구조를 C로 작성하려면 구조체도 만들고, 여러 함수들도 찍어내야 하는데, 자바, 파이썬, 자바스크립트와 같은 언어들은 이를 쉽게 활용할 수 있는 방법들이 존재하기 때문에 잘 숙지해두는 것이 중요하다.
그리고 항상 문제를 풀 때는 문제의 조건을 확인하고, 설계를 하는 과정을 거쳐야한다.
코딩테스트뿐만 아니라 프로젝트를 진행할 때도, 문제가 발생하면 이를 주어진 조건내에서 설계하는 과정은 항상 중요하다..