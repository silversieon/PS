import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Stack<Integer> coins = new Stack<>();
        for(int i=0; i<N; i++){
            coins.push(Integer.parseInt(br.readLine()));
        }

        int result = 0;
        while(K!=0){
            int coin = coins.pop();
            if((K/coin)>=1){
                result += Math.floor(K/coin);
                K%=coin;
            }
        }
        System.out.println(result);
    }
}
