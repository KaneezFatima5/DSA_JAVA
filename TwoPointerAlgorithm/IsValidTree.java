package TwoPointerAlgorithm;

import javax.swing.tree.TreeNode;

public class IsValidTree {
    public static class TreeNode {
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
    public static boolean isValidBST(TreeNode root) {
        System.out.println(Long.MAX_VALUE);

        return (validateBST(Long.MIN_VALUE, Long.MAX_VALUE, root));
    }
    public static boolean validateBST(Long min, Long max, TreeNode root){
        boolean left=true;
        boolean right=true;
        int rootValue;
        if(root!=null){
            rootValue=root.val;
            if(root.val<=min || root.val>=max){
                return false;
            }
            if(root.left!=null){
                left=validateBST(min, Math.min(max, rootValue), root.left);
            }
            if(root.right!=null){
                right=validateBST(Math.max(min, rootValue), max, root.right);
            }
        }
        return left && right;
    }
    public static void main(String args[]){
        TreeNode node=new TreeNode(2147483647);
        boolean res=isValidBST(node);
        System.out.println(res);
    }
}
