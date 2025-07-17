import java.io.*;
import java.util.*;

public class Main {
    static int T, N, result = 1;
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine()); // TestCase 수

        while(T-->0){ //TestCase수만큼 반복
            N = Integer.parseInt(br.readLine()); //의상의 수

            //해당 Type에 몇 개의 의상이 있는지 저장할 HashMap
            HashMap <String, Integer> hashmap = new HashMap<>(); 
            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());

                //종류만 저장하면 되므로 토큰 하나 날리기
                st.nextToken();
                String type = st.nextToken();

                //만약 Hashmap에 해당 type이 없다면 value 값 2로 설정, 있다면 +1
                //왜 디폴트가 1이 아닌 2인가? -> 해당 종류에 옷이 들어가지 않는 경우의 수도 생각해야함
                if(!hashmap.containsKey(type)){
                    hashmap.put(type, 2);
                } else {
                    hashmap.put(type, hashmap.get(type)+1);
                }
            }
            
            //set 변수에 hashmap 키셋 저장, 출력시 [headgear, eyewear] 와 같이 출력
            //iterator 변수로 set값을 하나씩 가리킴
            Set<String> set = hashmap.keySet();
            Iterator<String> iterator = set.iterator();
            
            //다음으로 가리킬 옷의 종류가 없을 때까지 해당 종류에 있는 옷의 개수(안 입는 것도 포함)를 결과 값에 곱함
            while(iterator.hasNext()){
                result *= hashmap.get(iterator.next());
            }
            //모든 옷을 안 입는 경우 제외(-1)후 저장, result 값 1로 초기화
            sb.append(result-1).append("\n");
            result = 1;
        }
        System.out.println(sb.toString());
    }
}
