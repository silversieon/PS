class Solution {
    boolean solution(String s) {
        s = s.toLowerCase();
        return s.chars().filter(e -> e=='p').count() == s.chars().filter(e-> e=='y').count();
    }
}