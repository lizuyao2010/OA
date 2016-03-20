/**
 * Created by lizuyao2010 on 3/17/16.
 */
public class EquilibriumIndex {
    public static int solve(int[] a)
    {
        int n=a.length;
        int leftSum=0;
        int rightSum=0;
        for (int i=0;i<n;i++)
            rightSum+=a[i];
        if (rightSum==leftSum) return n;
        for (int i=0;i<n;i++)
        {
            rightSum-=a[i];
            if (leftSum==rightSum)
                return i;
            leftSum+=a[i];
        }
        return -1;
    }
    public static void main(String[] args)
    {
        int[] arr = {-7, 1, 5, 2, -4, 3, 0};
        System.out.println(solve(arr));
    }


}
