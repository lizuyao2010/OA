import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lizuyao2010 on 3/8/16.
 */
public class TestSplit {
    public static void main(String[] args)
    {
        String s="HighSchool:HighSchool|Associates:Associates|Bachelor:Bachelors|Bachelors:Bachelors|Bachelor’s:Bachelors|Master:Masters|Masters:Masters|Master’s:Masters|Doctor:Doctrates|Doctrate:Doctrates|Doctrates:Doctrates|Associates:Associates";
//        String[] list=s.split("\\|");
//        System.out.println(list[0]);
        Map<String,String> degreeTypeMap = new HashMap<>();
        for (String item : Arrays.asList(s.split("\\|"))) {
            String[] key_values = item.split(":");
            if (key_values.length == 2) {
                degreeTypeMap.put(key_values[0], key_values[1]);
            }
        }
        System.out.print(degreeTypeMap.get("Bachelor"));
    }
}
