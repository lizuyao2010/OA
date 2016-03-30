/**
 * Created by lizuyao on 3/20/16.
 */
public class ReducaFraction {
    public static long gcm(long a, long b) {
        return b == 0 ? a : gcm(b, a % b); // Not bad for one line of code :)
    }

    public static String asFraction(long a, long b) {
        long gcm = gcm(a, b);
        return (a / gcm) + "/" + (b / gcm);
    }

    public static void main(String[] args) {
        System.out.println(asFraction(500, 1000)); //  "1/2"
        System.out.println(asFraction(17, 3));     //  "17/3"
        System.out.println(asFraction(462, 1071)); //  "22/51"
    }
}
