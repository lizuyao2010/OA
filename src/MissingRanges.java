import java.util.ArrayList;
import java.util.List;

/**
 * Created by lizuyao2010 on 3/24/16.
 */


public class MissingRanges {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res=new ArrayList<>();
        int n=nums.length;
        // if (n==0) {
        //     int s=lower;
        //     int e=upper;
        //     addRange(res, s, e);
        //     return res;
        // }
        int s=lower;
        int e=n>0?nums[0]-1:upper;
        addRange(res, s, e);
        for (int i=0;i<n;i++)
        {
            s=nums[i]+1;
            e=i+1<n?nums[i+1]-1:upper;
            addRange(res, s, e);
        }
        return res;
    }

    private void addRange(List<String> res, int s, int e) {
        if (s<e)
        {
            res.add(""+s+"->"+e);
        }
        else if(s==e)
        {
            res.add(String.valueOf(s));
        }
    }
}