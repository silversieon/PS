import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();
        for(int i=0; i<N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        int[] nums_array = nums.clone();
        Arrays.sort(nums_array);
        HashMap<Integer, Integer> hs = new HashMap<>();
        int count =0;
        for(int i=0; i<N; i++){
            if(!hs.containsKey(nums_array[i])){
                hs.put(nums_array[i], count++);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            sb.append(hs.get(nums[i])+ " ");
        }
        System.out.println(sb.toString());
    }
}
