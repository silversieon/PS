import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashSet<String> nList = new HashSet<>();
        PriorityQueue<String> answerList = new PriorityQueue<>();
        int count = 0;
        while(N-->0){
            nList.add(br.readLine());
        }
        while(M-->0){
            String str = br.readLine();
            if(nList.contains(str)){
                answerList.add(str);
                count++;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(count).append('\n');
        while(count-->0){
            sb.append(answerList.poll()).append('\n');
        }
        System.out.print(sb.toString());
    }
}
