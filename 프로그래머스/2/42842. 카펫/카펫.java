class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int area = brown+yellow;
        
        for(int w = 3; w <= Math.sqrt(area); w++ ){
            if(area % w == 0){
                int h = area / w;
                
                if((2 * w) + (2 * h) - 4 == brown){
                    answer[0] = Math.max(w, h);
                    answer[1] = Math.min(w, h);
                    break;
                }
                
            }
        }
        
        return answer;
    }
}