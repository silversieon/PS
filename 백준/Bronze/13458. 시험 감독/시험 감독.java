import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, B, C;
    static long managerCounter = 0;
    static int[] numOfperson;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        numOfperson = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numOfperson[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            double temp = (double) (numOfperson[i]);
            temp -= B;
            managerCounter++;
            if (temp > 0) {
                temp /= C;
                managerCounter += (long) (Math.ceil(temp));
            }
        }
        System.out.println(managerCounter);
    }
}
