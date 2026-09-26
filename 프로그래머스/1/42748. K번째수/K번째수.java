import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int idx = 0;
        for(int[] command : commands) {
            int[] temp = new int[command[1] - command[0] + 1];
            int tempIdx = 0;
            for(int i=command[0]-1; i<command[1]; i++) {
                temp[tempIdx] = array[i];
                tempIdx++;
            }
            Arrays.sort(temp);
            answer[idx] = temp[command[2]-1];
            idx++;
        }
        return answer;
    }
}