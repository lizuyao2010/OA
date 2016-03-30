/**
 * Created by lizuyao2010 on 3/29/16.
 */

public class BinaryTreeLongestConsective {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {val=x;}
    }
    public int longestConsecutive(TreeNode root)
    {
        if (root==null) return 0;
        return dfs(root,root.val-1,0);
    }
    private int dfs(TreeNode root, int prev,int cu)
    {
        if (root==null) return 0;
        if (root.val==prev+1)
            cu++;
        else
            cu=1;
        int res=Math.max(dfs(root.left,root.val,cu),dfs(root.right,root.val,cu));
        return Math.max(cu,res);
    }
}
