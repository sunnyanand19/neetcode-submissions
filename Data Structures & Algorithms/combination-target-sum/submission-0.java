class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<List<Integer>>();
        List<Integer> cur = new ArrayList<>();
        backtrack(candidates, cur, target, 0);
        return res;
    }
    private void backtrack(int[] candidates, List<Integer> cur, int target, int i){
        if(target == 0){
            res.add(new ArrayList(cur));
            return;
        }
        if(target < 0 || i >= candidates.length){
            return;
        }
        cur.add(candidates[i]);
        backtrack(candidates, cur, target - candidates[i], i); //don't increment i so that it can be reused
        cur.removeLast();
        backtrack(candidates, cur, target, i + 1);
    }
}
