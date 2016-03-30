import java.util.Arrays;

/**
 * Created by lizuyao on 3/20/16.
 */
public class LongestSubK {
    public String solve1(String str,int k)
    {
        int s=0;
        int n=str.length();
        int max_s=0;
        int max_e=0;
        int[] count=new int[256];
        for (int e=0;e<n;e++)
        {
            count[str.charAt(e)]++;
            while(!valid1(count, k))
            {
                count[str.charAt(s)]--;
                s++;
            }
            if(e-s>max_e-max_s)
            {
                max_e=e;
                max_s=s;
            }
        }
        return str.substring(max_s,max_e+1);
    }
    private boolean valid1(int[] count, int k) {
        int c=0;
        for (int v:count)
        {
            if(v>0)
                c++;
        }
        return c<=k;
    }
    public String solve2(String str,int k)
    {
        int s=0;
        int n=str.length();
        int max_s=0;
        int max_e=0;
        int[] index=new int[256];
        Arrays.fill(index,-1);
        for (int e=0;e<n;e++)
        {
            index[str.charAt(e)]=e;
            if(!valid2(index, k))
            {
                int min=Integer.MAX_VALUE;
                int min_index=s;
                for (int i=0;i<256;i++)
                {
                    if (index[i]!=-1 && index[i]<min) {
                        min = Math.min(min, index[i]);
                        min_index=i;
                    }
                }
                index[min_index]=-1;
                s=min+1;
            }
            if(e-s>max_e-max_s)
            {
                max_e=e;
                max_s=s;
            }
        }
        return str.substring(max_s,max_e+1);
    }
    private boolean valid2(int[] index, int k) {
        int c=0;
        for (int v:index)
        {
            if(v!=-1)
                c++;
        }
        return c<=k;
    }
    public static void main(String[] args)
    {
        LongestSubK ls=new LongestSubK();
        System.out.println(ls.solve2("aabacbebebe", 3));
        System.out.println(ls.solve2("aaabbcc", 2));
    }

}
