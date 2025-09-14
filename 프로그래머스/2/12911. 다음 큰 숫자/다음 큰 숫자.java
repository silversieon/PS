class Solution {
    static int oneCount = 0;
    public int solution(int n) {
        int answer = 0;
        String binary = Integer.toBinaryString(n);
        for(int i=0; i<binary.length(); i++){
            if(binary.substring(i, i+1).equals("1")) oneCount++;
        }
        for(int i=n+1; ; i++){
            String b = Integer.toBinaryString(i);
            int count = 0;
            for(int j=0; j<b.length(); j++){
                if(b.substring(j, j+1).equals("1")) count++;
            }
            if(count==oneCount){
                    return i;
            }
        }
    }
}