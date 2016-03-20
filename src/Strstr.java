/**
 * Created by lizuyao2010 on 3/10/16.
 */
public class Strstr {
    public static void main(String[] args)
    {
        String s1="bcde";
        String s2="cd";
        int index=findNeedle(s1, s2);
        System.out.println(index);
    }

    private static int findNeedle(String s1, String s2) {
        if (s2.length()==0 || s2==null) return 0;
        for (int i=0;i<=s1.length()-s2.length();i++)
        {
            if (s1.substring(i,i+s2.length()).equals(s2))
                return i;
        }
        return -1;
    }

}
