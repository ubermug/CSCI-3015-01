import java.text.*;
import java.util.*;

public class TimeTester {
    static TollAccumulator myTollAcc;
    // Creating date format
    static final DateFormat simple = new SimpleDateFormat("dd MMM yyyy HH:mm:ss");

    public static void DataGenerationRanker(long ArrayGenerationTime, long LinkedListGenerationTime,long HashMapGenerationTime)
    {
        String [] types= {"Array","LinkedList","Hashmap"};
        Long [] durations= {ArrayGenerationTime,LinkedListGenerationTime,HashMapGenerationTime};

        for (int i=0; i<durations.length-1;i++)
        {
            for (int j = 1; j < durations.length; j++)
            {
                if (durations[j]<durations[i])
                {
                    long temp=durations[i];
                    String hold=types[i];
                    durations[i]=durations[j];
                    durations[j]=temp;
                    types[i]=types[j];
                    types[j]=hold;

                }
            }
        }
        System.out.println();
        System.out.println("THE DATA GENERATION TIMES ARE SORTED BELOW IN LOW TO HIGH (TIME IN NANOSEC.)");
        for (int i=0; i<types.length;i++)
        {
            System.out.println(""+(i+1)+"."+types[i]+", "+"Time(ns): "+durations[i]);
        }
    }

    public static void main(String args[]) {
        myTollAcc = new TollAccumulator();

        System.out.println("------------------- DATA STRUCTURE GENERATION -------------------------");
        long start;
        long end;
        int size=100000;

        List<Toll> tollArray = new ArrayList<>();
        start = System.nanoTime();
        List<Toll> tollList=myTollAcc.populateTollList(size, tollArray);
        end = System.nanoTime();
        long ArrayGenerationTime=end-start;
        System.out.println("Took " + (end - start) + " ns to generate "+ size +" tolls with an Array List");

        List<Toll> tollLinked = new LinkedList<>();
        start = System.nanoTime();
        myTollAcc.populateTollList(size, tollLinked);
        end = System.nanoTime();
        long LinkedListGenerationTime=end-start;
        System.out.println("Took " + (end - start) + " ns to generate "+ size +" tolls with an Linked List");

        Map<Long, Toll> tollMap = new Hashtable<>();
        start = System.nanoTime();
        myTollAcc.populateTollMap(size, tollMap);
        end = System.nanoTime();
        long HashMapGenerationTime=end-start;
        System.out.println("Took " + (end - start) + " ns to generate "+ size +" tolls with a Hash Table");

        // Creating date from milliseconds
        // using Date() constructor
        Date result = new Date(myTollAcc.generateStartingTimeStamp());

        // Formatting Date according to the given format
        // Test code to print out start date and ensure that it was
        // built as intended
        //System.out.println(simple.format(result));

        /// REAZ (START) ///
        System.out.println("------------------- DATA GENERATION TIMER ---------------------------");
        DataGenerationRanker(ArrayGenerationTime,LinkedListGenerationTime,HashMapGenerationTime);

        System.out.println("------------------- SEARCH TIMER ---------------------------");
        TollSearch mySearch= new TollSearch();
        mySearch.SearchRankerAlternate(tollArray,tollLinked,tollMap);

        System.out.println("------------------- DELETE TIMER ---------------------------");
        TollDelete myDelete= new TollDelete();
        myDelete.DeleteRanker(tollArray,tollLinked,tollMap);

        /// REAZ (END) ///
    }
}
