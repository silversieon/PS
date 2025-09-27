import java.util.*;
class Solution {
    public long solution(long n) {
        double i = Math.sqrt(n);
        return Math.floor(i) == i ? (long)(Math.pow(i+1, 2)) : -1;
    }
}