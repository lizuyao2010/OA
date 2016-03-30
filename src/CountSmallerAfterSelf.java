import java.util.ArrayList;
import java.util.List;

/**
 * Created by lizuyao on 3/30/16.
 */
public class CountSmallerAfterSelf {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res=new ArrayList<>();
        int n=nums.length;
        int[] count=new int[n];
        int[] copy=new int[n];
        mergeSort(nums,0,n-1,count,copy);
        for (int c:count)
            res.add(c);
        return res;
    }
    private void mergeSort(int[] nums,int s,int e,int[] count,int[] copy)
    {
        if (s>=e) return ;
        int mid=(s+e)/2;
        mergeSort(nums,s,mid,count,copy);
        mergeSort(nums,mid+1,e,count,copy);
        int s1=s;
        int s2=mid+1;
        for (int i=s;i<=e;i++)
        {
            if (s2<=e && (s1>mid || nums[s2]>nums[s1]))
            {
                copy[i]=nums[s2++];
            }
            else {
                copy[i]=nums[s1++];
            }
        }
        for (int i=s;i<=e;i++)
            nums[i]=copy[i];
    }
}
