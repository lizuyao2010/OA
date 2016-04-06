import java.util.ArrayList;
import java.util.List;

/**
 * Created by lizuyao2010 on 4/5/16.
 */

public class Permutation {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> cu=new ArrayList<>();
        boolean[] visited=new boolean[nums.length];
        dfs(res,nums,cu,visited);
        return res;
    }
    private void dfs(List<List<Integer>> res,int[] nums,List<Integer> cu,boolean[] visited)
    {
        if(cu.size()==nums.length)
            res.add(new ArrayList<>(cu));
        for (int i=0;i<nums.length;i++)
        {
            if (!visited[i]) {
                cu.add(nums[i]);
                visited[i]=true;
                dfs(res, nums, cu,visited);
                visited[i]=false;
                cu.remove(cu.size()-1);
            }
        }
    }
    public static void main(String[] args)
    {
        int[] nums={1,2,3};
        Permutation sol=new Permutation();
        System.out.print(sol.permute(nums));
    }
}
