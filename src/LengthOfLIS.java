import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by lizuyao2010 on 4/5/16.
 */
public class LengthOfLIS {
    public int lengthOfLIS(int[] nums)
    {
        List<Integer> dp=new ArrayList<>();
        for (int n:nums)
        {
            if (dp.size()==0 || n>dp.get(dp.size()-1))
                dp.add(n);
            else {
                int index= Collections.binarySearch(dp,n);
                System.out.println(index);
                dp.set(index<0?-index-1:index,n);
            }
        }
        return dp.size();
    }
    public static void main(String[] args)
    {
        int[] nums={2,5,1,4};
        LengthOfLIS sol=new LengthOfLIS();
        int len=sol.lengthOfLIS(nums);
        System.out.print(len);
    }

}
