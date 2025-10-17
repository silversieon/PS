import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        TreeSet<Integer> ts = new TreeSet<>();
        for(String operation : operations){
            StringTokenizer st = new StringTokenizer(operation);
            String command = st.nextToken();
            if(command.equals("I")){
                int a = Integer.parseInt(st.nextToken());
                ts.add(a);
            } else if(command.equals("D")) {
                if(!ts.isEmpty()){
                    String choice = st.nextToken();
                    if(choice.equals("1")){
                        ts.pollLast();
                    } else if(choice.equals("-1")){
                        ts.pollFirst();
                    }
                }
            }
        }
        if(!ts.isEmpty()){
            answer[0] = ts.last();
            answer[1] = ts.first();
        } else {
            answer[0] = 0;
            answer[1] = 0;
        }
        return answer;
    }
}