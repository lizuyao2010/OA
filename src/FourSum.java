import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lizuyao2010 on 4/6/16.
 */

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int n=nums.length;
        List<List<Integer>> res=new ArrayList<>();
        for(int m=0;m<n;m++) {
            if (m>0 && nums[m]==nums[m-1]) continue;
            for (int i = m + 1; i < n; i++) {
                if (i>m+1 && nums[i]==nums[i-1]) continue;
                int j = i + 1;
                int k = n - 1;
                int t = target-nums[i]-nums[m];
                while (j < k) {
                    int sum=nums[j] + nums[k];
                    if (sum == t) {
                        res.add(Arrays.asList(nums[m],nums[i], nums[j], nums[k]));
                        while (j < k && nums[j] == nums[j + 1]) j++;
                        while (j < k && nums[k] == nums[k - 1]) k--;
                        j++;
                        k--;
                    } else if (sum > t)
                        k--;
                    else
                        j++;
                }
            }
        }
        return res;
    }
}