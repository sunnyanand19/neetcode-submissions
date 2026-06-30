class Solution {
    public int splitArray(int[] nums, int k) {
        int left = 0 ,right = 0, res = 0;
        for(int num: nums){
            left = Math.max(left, num);
            right += num;
        }
        res = right;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(canSplit(nums, k, mid)){
                res = mid;
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return res;
    }
    private boolean canSplit(int[] nums, int k, int largest){
        int subarray = 1, curSum = 0;
        for(int num: nums){
            curSum += num;
            if(curSum > largest){
                subarray++;
                if(subarray > k) return false;
                curSum = num;
            }
        }
        return true;
    }
}