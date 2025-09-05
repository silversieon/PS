import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int A = Integer.parseInt(br.readLine());
        char score;
        if(A>=90){
            score = 'A';
        } else if (A>=80) {
            score = 'B';
        } else if (A>=70) {
            score = 'C';
        } else if (A>=60) {
            score = 'D';
        } else {
            score = 'F';
        }
        System.out.println(score);
    }
}