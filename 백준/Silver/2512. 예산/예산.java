import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, min = 0, max = Integer.MIN_VALUE;
    static int[] each_local_budget;

    static int caculate_max_budget(int[] each_local_budget) {
        int min_value = min;
        int max_value = max;
        int middle_value = 0;
        long cutting_result = 0;
        while (min_value <= max_value) {
            middle_value = (min_value + max_value) / 2;
            cutting_result = 0;
            for (int i = 0; i < N; i++) {
                if (each_local_budget[i] >= middle_value) {
                    cutting_result += middle_value;
                } else {
                    cutting_result += each_local_budget[i];
                }
            }
            if (cutting_result > M) {
                max_value = middle_value - 1;
            } else {
                min_value = middle_value + 1;
            }
        }
        return max_value;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        each_local_budget = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            max = Math.max(max, tmp);
            min = Math.min(min, tmp);
            each_local_budget[i] = tmp;
        }
        M = Integer.parseInt(br.readLine());

        System.out.println(caculate_max_budget(each_local_budget));
    }
}
