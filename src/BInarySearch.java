import java.util.BitSet;

/**
 * Created by lizuyao2010 on 3/29/16.
 */
public class BinarySearch {
    public int binarySearch(int[] nums,int target)
    {
        int n=nums.length;
        int s=0;
        int e=n-1;
        while (s+1<e)
        {
            int mid=(s+e)/2;
            if (nums[mid]==target)
                return mid;
            else if(nums[mid]<target)
                s=mid;
            else
                e=mid;
        }
        if(nums[s]==target)
            return s;
        else if (nums[e]==target)
            return e;
        else
            return -1;
    }
    public static void main(String[] args)
    {
        int[] a={1,2,3,4};
        BinarySearch b=new BinarySearch();
        int index=b.binarySearch(a,4);
        System.out.print(index);
    }

}
