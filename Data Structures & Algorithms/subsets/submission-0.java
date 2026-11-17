class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        dfs(0, nums, subset, result);
        return result;
    }
    private void dfs(int i, int[] nums, List<Integer> subset, List<List<Integer>> res){
        if(i >= nums.length){
            res.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[i]);
        dfs(i+1, nums, subset, res);
        subset.remove(subset.size() - 1);
        dfs(i+1, nums, subset, res);
    }
}