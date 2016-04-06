import java.util.ArrayList;
import java.util.List;

/**
 * Created by lizuyao2010 on 4/6/16.
 */
public class LetterCombinations {
    public List<String> letterCombinations(String digits) {
        String[] a={"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> res=new ArrayList<>();
        if (digits.isEmpty()) return res;
        dfs(a,digits,0,res,new StringBuilder());
        return res;
    }
    private void dfs(String[] a,String digits,int start,List<String> res,StringBuilder sb)
    {
        if (sb.length()==digits.length())
        {
            res.add(sb.toString());
            return;
        }
        for (int i=start;i<digits.length();i++)
        {
            int index=digits.charAt(i)-'0';
            for (char c : a[index].toCharArray())
            {
                sb.append(c);
                dfs(a,digits,i+1,res,sb);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
    public static void main(String[] args)
    {
        LetterCombinations sol=new LetterCombinations();
        List<String> res=sol.letterCombinations("23");
        System.out.print(res);
    }

}
