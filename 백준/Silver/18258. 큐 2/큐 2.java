import java.util.*;
import java.io.*;

public class Main {
    static Deque<Integer> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str, " ");
            switch(st.nextToken()){
                case "push" : 
                    int a = Integer.parseInt(st.nextToken());
                    q.offer(a);
                    break;
                case "pop" :
                    if(q.isEmpty()){
                        sb.append(-1).append("\n");
                        break;
                    }
                    else{
                        sb.append(q.poll()).append("\n");
                        break;
                    }
                case "size" :
                    sb.append(q.size()).append("\n");
                    break;
                case "empty" : 
                    if(q.isEmpty()){
                        sb.append(1).append("\n");
                        break;
                    }
                    else{
                        sb.append(0).append("\n");
                        break;
                    }
                case "front" :
                    if(q.isEmpty()){
                    sb.append(-1).append("\n");
                    break;
                    }
                    else{
                    sb.append(q.peek()).append("\n");
                    break;
                    }
                case "back" :
                    if(q.isEmpty()){
                    sb.append(-1).append("\n");
                    break;
                    }
                    else{
                        sb.append(q.getLast()).append("\n");
                        break;
                    }
                default :
                    break;
            }
        }
        System.out.print(sb);
    }
}
