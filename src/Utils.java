/**
 * Created by lizuyao2010 on 3/17/16.
 */
public class Utils {
    static void printArray(int[] anArray) {
        for (int i = 0; i < anArray.length; i++) {
            if (i > 0) {
                System.out.print(", ");
            }
            System.out.print(anArray[i]);
        }
    }
}
