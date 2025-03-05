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