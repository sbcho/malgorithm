public class Solution {
    public int lengthOfLongestSubstring(String s) {
        char c[] = s.toCharArray();
        
        int max = 0;
        int res;
        
        if(c.length == 1) return 1;
    	
        for(int k = 0; k < c.length;){
            for(int i = k; i < c.length; i++){
                for(int j = k; j < i; j++){
                    if(c[j] == c[i]) {
                        max = Math.max(max, i-k);
                        k = j+1;
                    }
                    if(j == c.length-2) {
                        max = Math.max(max, c.length-k);
                        k = c.length;
                    }
                }
            }
        }
    	return max;
    }
}
