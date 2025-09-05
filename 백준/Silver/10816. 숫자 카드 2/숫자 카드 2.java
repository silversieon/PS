import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    static int N, M;
    static int[] card;

    static int Upper_Bound(int problem_card) {
        int lo = -1;
        int hi = N;
        while (lo + 1 < hi) {
            int mid = (lo + hi) / 2;
            if (problem_card >= card[mid]) {
                lo = mid;
            } else {
                hi = mid;
            }
        }
        return hi;
    }

    static int Lower_Bound(int problem_card) {
        int lo = -1;
        int hi = N;
        while (lo + 1 < hi) {
            int mid = (lo + hi) / 2;
            if (problem_card > card[mid]) {
                lo = mid;
            } else {
                hi = mid;
            }
        }
        return hi;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        card = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            card[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(card);

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int problem_card = Integer.parseInt(st.nextToken());
            sb.append(Upper_Bound(problem_card) - Lower_Bound(problem_card)).append(" ");
        }
        System.out.println(sb.toString());
    }
}
