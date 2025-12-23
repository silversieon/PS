class Solution {
    private int gcd(int a, int b){
        int r = a % b;
        if(r==0) return b;
        else return gcd(b, r);
    }
    public int[] solution(int n, int m) {
        int gcd = gcd(n, m);
        int lcm = n * m / gcd;
        return new int[]{gcd, lcm};
    }
}