import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, count;
    static int[] A;

    static int check(int M) {
        int left = 0;
        int sum = 0;
        count = 0;

        for (int right = 0; right < N; right++) {
            sum += A[right];  // 오른쪽 포인터가 가리키는 값을 더함

            // sum이 M보다 크거나 같으면 left 포인터 이동
            while (sum >= M) {
                if (sum == M) {
                    count++;  // 부분합이 M인 경우 count 증가
                }
                sum -= A[left];  // left가 가리키는 값을 빼고 포인터 이동
                left++;
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(check(M));
    }
}
