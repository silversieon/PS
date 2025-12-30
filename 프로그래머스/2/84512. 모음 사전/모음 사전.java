class Solution {
    public int solution(String word) {
        int answer = 0;
        for(int i=0; i<word.length(); i++){
            char gather = word.charAt(i);
            int mulValue = 0;
            switch(gather){
                case 'A':
                    mulValue = 0;
                    break;
                case 'E':
                    mulValue = 1;
                    break;
                case 'I':
                    mulValue = 2;
                    break;
                case 'O':
                    mulValue = 3;
                    break;
                case 'U':
                    mulValue = 4;
                    break;
            }
            int sum = 0;
            for(int j=i; j<5; j++){
                sum += (int)(Math.pow(5, 5 - (j+1)));
            }
            answer += sum * mulValue;
        }
        answer += word.length();
        return answer;
    }
}