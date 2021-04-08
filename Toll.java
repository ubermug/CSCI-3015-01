import java.math.BigDecimal;

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
