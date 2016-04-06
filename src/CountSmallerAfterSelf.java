import java.util.ArrayList;
import java.util.List;

/**
 * Created by lizuyao on 3/30/16.
 */
public class CountSmallerAfterSelf {
    class NumIndex {
        int num;
        int index;
        public NumIndex(int num,int index)
        {
            this.num=num;
            this.index=index;
        }
    }
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res=new ArrayList<>();
        int n=nums.length;
        int[] count=new int[n];
        NumIndex[] numIndexs=new NumIndex[n];
        for (int i=0;i<n;i++)
            numIndexs[i]=new NumIndex(i,nums[i]);
        NumIndex[] copy=new NumIndex[n];
        mergeSort(numIndexs,0,n-1,count,copy);
        for (int c:count)
            res.add(c);
        return res;
    }
    private void mergeSort(NumIndex[] nums,int s,int e,int[] count,NumIndex[] copy)
    {
        if (s>=e) return ;
        int mid=(s+e)/2;
        mergeSort(nums,s,mid,count,copy);
        mergeSort(nums,mid+1,e,count,copy);
        int s1=s;
        int s2=mid+1;
        for (int i=s;i<=e;i++)
        {
            if (s1<=mid && (s2>e || nums[s2].num>nums[s1].num))
            {
                copy[i]=nums[s1++];

            }
            else {
                copy[i]=nums[s2++];
            }
        }
        for (int i=s;i<=e;i++)
            nums[i]=copy[i];
    }
    public static void main(String[] args)
    {
        CountSmallerAfterSelf sol=new CountSmallerAfterSelf();
        int[] a={5,2,6,1};
        List<Integer> res=sol.countSmaller(a);
        System.out.print(res);
    }
}
