import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by lizuyao2010 on 4/3/16.
 */
public class WordBreak {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        // Map<Integer,List<String>> map=new HashMap<>();
        int n=s.length();
        List<String>[] dp=new List[n+1];
        List<String> values=new ArrayList<>();
        values.add("");
        dp[n]=values;
        for (int i=n-1;i>=0;i--)
        {
            values=new ArrayList<>();
            for (int j=i+1;j<=n;j++)
            {
                String prefix=s.substring(i,j);
                if (wordDict.contains(prefix)) {
                    for (String item : dp[j]) {
                        values.add(prefix + (item.isEmpty() ? "" : " ") + item);
                    }
                }
            }
            dp[i]=values;
        }
        return dp[0];
    }
}
