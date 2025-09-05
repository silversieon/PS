import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    static int N, answer = 0;
    static int[] T, P;

    static void DFS(int day, int money) {
        if (day > N) {
            answer = Math.max(answer, money);
            return;
        }
        DFS(day + 1, money);
        if (day + T[day] <= N + 1) {
            DFS(day + T[day], money + P[day]);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        T = new int[N + 1];
        P = new int[N + 1];
        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }
        DFS(1, 0);
        System.out.println(answer);
    }
}
