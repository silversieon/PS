import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int K, N;
    static long max = Long.MIN_VALUE;
    static long lancable[];

    static boolean Check(long mid) {
        long result_cable_num = 0;
        for (long cable : lancable) {
            result_cable_num += cable / mid;
        }
        return result_cable_num >= N;
    }

    static long cut_cable(long[] lancable) {
        long lo = 1;
        long hi = max;
        while (lo + 1 < hi) {
            long mid = (lo + hi) / 2;
            if (Check(mid)) {
                lo = mid;
            } else {
                hi = mid;
            }
        }
        return Check(hi) ? hi : lo;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        lancable = new long[K];
        for (int i = 0; i < K; i++) {
            lancable[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, lancable[i]);
        }
        System.out.println(cut_cable(lancable));
    }
}
