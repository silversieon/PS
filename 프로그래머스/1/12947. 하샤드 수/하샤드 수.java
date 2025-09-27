class Solution {
    public boolean solution(int x) {
        String s = String.valueOf(x);
        int sum = 0;
        for(int i=0; i<s.length(); i++){
            sum+=Integer.parseInt(s.substring(i, i+1));
        }
        return x%sum==0;
    }
}