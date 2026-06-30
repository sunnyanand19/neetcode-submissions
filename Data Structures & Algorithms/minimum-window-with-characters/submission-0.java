class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()) return "";
        int[] freq = new int[128];
        for(char c: t.toCharArray()){
            freq[c]++;
        }
        int left = 0, right = 0, matched = 0, minLen = Integer.MAX_VALUE, start = 0;
        while(right < s.length()){
            char rightChar = s.charAt(right);
            freq[rightChar]--;
            if(freq[rightChar] >= 0){
                matched++;
            }
            while(matched == t.length()){
                if(right - left + 1 < minLen){
                    minLen = right - left + 1;
                    start = left;
                }
                char leftChar = s.charAt(left);
                left++;
                freq[leftChar]++;
                if(freq[leftChar] > 0){
                    matched--;
                }
            }
            right++;
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}