import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by lizuyao2010 on 3/15/16.
 */
public class testRegex {
    public static void main(String[] args)
    {
//        String pattern="(\\d{2})/(\\d{4})";
//        String pattern="(\\d{1,2})\\W{1,3}(\\d{4}|\\d{2})";
        String pattern="(\\d{1,2})\\s*[/-]\\s*(\\d{4}|\\d{2})";
        Pattern r = Pattern.compile(pattern);
        String input="12/99";
        Matcher m = r.matcher(input);
        if (m.find())
        {
            System.out.println(m.group(1));
            System.out.println(m.group(2));
        }

    }
}
