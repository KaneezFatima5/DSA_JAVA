package TwoPointerAlgorithm;

import javax.swing.tree.TreeNode;

public class IsValidTree {
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
    public boolean isValidBST(TreeNode root) {

        return (validateBST(root.val, root.val, root.left));
    }
    public static boolean validateBST(int max, int min, TreeNode root){
        boolean left=true;
        boolean right=true;
        if(root.left!=null ){
            if(root.left.val>=max || root.left.val<=min){
                return false;
            }else{
                int newMin=min;
                int newMax=max;
                if(root.left.val<min){
                    newMin=root.left.val;
                }
                left=validateBST(newMax, newMin, root.left);
            }
        }
        if(root.right!=null ){
            if(root.right.val<=min || root.right.val>=max){
                return false;
            }else{
                int newMin=min;
                int newMax=max;
                if(root.right.val>max){
                newMax=root.right.val;
            }
                right=validateBST(newMax, newMin, root.right);
            }
        }
        return (left && right);
    }
}
