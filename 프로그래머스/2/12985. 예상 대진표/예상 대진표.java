class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;
        while(a!=b){
            answer++;
            a = (int)Math.ceil(a/2.0);
            b = (int)Math.ceil(b/2.0);
        }
        return answer;
    }
}