import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String document = br.readLine();
        String word = br.readLine();

        int count = 0;
        int document_length = document.length();
        int word_length = word.length();
        
        for(int i=0; i<=document_length-word_length; ){
            String s1 = document.substring(i, i+word_length);
            if(s1.equals(word)){
                i+=word_length;
                count++;
            }
            else{
                i++;
            }
        }
        System.out.println(count);
    }
}
