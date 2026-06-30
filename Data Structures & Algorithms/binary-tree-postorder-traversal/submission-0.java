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
    public List<Integer> postorderTraversal(TreeNode root) {
      List<Integer> res = new ArrayList<>();
      TreeNode current = root; 
      Deque<TreeNode> stack = new LinkedList<>(); 
      while(current != null || !stack.isEmpty()){
         if(current != null){
             stack.addFirst(current);
             current = current.left; 
            }else{
                 TreeNode temp = stack.peek().right;
                  if (temp == null) {
                     temp = stack.poll();
                     res.add(temp.val);
                     while (!stack.isEmpty() && temp == stack.peek().right) {
                         temp = stack.poll();
                         res.add(temp.val);
                    }
                } else {
                     current = temp;
                }
            }
        }
        return res; 
    }
}