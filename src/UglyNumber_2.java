/**
 * Created by lizuyao2010 on 3/26/16.
 */

public class UglyNumber_2 {
    public int nthUglyNumber(int n) {
        int[] primes={2, 3, 5};
        int[] idx={0,0,0};
        int[] nums=new int[n];
        nums[0]=1;
        for (int i=0;i<n-1;i++)
        {
            int min=Integer.MAX_VALUE;
            int min_index=-1;
            for (int j=0;j<primes.length;j++)
            {
                int t=primes[j]*nums[idx[j]];
                if(t<=min)
                {
                    min=t;
                }
            }
            for (int j=0;j<primes.length;j++)
            {
                int t=primes[j]*nums[idx[j]];
                if(t==min)
                    idx[j]++;
            }
            nums[i+1]=min;
//            System.out.println(nums[i+1]);
//            idx[min_index]++;
        }
        return nums[n-1];
    }
    public static void main(String[] args)
    {
        UglyNumber_2 sol=new UglyNumber_2();
        int res=sol.nthUglyNumber(20);
    }
}
