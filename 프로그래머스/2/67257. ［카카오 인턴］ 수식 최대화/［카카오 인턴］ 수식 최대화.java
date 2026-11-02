import java.util.*;
class Solution {
    private static final char[][] orders = {{'+', '-', '*'},{'+', '*', '-'},{'-', '+', '*'},{'-', '*', '+'},{'*', '-', '+'},{'*', '+', '-'}};
    public long solution(String expression) {
        List<Long> nums = new ArrayList<>();
        List<Character> exps = new ArrayList<>();

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<expression.length(); i++) {
            char c = expression.charAt(i);
            if(Character.isDigit(c)) {
                sb.append(String.valueOf(c));
            } else {
                exps.add(c);
                nums.add(Long.parseLong(sb.toString()));
                sb.setLength(0);
            }
        }
        nums.add(Long.parseLong(sb.toString()));
        
        long answer = 0;
        for (char[] order : orders) {
            List<Long> n = new ArrayList<>(nums);
            List<Character> e = new ArrayList<>(exps);
            for(char op : order) {
                for(int i=0; i<e.size(); i++) {
                    if (e.get(i) == op) {
                        long tmp = calc(op, n.get(i), n.get(i+1));
                        n.set(i, tmp);
                        n.remove(i+1);
                        e.remove(i);
                        i--;
                    }
                }
            }
            answer = Math.max(answer, Math.abs(n.get(0)));
        }
        return answer;
    }
    private long calc(char op, long a, long b) {
        switch(op) {
            case '+': return a+b;
            case '-': return a-b;
            default: return a*b;
        }
    }
}