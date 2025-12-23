class Solution {
    private int isLcm(int number, int n, int m){
        if(number % n != 0 || number % m != 0) return 0;
        return 1;
    }
    public int solution(int number, int n, int m) {
        return isLcm(number, n, m);
    }
}