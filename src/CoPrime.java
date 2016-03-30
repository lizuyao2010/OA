/**
 * Created by lizuyao on 3/20/16.
 */
public class CoPrime {
    static int[] coprimeCount(int[] A) {
        int n=A.length;
        int[] B= new int[n];
        for (int i=0;i<n;i++)
        {
            B[i]=totient(A[i]);
        }
        return B;
    }
    private static int totient(int num){ //euler's totient function calculator. returns totient
        int count=0;
        for(int a=1;a<=num;a++){ //definition of totient: the amount of numbers less than num coprime to it
            if(GCD(num,a)==1){ //coprime
                count++;
            }
        }
        return(count);
    }

    private static int GCD(int a, int b){ //faster euclidean algorithm-see GCD for explanation
        int temp;
        if(a<b){
            temp=a;
            a=b;
            b=temp;
        }
        if(a%b==0){
            return(b);
        }
        return(GCD(a%b,b));
    }
    public static void main(String[] args)
    {
        System.out.println(totient(1));
    }
}
