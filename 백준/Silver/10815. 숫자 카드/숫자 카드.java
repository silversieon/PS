import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    static int N, M;
    static int[] card, problem_card;

    static boolean Check(int mid, int problem_card) {
        return problem_card >= card[mid];
    }

    static int solve_problem(int problem_card) {
        int lo = 0;
        int hi = N - 1;
        while (lo + 1 < hi) {
            int mid = (lo + hi) / 2;
            if (Check(mid, problem_card)) {
                lo = mid;
            } else {
                hi = mid;
            }
        }
        int result = Check(hi, problem_card) ? hi : lo;
        return card[result] == problem_card ? 1 : 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        card = new int[N];
        for (int i = 0; i < N; i++) {
            card[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        problem_card = new int[M];
        for (int i = 0; i < M; i++) {
            problem_card[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(card);

        for (int i = 0; i < M; i++) {
            sb.append(solve_problem(problem_card[i]) + " ");
        }
        System.out.println(sb.toString());
    }
}
