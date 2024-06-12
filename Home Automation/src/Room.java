import java.util.ArrayList;

public class Room {

    private ArrayList<Device> device;
    private String type;

    //----------------All parameter Constructor---------------------
	public Room(String type,ArrayList ref) {
        this.type = type;
        this.device = ref;
    }

	
	//-----------------Setters and getters---------------------------------
    public ArrayList<Device> getDevice() {
        return device;
    }

    public String getType() {
        return type;
    }

    //--------------Adding device------------------------------------------
    public void addDevice(Device d) {
    	device.add(d);
    }

    //--------------------Removing device------------------------------------
    public void removeDevice(String deviceType) {
    	int flag = 0;
        for (Device dev : device) {
            if (dev.getDeviceType().equals(deviceType)) {
            	device.remove(dev);
                flag = 1;
                break;
            }
        }
        if(flag == 0) {
        	System.out.println("Device is not found..");
        }
    }

    //--------------------Turning on device----------------------------
    public void turnOnDevice(String deviceType) {
    	int flag = 0;
        for (Device dev : device) {
            if (dev.getDeviceType().equals(deviceType)) {
                dev.turnOn();
                flag = 1;
                break;
            }
        }
        if(flag == 0) {
        	System.out.println("Devive is not found..");
        }
    }

  //--------------------Turning off device----------------------------
    public void turnOffDevice(String deviceType) {
    	int flag = 0;
        for (Device dev : device) {
            if (dev.getDeviceType().equals(deviceType)) {
                dev.turnOff();
                flag = 1;
                break;
            }
        }
        if(flag == 0) {
        	System.out.println("Devive is not found..");
        }
    }
  //--------------------Check status of room----------------------------
    public void roomStatus() {
    	System.out.println("Room type : " + type);
    	for(Device d : device) {
    		d.allStatus();
    	}
    }
}
