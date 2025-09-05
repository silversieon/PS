import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String str;
        boolean enterCheck = false;
        int count = 0;
        HashMap<String, Integer> map = new HashMap<>();
        while(N-->0){
            str = br.readLine();
            if(str.equals("ENTER")){
                map = new HashMap<>();
                enterCheck = true;
            }
            else if(enterCheck==true){
                boolean nameCheck = map.containsKey(str);
                if(!nameCheck){
                    map.put(str, 0);
                    count++;
                }
            }
        }
        System.out.println(count);
        br.close();
    }
}
