import java.util.Arrays;

/**
 * Created by lizuyao2010 on 4/18/16.
 */

public class SumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n=nums.length;
        int ans=Integer.MAX_VALUE;
        for (int i=0;i<nums.length;i++)
        {
            int j=i+1;
            int k=n-1;
            while (j<k)
            {
                int sum=nums[i]+nums[j]+nums[k];
                if(Math.abs(sum-target)<Math.abs(ans-target)) ans=sum;
                if (sum<target)
                    j++;
                else if(sum>target)
                    k--;
                else
                    return sum;
            }
        }
        return ans;
    }
}