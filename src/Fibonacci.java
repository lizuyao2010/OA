/**
 * Created by lizuyao2010 on 3/17/16.
 */
public class Fibonacci {
    public static int[] solve(int n)
    {
        int[] res=new int[n];
        if (n>=1)
            res[0]=0;
        if (n>=2)
            res[1]=1;
        for (int i=2; i<n; i++)
            res[i]=res[i-1]+res[i-2];
        return res;
    }
    public static void main(String[] args)
    {
        Utils.printArray(solve(4));
    }
}
