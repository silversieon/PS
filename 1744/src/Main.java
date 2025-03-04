import java.io.*;
import java.util.*;

public class Main {
    static int maxResult = 0;
    static PriorityQueue<Integer> positivePQ = new PriorityQueue<>(Collections.reverseOrder());
    static PriorityQueue<Integer> negativePQ = new PriorityQueue<>();
    static void calculatePositive(){
        while(positivePQ.size()>=2){
            int num1 = positivePQ.poll();
            int num2 = positivePQ.poll();
            int plus = num1 + num2;
            int multiply = num1 * num2;
            maxResult += plus>multiply ? plus : multiply;
        }
        if(!positivePQ.isEmpty()){
            maxResult+=positivePQ.poll();
        }
    }
    static void calculateNegative(){
        while(negativePQ.size()>=2){
            int num1 = negativePQ.poll();
            int num2 = negativePQ.poll();
            int plus = num1 + num2;
            int multiply = num1 * num2;
            maxResult += plus>multiply ? plus : multiply;
        }
        if(!negativePQ.isEmpty()){
            maxResult += negativePQ.poll();
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        
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