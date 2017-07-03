public class Solution {
    public int lengthOfLongestSubstring(String s) {
        char c[] = s.toCharArray();
        boolean b[] = new boolean[128];
        
        int max = 0;
        if(c.length == 1) return 1;
    	for(int k = 0; k < c.length; k++){
            for(int i = k; i < c.length; i++){
				if(b[c[i]]) {
                    max = Math.max(max, i-k);
                    break;
                }
                b[c[i]] = true;
                if(i == c.length-1)	max = Math.max(max, c.length-k);
            }
            Arrays.fill(b, false);
        }
    	return max;
    }
}
