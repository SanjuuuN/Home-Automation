
import java.util.ArrayList;

public class House {

	private ArrayList<Room> rooms;

	//------------All parameter constructor-------------------------------
	public House(ArrayList<Room> rooms) {
		super();
		this.rooms = rooms;
	}

	
	//-----------------Setters and getters---------------------------------
	public ArrayList<Room> getRooms() {
		return rooms;
	}

	public void addRooms(Room room) {
		rooms.add(room);
	}
	
	
	//------------------Turn on device--------------------------------
	public boolean turnOnDevice(String room,String d) {
		for(Room r : rooms) {
			if(r.getType().equals(room)) {
				r.turnOnDevice(d);
				return true;
			}
		}
		return false;
	}
	//------------------Turn off device--------------------------------
	public boolean turnOffDevice(String room,String d) {
		for(Room r : rooms) {
			if(r.getType().equals(room)) {
				r.turnOffDevice(d);
				return true;
			}
		}
		return false;
	}
	//------------------Check status--------------------------------
	public void checkHouseStatus() {
		for(Room r : rooms) {
			r.roomStatus();
		}
	}
}
