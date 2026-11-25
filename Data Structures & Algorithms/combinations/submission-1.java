public class Solution {

    private List<List<Integer>> res;

    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        backtrack(1, n, k, new ArrayList<>());
        return res;
    }

    private void backtrack(int start, int n, int k, List<Integer> comb) {
        // Base case: valid combination found
        if (comb.size() == k) {
            res.add(new ArrayList<>(comb));
            return;
        }
        // Pruning: insufficient remaining elements
        int remaining = k - comb.size();

        for (int i = start; i <= n - remaining + 1; i++) {
            comb.add(i);
            backtrack(i + 1, n, k, comb);
            comb.removeLast();
        }
    }
}