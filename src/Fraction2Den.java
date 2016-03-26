import java.util.HashMap;
import java.util.Map;

/**
 * Created by lizuyao2010 on 3/24/16.
 */

public class Fraction2Den {
    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder res=new StringBuilder();
        if (numerator>0&&denominator<0 || numerator<0&&denominator>0) {
            res.append('-');
        }
        long num=Math.abs((long) numerator);
        long den=Math.abs((long) denominator);
        long d=num/den;
        long r=num%den;
        res.append(d);
        if (r>0) res.append('.');
        Map<Long,Integer> map=new HashMap<>();
        while (r>0)
        {
            if (!map.containsKey(r))
            {
                map.put(r,res.length());
            }
            else {
                int start=map.get(r);
                // if (res.charAt(start-1)==res.charAt(start)) {
                //     res.deleteCharAt(start-1);
                //     return res.substring(0,start-1)+"("+res.substring(start-1)+")";
                // }
                // else
                return res.substring(0,start)+"("+res.substring(start)+")";
            }
            r*=10;
            // while (r<denominator)
            // {
            //     r*=10;
            //     res.append(0);
            // }
            d=r/den;
//            System.out.println(r+" "+den+" "+d);
            res.append(d);
            r=r%den;
        }
        return res.toString();
    }
    public static void main(String[] args)
    {
        Fraction2Den sol=new Fraction2Den();
        String res=sol.fractionToDecimal(-1,-2147483648);
        System.out.print(res);
    }
}
