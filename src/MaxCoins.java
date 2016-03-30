/**
 * Created by lizuyao on 3/30/16.
 */
public class MaxCoins {
    public int maxCoins(int nums[])
    {
        int n=nums.length;
        int[] newNums=new int[n+2];
        newNums[0]=1;
        newNums[n+1]=1;
        for (int i=0;i<n;i++)
            newNums[i+1]=nums[i];
        int[][] memo=new int[n+2][n+2];
        int ans=burst(newNums,0,n+1,memo);
        return ans;
    }
    public int burst(int[] nums,int l,int r,int[][] memo)
    {
        if (memo[l][r]!=0) return memo[l][r];
        int n=nums.length;
        if (l+1==r)
            return 0;
        int res=0;
        for (int i=l+1;i<r;i++)
        {
            res=Math.max(res,nums[i]*nums[l]*nums[r]+burst(nums,l,i,memo)+burst(nums,i,r,memo));
        }
//        System.out.println(l+","+r+","+res);
        memo[l][r]=res;
        return res;
    }
    public static void main(String[] args)
    {
        MaxCoins m=new MaxCoins();
        int[] a={2,8};
        int ans=m.maxCoins(a);
        System.out.print(ans);
    }

}
