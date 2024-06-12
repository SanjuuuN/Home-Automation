import java.time.Duration;
import java.time.LocalDateTime;

public class VentilationFan implements Device{
	    private boolean status;
	    private LocalDateTime lastOnTimestamp;
	    private LocalDateTime lastOffTimestamp;
	    private Duration totalOnDuration;
	    private Duration totalOffDuration;

	    //------------All parameter Constructor-------------------------------
	    public VentilationFan() {
	        this.status = false;
	        this.lastOnTimestamp = null;
	        this.lastOffTimestamp = null;
	        this.totalOnDuration = Duration.ZERO;
	        this.totalOffDuration = Duration.ZERO;
	    }
	    //-----------------------Updating Status------------------------------
	    public boolean isStatus() {
	        return status;
	    }

	    public void setStatus(boolean status) {
	    	this.status = status;
	        if (status) {
	            lastOnTimestamp = LocalDateTime.now();
	        } else {
	            lastOffTimestamp = LocalDateTime.now();
	            totalOnDuration = totalOnDuration.plus(Duration.between(lastOnTimestamp, lastOffTimestamp));
	        }
	    }

	    
	    //--------------------------Interface methods----------------------------
	    @Override
	    public void turnOn() {
	    	if (!status) {
	            status = true;
	            System.out.println("Ventilation Fan turned on.");
	            lastOnTimestamp = LocalDateTime.now();
	        }
	    }

	    @Override
	    public void turnOff() {
	        if (status) {
	            status = false;
	            System.out.println("Ventilation Fan turned off.");
	            lastOffTimestamp = LocalDateTime.now();
	            Duration offDuration = Duration.between(lastOnTimestamp, lastOffTimestamp);
	            totalOnDuration = totalOnDuration.plus(offDuration);
	            totalOffDuration = totalOffDuration.plus(offDuration); // Update off duration
	        }
	    }

	    @Override
	    public String getDeviceType() {
	        return "Ventilation Fan";
	    }

	    public void allStatus() {
	    	System.out.println("Device Name : " + this.getDeviceType());
	        System.out.println("Status : " + status);
	        System.out.println("Total Time On: " + formatDuration(totalOnDuration));
	        System.out.println("Total Time Off: " + formatDuration(totalOffDuration));
	    }
	    
	    private String formatDuration(Duration duration) {
	        long hours = duration.toHours();
	        long minutes = duration.toMinutesPart();
	        long seconds = duration.toSecondsPart();
	        return hours + " hours " + minutes + " minutes " + seconds + " seconds";
	    }


}
