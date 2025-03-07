import java.io.*;
import java.util.*;

public class Main {
    static int N, maxLength = 0;
    static String[] word;
    static HashMap<Character, Integer> hash = new HashMap<>();
    static int caculateMaxSum(){
        int answer = 0;
        int numberValue = 9;
        for(int i=0; i<N; i++){
            String str = word[i];
            for(int k=0; k<str.length(); k++){
                char alphabet = (char)(str.charAt(k));
                if(!hash.containsKey(alphabet)){
                    hash.put(alphabet, numberValue);
                    answer += numberValue * Math.pow(10, str.length()-(k+1));
                    numberValue--;
                } else {
                    answer += hash.get(alphabet) * Math.pow(10, str.length()-(k+1));
                }
                System.out.println(answer);
            }
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        word = new String[N];

        for(int i=0; i<N; i++){
            word[i] = br.readLine();
            maxLength = Math.max(maxLength, word[i].length());
        }
        Arrays.sort(word, 0, N, (s1, s2)->Integer.compare(s2.length(), s1.length()));


        System.out.println(caculateMaxSum());
        // for(int i=0; i<N; i++){
        //     System.out.println(word[i]);
        // }
    }
}
