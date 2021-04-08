package group_project;

import java.math.*;
import java.text.*;
import java.time.*;
import java.util.*;

public class toll_accumulator {

	//Make a new Toll object that we can add to a loop to generate tolls
	public class Toll {
		long timestamp;
		BigDecimal price;
		String licensePlate;
		
		public Toll() {}
		
		public Toll(long timestamp, BigDecimal price, String licensePlate) {
			this.timestamp = timestamp;
			this.price = price;
			this.licensePlate = licensePlate;
		}
		
		public long getTimeStamp() {
			return timestamp;
		}
		
		public BigDecimal getPrice() {
			return price;
		}
		
		public String getLicensePlate() {
			return licensePlate;
		}
		
		public void setTimeStamp(long timestamp) {
			this.timestamp = timestamp;
		}
		
		public void setPrice(BigDecimal price) {
			this.price = price;
		}
		
		public void setLicensePlate(String licensePlate) {
			this.licensePlate = licensePlate;
		}
	}
	
	
	//Method to generate License Plate
	public static String generatePlate() {
		String newPlate = "";
		for (int j = 0; j < 6; j++) {
			Random r = new Random();
			char c = (char)(r.nextInt(26) + 'a');
			newPlate = newPlate + c;
			newPlate = newPlate.toUpperCase();
		}
		return newPlate;
	}
	
	//Method to generate Toll Price
	public static BigDecimal generatePrice() {
		MathContext m = new MathContext(2);
		BigDecimal price = new BigDecimal(Math.random(), m);
    	return price;
	}
	
	//Generate new unix time stamp by getting yesterdays timestamp at midnight and adding a number of seconds to it
	public static long generateStartingTimeStamp() {
		Calendar c = Calendar.getInstance(TimeZone.getTimeZone("America/New_York"));
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		long timeStamp = c.getTimeInMillis();
		return timeStamp;
	}
	
	//Generate a Array list of tolls
	public ArrayList populateTollSet(int numberOfTolls){
		//Set the first possible timestamp of the day
		long time = generateStartingTimeStamp();
		ArrayList<Toll> tollSet = new ArrayList<>();
		for (int i = 0; i < numberOfTolls; i++) {
			// Add up to 10 seconds to the previous time.
			// If we start at midnight, and no more than 10 seconds to the previous car
			// we can do up to 8640 vehicles in a single day in a worst case scenario
			// if they all take the maximum amount of time to get through the toll
			Random rand = new Random();
			long addSeconds = rand.nextInt(10);
			time = time + addSeconds;
			Toll newToll = new Toll();
			newToll.setLicensePlate(generatePlate());
			newToll.setPrice(generatePrice());
			newToll.setTimeStamp(time);
			tollSet.add(newToll);
		}
		
		return tollSet;
	}
	public static void main(String args[]) {
		System.out.println(generatePrice());
		System.out.println(generatePlate());
		// Creating date format
        DateFormat simple = new SimpleDateFormat("dd MMM yyyy HH:mm:ss");
  
        // Creating date from milliseconds
        // using Date() constructor
        Date result = new Date(generateStartingTimeStamp());
  
        // Formatting Date according to the
        // given format
        System.out.println(simple.format(result));
		System.out.println(generateStartingTimeStamp());
		
	}

	
}
