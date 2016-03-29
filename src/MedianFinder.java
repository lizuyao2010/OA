import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created by lizuyao2010 on 3/29/16.
 */
public class MedianFinder {
    PriorityQueue<Integer> big=new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> small=new PriorityQueue<>();
    // Adds a number into the data structure.
    public void addNum(int num) {
        if (big.size()==small.size())
        {
            if (small.isEmpty() || num>=big.peek())
                small.offer(num);
            else {
                small.offer(big.poll());
                big.offer(num);
            }
        }
        else {
            if (num<=small.peek())
                big.offer(num);
            else {
                big.offer(small.poll());
                small.offer(num);
            }
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        if (big.size()==small.size())
        {
            return ((double)big.peek()+small.peek())/2;
        }
        else
        {
            return small.peek();
        }
    }
    public static void main(String args[])
    {
        // Your MedianFinder object will be instantiated and called as such:
        MedianFinder mf = new MedianFinder();
        mf.addNum(1);
        mf.addNum(2);
        mf.addNum(3);
        double mid=mf.findMedian();
        System.out.print(mid);
    }
}
