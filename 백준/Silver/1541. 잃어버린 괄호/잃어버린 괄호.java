import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), "-");
        StringTokenizer st_plus;

        int total_sum = 0;
        boolean IsFirstToken = true;
        //-를 기준으로 문자열 나누어서 토큰에 저장
        while(st.hasMoreTokens()){
            //+를 기준으로 숫자들 나누어서 sum에 더하기
            int sum=0;
            String str = st.nextToken();
            st_plus = new StringTokenizer(str, "+");
            while(st_plus.hasMoreTokens()){
                sum+=Integer.parseInt(st_plus.nextToken());
            }
            //첫 토큰이라면 total_sum에 더하기, 아니라면 전부 빼기
            if(IsFirstToken){
                total_sum+=sum;
                IsFirstToken = false;
            }
            else{
                total_sum-=sum;
            }
        }
        System.out.println(total_sum);
    }
}