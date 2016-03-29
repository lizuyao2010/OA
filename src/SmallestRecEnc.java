/**
 * Created by lizuyao2010 on 3/29/16.
 */

public class SmallestRecEnc {
    public int minArea(char[][] image, int x, int y) {
        int m=image.length;
        int n=image[0].length;
        int upper=binarySearch(x,m-1,image,true,true);
        int righter=binarySearch(y,n-1,image,false,true);
        int lower=binarySearch(0,x,image,true,false);
        int lefter=binarySearch(0,y,image,false,false);
        return (righter-lefter+1)*(upper-lower+1);
    }
    private int binarySearch(int s,int e,char[][] image,boolean searchRow, boolean isUpper)
    {
        int m=image.length;
        int n=image[0].length;
        while(s+1<e) {
            int mid = (s + e) / 2;
            if (searchRow) {
                int i = 0;
                for (; i < n; i++)
                    if (image[mid][i] == '1') {
                        if (isUpper)
                            s = mid;
                        else
                            e=mid;
                        break;
                    }
                if (i == n) {
                    if (isUpper)
                        e = mid;
                    else
                        s=mid;
                }
            }
            else {
                int i = 0;
                for (; i < m; i++)
                    if (image[i][mid] == '1') {
                        if (isUpper)
                            s = mid;
                        else
                            e=mid;
                        break;
                    }
                if (i == m) {
                    if (isUpper)
                        e = mid;
                    else
                        s=mid;
                }
            }
        }
        if(!isUpper)
        {
            int t=s;
            s=e;
            e=t;
        }
        if (searchRow) {
            for (int i = 0; i < n; i++)
                if (image[e][i] == '1') {
                    return e;
                }
            return s;
        }
        else {
            for (int i = 0; i < m; i++)
                if (image[i][e] == '1') {
                    return e;
                }
            return s;
        }
    }

    public static void main(String[] args)
    {
        char[][] image={"0010".toCharArray(),
                        "0110".toCharArray(),
                        "0100".toCharArray()};
        SmallestRecEnc s=new SmallestRecEnc();
        int area=s.minArea(image,0,2);
        System.out.print(area);
    }
}
