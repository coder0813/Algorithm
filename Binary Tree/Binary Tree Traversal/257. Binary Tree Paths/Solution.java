public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if( root == null ) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<StringBuilder> path = new LinkedList<>();
        queue.add(root);
        path.add(new StringBuilder());
        
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            StringBuilder sb = path.poll();
            if( node.left == null && node.right == null ){
                res.add(sb.append(node.val).toString());
            }
            if( node.left != null ){
                StringBuilder temp = new StringBuilder(sb);
                queue.add(node.left);
                path.add(temp.append(node.val).append("->"));
            }
            if( node.right != null ){
                StringBuilder temp = new StringBuilder(sb);
                queue.add(node.right);
                path.add(temp.append(node.val).append("->"));
            }
        }
        return res;
    }
}