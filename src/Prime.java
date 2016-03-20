/**
 * Created by lizuyao2010 on 3/17/16.
 */
public class Prime {
    public static void solve(int n)
    {
        boolean[] prime=new boolean[n+1];
        prime[0]=false;
        prime[1]=false;
        for(int i=2;i<=n;i++)
            prime[i]=true;
        int limit= (int) Math.sqrt(n);
        for (int i=2;i<=limit;i++)
        {
            for (int j=i*i;j<=n;j+=i)
                prime[j]=false;
        }
        for (int i=1;i<=n;i++)
            if(prime[i])
                System.out.println(i);
    }
    public static void main(String[] args)
    {
        solve(50);
    }


}
