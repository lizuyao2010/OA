/**
 * Created by lizuyao2010 on 3/31/16.
 */
public class Replace {
    public static void main(String[] args)
    {
        String subjectString="BachelorÂ ofÂ Applied Science";
        String resultString = subjectString.replaceAll("[^\\x20-\\x7e]", "");
        System.out.print(resultString);
    }
}
