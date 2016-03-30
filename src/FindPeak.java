/**
 * Created by lizuyao2010 on 3/29/16.
 */
public class FindPeak {
    public int solve(int[] nums)
    {
        int n=nums.length;
        int s=0;
        int e=n-1;
        while(s+1<e)
        {
            int mid=(s+e)/2;
            if (nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1])
                return mid;
            else if(nums[mid]<nums[mid+1])
                s=mid;
            else
                e=mid;
        }
        if(nums[s]<nums[e])
            return e;
        else
            return s;
    }
    public static void main(String[] args)
    {
        int[] a={3,2,4,1};
        FindPeak fp=new FindPeak();
        int index=fp.solve(a);
        System.out.print(index);
    }
}
