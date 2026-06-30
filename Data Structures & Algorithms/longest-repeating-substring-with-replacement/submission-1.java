class Solution {
    public int characterReplacement(String s, int k) {
        int res = 0, windowStart = 0, maxFreq = 0;
        Map<Character, Integer> charFreq = new HashMap<>();
        for(int windowEnd = 0; windowEnd < s.length(); windowEnd++){
            charFreq.put(s.charAt(windowEnd), charFreq.getOrDefault(s.charAt(windowEnd), 0) + 1);
            maxFreq = Math.max(maxFreq, charFreq.get(s.charAt(windowEnd)));
            while(windowEnd - windowStart + 1 - maxFreq > k){
                charFreq.put(s.charAt(windowStart), charFreq.get(s.charAt(windowStart)) - 1);
                windowStart++;
            }
            res = Math.max(res, windowEnd - windowStart + 1);
        }
        return res;
    }
}
