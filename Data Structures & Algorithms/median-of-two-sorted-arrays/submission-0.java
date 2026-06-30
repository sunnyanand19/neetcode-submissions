class Solution {
public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //if nums1 length is greater than nums2, switch them
        if(nums1.length > nums2.length){
            return findMedianSortedArrays(nums2, nums1);
        }
        int x = nums1.length;
        int y = nums2.length;

        int low = 0;
        int high = x;
        while(low <= high){
            int partitionX = (low + high)/2;
            int partitionY = (x + y + 1) / 2 - partitionX;
            //if partitionX is 0, it means nothing is there on the left side, use -infinity for maxLeftX
            //if partitionX is the length of input, then there is nothing on the right side, use +infinity for minRightX
            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX-1];
            int minRightX = (partitionX == x) ? Integer.MAX_VALUE : nums1[partitionX];

            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY-1];
            int minRightY = (partitionY == y) ? Integer.MAX_VALUE : nums2[partitionY];

            if(maxLeftX <= minRightY && maxLeftY <= minRightX){
                //we have partitioned the arrays at the correct place
                //now get max of left elements and min of right elements to get the median in case of even length combined array size
                //or get max of left for odd length combined array size.
                if((x + y) % 2 == 0){
                    return ((double) Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2;
                }else {
                    return (double) Math.max(maxLeftX, maxLeftY);
                }
            }else if (maxLeftX > minRightY){ //we are too far on the right side for partitionX, Go on the left side.
                high = partitionX - 1;
            }else { //we are too far on the left side for partitionX. Go on the right side.
                low = partitionX + 1;
            }
        }
        return 0.0;
    }
}
