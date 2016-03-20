import java.util.*;

/**
 * Created by lizuyao2010 on 3/10/16.
 */
class Word {
    String val;
    int freq;
    public Word(String val,int freq)
    {
        this.val=val;
        this.freq=freq;
    }

    @Override
    public String toString() {
        return "Word{" +
                "val='" + val + '\'' +
                ", freq=" + freq +
                '}';
    }
}
public class TopK {
    public static void main(String[] args)
    {
        int k=2;
        PriorityQueue<Word> pq= new PriorityQueue<>(k, new Comparator<Word>() {
            @Override
            public int compare(Word w1, Word w2) {
                return Integer.compare(w1.freq, w2.freq);
            }
        });
        Word w1=new Word("a",2);
        Word w2=new Word("b",4);
        Word w3=new Word("c",3);
        Word w4=new Word("d",5);
        List<Word> wordsStream = new ArrayList<>();
        wordsStream.add(w1);
        wordsStream.add(w2);
        wordsStream.add(w3);
        wordsStream.add(w4);
        for (Word w: wordsStream) {
            if (pq.size() < k) {
                pq.add(w);
            }
            else
            {
                if (w.freq>pq.peek().freq)
                {
                    pq.poll();
                    pq.add(w);
                }
            }
        }
        Stack<Word> wordsStack=new Stack<>();
        while(!pq.isEmpty())
        {
            Word c=pq.poll();
            wordsStack.add(c);
//            System.out.println(c);
        }
        while(!wordsStack.isEmpty())
        {
            System.out.println(wordsStack.pop());
        }
    }

}
