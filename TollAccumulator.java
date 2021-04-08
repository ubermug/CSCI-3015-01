import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TimeZone;

public class TollAccumulator {
	//Method to generate License Plate
	public String generatePlate() {
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
	public BigDecimal generatePrice() {
		MathContext m = new MathContext(2);
		BigDecimal price = new BigDecimal(Math.random(), m);
    	return price;
	}
	
	//Generate new unix time stamp by getting yesterdays timestamp at midnight and adding a number of seconds to it
	public long generateStartingTimeStamp() {
		Calendar c = Calendar.getInstance(TimeZone.getTimeZone("America/New_York"));
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		long timeStamp = c.getTimeInMillis();
		return timeStamp;
	}
	
	//Generate a List of tolls
	public List<Toll> populateTollList(int numberOfTolls, List<Toll> tollList){
		//Set the first possible timestamp of the day
		long time = generateStartingTimeStamp();
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
			tollList.add(newToll);
		}
		return tollList;
	}
	
	//Generate a List of tolls
	public Map<Long, Toll> populateTollMap(int numberOfTolls, Map<Long, Toll> tollMap){
		//Set the first possible timestamp of the day
		long time = generateStartingTimeStamp();
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
			tollMap.put(newToll.getTimeStamp(), newToll);
		}
		return tollMap;
	}
}
