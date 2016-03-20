import java.util.Stack;

/**
 * Created by lizuyao2010 on 3/10/16.
 */
class TreeNode
{
    TreeNode left;
    TreeNode right;
    char val;
    public TreeNode(char val)
    {
        this.val=val;
        left=null;
        right=null;
    }
    public String serialize(){
        StringBuilder sb = new StringBuilder();
        serialize(this, sb);
        return sb.toString();
    }
    private void serialize(TreeNode x, StringBuilder sb){
        if (x == null) {
            sb.append("# ");
        } else {
            sb.append(x.val + " ");
            serialize(x.left, sb);
            serialize(x.right, sb);
        }
    }
}
public class TernaryExpressionToBinaryTree {
    public static void main(String[] args)
    {
        TreeNode root=solve("a?b?c:d:e");
        System.out.print(root.serialize());
    }
    public static TreeNode solve(String s)
    {
        Stack<TreeNode> stack=new Stack<>();
        stack.add(new TreeNode(s.charAt(0)));
        for (int i=1;i<s.length()-1;i+=2)
        {
            char c=s.charAt(i);
            char next=s.charAt(i+1);
            if (c==':')
            {
                TreeNode r=new TreeNode(next);
                TreeNode l=stack.pop();
                stack.peek().left=l;
                stack.peek().right=r;
            }
            else if(c=='?')
            {
                stack.push(new TreeNode(next));
            }
        }
        return stack.peek();
    }
}
