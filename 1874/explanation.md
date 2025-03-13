## 문제

![](https://velog.velcdn.com/images/keumsiun0503/post/038d4ad5-57ef-4dcf-8981-aeba79730349/image.png)
https://www.acmicpc.net/problem/1874

### 문제 설명
>
1. 1부터 N개의 수가 N개의 줄에 하나씩 주어진다, 같은 정수가 두 번 나오는 일은 없음.
2. 숫자 순서대로 스택에 수를 넣었다가 뽑아 늘어놓음으로써 수열을 만들 수 있는지(만들 수 있다면 push, pop 연산의 순서를 출력), 만들 수 없다면 No를 출력하는 문제이다.
3. **숫자를 스택에 push하는 순서는 반드시 오름차순을 지킨다.**
3-1. 예를 들어 2, 3, 4, 1이 주어지면 이 순서대로 스택에 push하는 것이 아닌, 스택에 push되는 순서는 항상 1, 2, 3, 4  순으로 오름차순인 것이다.
3-2. 위 예처럼 2, 3, 4, 1이 주어진다면, push(1), push(2), pop(2), push(3), pop(3), push(4), pop(4), pop(1)을 한다면 2-3-4-1 순서대로 수를 늘어놓을 수 있다.
3-3. 만약 3, 1, 2가 주어진다면 push(1), push(2), push(3), pop(3), pop(1?)<-(스택은 최상단에서 push, pop이 발생하므로 2만 pop할 수 있음) 불가능 No를 출력.
4. 3번의 방식을 지키면서 주어진 수의 순서대로 수를 뽑아 늘어놓을 수 있는지, 없는지를 묻는 문제이다.

결국 문제에서 알고자 하는 것은, 예를 들어 N이 3으로 주어진다면, 123으로 스택에 push, pop을 하면서 만들 수 있는 수열의 경우의 수 중에서 **주어진 순서**가 있는지 묻는 문제이다.
1, 2, 3으로 만들 수 있는 숫자열 경우의 수는 다음과 같다.
1, 2, 3 / 1, 3, 2 / 2, 3, 1 / 2, 1, 3 / 3, 2, 1 / ***3, 1, 2(불가능)***
여기서 3, 1, 2는 불가능하다.(1을 스택에서 pop하여 늘어놓기 전에 2를 pop해야하기 때문)
그렇다면 2, 3, 1은 어떻게 가능한 걸까?( {}를 스택으로 좌측부터 쌓는다고 가정)
1. 1을 push(+) {1}
2. 2를 push(+) {1, 2}
3. 2를 pop(-) {1} / 2
4. 3을 push(+) {1, 3} / 2
5. 3을 pop(-) {1} / 2, 3
6. 1을 pop(-) {} / 2, 3, 1
이런 방식으로 주어진 순서대로 늘어놓을 수 있다.(3, 1, 2는 위 방식을 적용할 수 없음)

### 문제 풀이 설계
>
1. N을 입력받고, 각 줄에 숫자를 하나씩 입력 받아 배열에 넣는다.
2. 스택에 1부터 집어넣을 변수 int k=1과 수열을 만들 수 있는지 체크할 boolean 값을 만들고, 반복문을 통해서 배열속 숫자를 하나씩 불러온다.
3. k를 배열 숫자값까지 오름차순으로 stack에 stack.push(k)한다. (+출력)
4. 만약 배열 숫자값이 stack.peek()(스택의 최상단 숫자)값과 일치한다면 stack.pop(), (-출력)
5. 만약 그렇지 않다면, 해당 수열은 불가능하다(배열에서 해당 숫자가 처음 등장했다면, k값부터 오름차순으로 해당 숫자까지 stack에 집어넣었을텐데, stack.peek()와 일치하지 않는다는 건, 해당 숫자를 pop할 수 없음을 의미) boolean값 false 할당
6. boolean 값이 true라면 push, pop 순서를 출력, 그렇지 않다면 NO를 출력

## 문제 풀이

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//1. N을 입력받고, 각 줄에 숫자를 하나씩 입력 받아 배열에 넣음
		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[N];
		for(int i=0; i<N; i++){
			nums[i] = Integer.parseInt(br.readLine());
		}
		//2. 스택, 출력값을 저장할 StringBuilder
		//2. 수열 생성 가능 여부 boolean, 1부터 오름차순으로 stack에 넣을 변수 k
		Stack<Integer> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		boolean isPossible = true;
		int k=1;
		//2. 반복문을 통해서 배열 속 숫자를 하나씩 불러옴
		for(int i=0; i<N; i++){
			int num = nums[i];
			//3. k를 배열 숫자값까지 오름차순으로 stack에 push (+ 저장)
			for( ; k<=num; k++){
				stack.push(k);
				sb.append('+').append('\n');
			}
			//4. 만약 배열 숫자값이 peek와 일치시 pop, (-저장) 5. 그렇지 않다면 boolean값 false
			if(num==stack.peek()){
				stack.pop();
				sb.append('-').append('\n');
			} else {
				isPossible = false;
			}
		}
		//6. boolean 값에 따라 출력
		if(isPossible){
			System.out.print(sb.toString());
		} else {
			System.out.println("NO");
		}
}
}
```
![](https://velog.velcdn.com/images/keumsiun0503/post/0c24fe4c-646a-4012-a51a-f96893ed0873/image.png)

### 느낀점
>
스택하면 빠질 수 없는 문제가 몇가지 있다.(괄호 문제, 계산 문제 등) 그 중 스택 수열도 빠질 수 없는 문제 중 하나이다. 이 문제는 사실 여러번 풀어봤는데, 방법을 알면서도 구현할 때면 항상 잠시 막히게 된다. 이 문제는 풀때 마다 **"항상 정말 좋은 문제인 것 같다."**라는 생각을 하게 된다. 코딩테스트를 막 처음 시작할 시기에 이 문제의 풀이법을 보면서 감탄했고, 코딩테스트의 매력에 빠져들게 해준 문제다. 높은 난이도의 문제는 아니므로 코딩테스트 초보자라면 꼭 한 번쯤 깊은 고민을 통해서 풀어봤으면 하는 문제이다.

