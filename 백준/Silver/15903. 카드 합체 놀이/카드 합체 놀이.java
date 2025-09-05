import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Long> pq = new PriorityQueue<>();
        String line1 = br.readLine();
        StringTokenizer st1 = new StringTokenizer(line1, " ");
        String line2 = br.readLine();
        StringTokenizer st2 = new StringTokenizer(line2, " ");
        int numOfCard = Integer.parseInt(st1.nextToken());
        int numOfAdd = Integer.parseInt(st1.nextToken());
        for(int i=0; i<numOfCard; i++){
            pq.add(Long.parseLong(st2.nextToken()));
        }
        for(int i=0; i<numOfAdd; i++){
            long a = pq.poll();
            long b = pq.poll();
            long sum = a+b;
            pq.add(sum);
            pq.add(sum);
        }
        long result = 0;
        for(int i=0; i<numOfCard; i++){
            result+=pq.poll();
        }
        System.out.println(result);
    }
}
