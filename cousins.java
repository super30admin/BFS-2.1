//Time complexity:- O(n) 
//space complexity:- O(1)
//Did it run on leetcode:- yes.
// what was the problem faced:- got wrong answers for some testcases.
//Your code with explanation:- reccursively for every level node checking whether particular node value is x and y ,if so storing at that level height and parent of respective x or y finally checking if height
// of x node and y node is same with different parents, then return true else false.
class Solution {
    private int heightx=0;
    private int heighty=0;
    TreeNode parentx=new TreeNode(0);
     TreeNode parenty=new TreeNode(0);
    
    
    public boolean isCousins(TreeNode root, int x, int y) {
        int h=0;
        checkcousins(root,x,y,h,root);
        if((heightx==heighty)&&(parentx!=parenty)){
            return true;
        }
        
       return false; }
    private void checkcousins(TreeNode root,int x,int y,int h,TreeNode parent){
        if(root==null){
            return;
        }
        if(root.val==x){
            heightx=h;
            parentx=parent;
            
            
        }
        if(root.val==y){
            heighty=h;
            parenty=parent;
        }
        checkcousins(root.left,x,y,h+1,root);
        checkcousins(root.right,x,y,h+1,root);
    }
}