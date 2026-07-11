/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            List<Integer> level = new ArrayList<>();
            for(int i = queue.size(); i > 0; i--){
                TreeNode node = queue.poll();
                if(node != null){
                    level.add(node.val);
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }
            if(level.size() > 0){
                res.add(level);
            }
        } 
        return res;
    }
}
