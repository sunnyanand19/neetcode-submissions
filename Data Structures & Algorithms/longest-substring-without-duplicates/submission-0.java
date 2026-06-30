class Solution {
    public int lengthOfLongestSubstring(String s) {
        int windowStart = 0, res = 0;
        Map<Character, Integer> charMap = new HashMap<>();
        for(int windowEnd = 0; windowEnd < s.length(); windowEnd++){
            if(charMap.containsKey(s.charAt(windowEnd))){
                windowStart = Math.max(charMap.get(s.charAt(windowEnd)) + 1, windowStart);
            }
            charMap.put(s.charAt(windowEnd), windowEnd);
            res = Math.max(res, windowEnd - windowStart + 1);
        }
        return res;
    }
}
