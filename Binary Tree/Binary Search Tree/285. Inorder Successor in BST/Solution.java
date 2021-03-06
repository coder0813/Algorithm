class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode res = null;
        if( root == null ) return res;
        if( root.val <= p.val ){
            return inorderSuccessor(root.right,p);
        } else {
            res = inorderSuccessor(root.left,p);
            if( res == null ) return root;
            else return res;
        }
    }
}


public class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode res = null;
        if( root == null ) return res;
        while( root != null ){
            if ( root.val <= p.val ){
                root = root.right;
            } else{
                res = root;
                root = root.left;
            }
        }
        return res;
    }
}