package deliverable_2;

public class Room {

	protected String adjective;
	protected String object;
	protected String objectAdjective;
	protected String northDoorAdjective;
	protected String southDoorAdjective;
	
	protected boolean hasCoffee;
	protected boolean hasCream;
	protected boolean hasSugar;
	
	public Room(String adj, String obj, String objAdj, String northDoor, String southDoor) {
		
		adjective = adj;
		object = obj;
		objectAdjective = objAdj;
		northDoorAdjective = northDoor;
		southDoorAdjective = southDoor;
		
		hasCoffee = hasCream = hasSugar = false;
	}
	
	public String getAdjective() {
		
		return adjective;
	}
	
	public String getObject() {
		
		return object;
	}
	
	public String getObjectAdjective() {
		
		return objectAdjective;
	}
	
	public String getNorthDoorAdjective() {
		
		return northDoorAdjective;
	}
	
	public String getSouthDoorAdjective() {
		
		return southDoorAdjective;
	}
	
	public boolean hasCoffee() {
		
		return hasCoffee;
	}
	
	public boolean hasCream() {
		
		return hasCream;
	}
	
	public boolean hasSugar() {
		
		return hasSugar;
	}
	
	public void setHasCoffee(boolean coffee) {
		
		hasCoffee = coffee;
	}
	
	public void setHasCream(boolean cream) {
		
		hasCream = cream;
	}
	
	public void setHasSugar(boolean sugar) {
		
		hasSugar = sugar;
	}
}
