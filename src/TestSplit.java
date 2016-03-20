/**
 * Created by lizuyao2010 on 3/8/16.
 */
public class TestSplit {
    public static void main(String[] args)
    {
        String s="AB|EF|CD";
        String[] list=s.split("\\|");
        System.out.println(list[0]);
    }
}
