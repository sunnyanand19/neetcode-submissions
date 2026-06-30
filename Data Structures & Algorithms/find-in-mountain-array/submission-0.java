/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();
        //find peak
        int left = 0, right = n - 1;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(mountainArr.get(mid) < mountainArr.get(mid + 1)){
                left = mid + 1;
            }else { 
                right = mid - 1;
            }
        }
        int peak = left;
        //search in increasing part
        int index = binarySearchAscending(mountainArr, target, 0, peak);
        if(index != -1){
            return index;
        }
        //search in descending part
        return binarySearchDescending(mountainArr, target, peak + 1, n - 1);
    }

    private int binarySearchAscending(MountainArray arr, int target, int left, int right){
        while(left <= right){
            int mid = left +(right - left) / 2;
            int value = arr.get(mid);
            if(value == target){
                return mid;
            }else if(value < target){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return -1;
    }

        private int binarySearchDescending(MountainArray arr, int target, int left, int right){
        while(left <= right){
            int mid = left +(right - left) / 2;
            int value = arr.get(mid);
            if(value == target){
                return mid;
            }else if(value > target){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return -1;
    }
}