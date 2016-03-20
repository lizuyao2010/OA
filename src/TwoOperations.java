/**
 * Created by lizuyao2010 on 3/17/16.
 */
public class TwoOperations {
    public static int solve(int target)
    {
        if (target<1) return -1;
        int c=1;
        while(target!=1)
        {
            if (target%2==0)
                target>>=1;
            else
                target--;
            c++;
        }
        return c;
    }
    public static void main(String[] args)
    {
        System.out.print(solve(17));
    }

}
