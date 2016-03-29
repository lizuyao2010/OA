import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lizuyao2010 on 3/26/16.
 */
public class StrobogrammaticNumber {
    public List<String> findStrobogrammatic(int n) {
        List<String> res=rec(n,n);
        return res;
    }
    public List<String> rec(int n,int m) {
        Map<Character,Character> map=new HashMap<>();
        map.put('6','9');
        map.put('9','6');
        map.put('8','8');
        map.put('0','0');
        map.put('1','1');
        List<String> res=new ArrayList<>();
        if (n==1)
        {
            res.add("0");
            res.add("1");
            res.add("8");
            return res;
        }
        else if (n==0)
        {
            res.add("");
            return res;
        }
        List<String> nums=rec(n-2,m);
        for (String num:nums)
        {
            for (char key:map.keySet())
            {
                if(n==m && key=='0')
                    continue;
                res.add(key+num+map.get(key));
            }
        }
        return res;
    }
    public static void main(String[] args)
    {
        StrobogrammaticNumber sn=new StrobogrammaticNumber();
        List<String> res=sn.findStrobogrammatic(2);
        System.out.print(res);
    }
}