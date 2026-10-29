class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        // 1. 두 카드 뭉치 각각의 인덱스를 가리킬 포인터 변수 생성(투포인터)
        // 2. 각 카드 뭉치를 각 카드의 현재 인덱스와 비교해서 단어가 있으면 계속 진행, 없으면 NO 반환
        // 3. 모두 순회하여 만들기 성공하면 YES 반환
        int i=0;
        int j=0;
        for(String word : goal) {
            if(i<cards1.length && cards1[i].equals(word)) {
                i++;
            } else if (j<cards2.length && cards2[j].equals(word)) {
                j++;
            } else {
                return "No";
            }
        }
        
        return "Yes";
    }
}