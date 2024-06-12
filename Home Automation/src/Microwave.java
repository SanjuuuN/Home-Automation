
public class Microwave {

	String status;
	int temp;
	long startTime; // Start time when the device state changes
	long totalTimeOn; // Total time the device has been on
    long totalTimeOff; // Total time the device has been off
    boolean isDeviceOn; // Flag to indicate if the device is currently on or off
    
    
    //------------------------------No parameter Constructor---------------------------------------
    public Microwave() {
    	this.status = "Not given";
		this.temp = 0;
		this.startTime = 0;
		this.totalTimeOn = 0;
		this.totalTimeOff = 0;
		this.isDeviceOn = false;
	}
    
    
  //------------------------------All parameter Constructor---------------------------------------
    public Microwave(String status, int temp, long startTime, long totalTimeOn, long totalTimeOff, boolean isDeviceOn) {
		super();
		this.status = status;
		this.temp = temp;
		this.startTime = startTime;
		this.totalTimeOn = totalTimeOn;
		this.totalTimeOff = totalTimeOff;
		this.isDeviceOn = isDeviceOn;
	}


    
  //------------------------------Setters and getters---------------------------------------
	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public int getTemp() {
		return temp;
	}


	public void setTemp(int temp) {
		this.temp = temp;
	}


	public long getStartTime() {
		return startTime;
	}


	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}


	public long getTotalTimeOn() {
		return totalTimeOn;
	}


	public void setTotalTimeOn(long totalTimeOn) {
		this.totalTimeOn = totalTimeOn;
	}


	public long getTotalTimeOff() {
		return totalTimeOff;
	}


	public void setTotalTimeOff(long totalTimeOff) {
		this.totalTimeOff = totalTimeOff;
	}


	public boolean isDeviceOn() {
		return isDeviceOn;
	}


	public void setDeviceOn(boolean isDeviceOn) {
		this.isDeviceOn = isDeviceOn;
	}
    
    
}
