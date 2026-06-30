class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        int[] freq = new int[26];
        for(char ch: s1.toCharArray()){
            freq[ch - 'a']++;
        }
        int windowStart = 0, required = s1.length();
        for(int windowEnd = 0; windowEnd < s2.length(); windowEnd++){
            char rightChar = s2.charAt(windowEnd);
            if(freq[rightChar - 'a'] > 0){
                required--;
            }
            freq[rightChar - 'a']--;
            if(required == 0) return true;
            if(windowEnd >= s1.length() - 1){
                char leftChar = s2.charAt(windowStart);
                if(freq[leftChar - 'a'] >= 0){
                    required++;
                }
                freq[leftChar - 'a']++;
                windowStart++;
            }
        }
        return false;
    }
}
