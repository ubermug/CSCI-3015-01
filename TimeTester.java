import java.text.*;
import java.util.*;

public class TimeTester {
	static TollAccumulator myTollAcc;
	// Creating date format
    static final DateFormat simple = new SimpleDateFormat("dd MMM yyyy HH:mm:ss");
	public static void main(String args[]) {
		myTollAcc = new TollAccumulator();
		
        long start;
        long end;
        List<Toll> tollArray = new ArrayList<>();
        start = System.nanoTime();
        myTollAcc.populateTollList(100, tollArray);
        end = System.nanoTime();
        System.out.println("Took " + (end - start) + "ns to generate 100 tolls with an ArrayList");
        
        List<Toll> tollLinked = new LinkedList<>();
        start = System.nanoTime();
        myTollAcc.populateTollList(100, tollLinked);
        end = System.nanoTime();
        System.out.println("Took " + (end - start) + "ns to generate 100 tolls with an LinkedList");
        
        Map<Long, Toll> tollMap = new Hashtable<>();
        start = System.nanoTime();
        myTollAcc.populateTollMap(100, tollMap);
        end = System.nanoTime();
        System.out.println("Took " + (end - start) + "ns to generate 100 tolls with an Hashtable");
        
        // Creating date from milliseconds
        // using Date() constructor
        Date result = new Date(myTollAcc.generateStartingTimeStamp());
  
        // Formatting Date according to the
        // given format
        System.out.println(simple.format(result));
		System.out.println(myTollAcc.generateStartingTimeStamp());
		
	}
}
