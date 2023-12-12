// Time Complexity : O(N) same for bfs, dfs
// Space Complexity : O(N) bfs, O(H) dfs
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : boolean return type dfs function took a few tries

// Explain your approach: make dfs calls parallely, on the left subtree and right subtree
// in bfs, call left.left, right.right, left.right, right.left in that order, not very intuitive


// BFS
class Solution {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return dfs(root.left, root.right);
        
    }
    private boolean dfs(TreeNode left, TreeNode right){
        if(left == null && right == null ) return true;
        if(left == null || right == null || left.val != right.val) return false;
        return dfs(left.left, right.right) && dfs(left.right, right.left);
    }
}

// bfs
/* 
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root.left);
        q.add(root.right);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                TreeNode left = q.poll();
                TreeNode right = q.poll();
                if(left == null && right == null) continue;
                if(left == null || right == null || left.val != right.val) return false;  
                q.add(left.left);
                q.add(right.right);
                q.add(left.right);
                q.add(right.left);    
            }
        }
        return true;
    }
}
*/