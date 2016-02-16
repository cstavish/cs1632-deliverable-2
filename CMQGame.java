package deliverable_2;

import java.util.ArrayList;

public class CMQGame {
	
	protected IOManager io;
	
	protected boolean foundCoffee = false;
	protected boolean foundCream = false;
	protected boolean foundSugar = false;
	protected boolean foundMeaning = false;
	
	protected ArrayList<Room> roomsList;
	protected int location;
	
	public CMQGame() {
		
		io = new IOManager(System.in, System.out);
		initRooms();
	}
	
	public CMQGame(IOManager ioManager) {
	
		io = ioManager;
		initRooms();
	}
	
	public void play() {
		
		io.println("Coffee Maker Quest 1.1\n");
		
		while (true) {
			
			char move = 0;
			
			setStage();
			move = promptForMove();
			
			switch(move) {
				
				case 'N':
					moveNorth();
					io.print("\n");
					break;
				
				case 'S':
					moveSouth();
					io.print("\n");
					break;
					
				case 'L':
					performLook();
					break;
					
				case 'I':
					displayInventory();
					break;
					
				case 'D':
					attemptDrink();
					return;
			}
		}

	}
	
	public void setStage() {
				
		Room currentRoom = roomsList.get(location);

		io.printf("You see a %s room.\n", currentRoom.getAdjective());
		io.printf("It has a %s %s.\n", currentRoom.getObjectAdjective(), currentRoom.getObject());
		if (currentRoom.getNorthDoorAdjective() != null) {
			
			io.printf("A %s door leads North.\n", currentRoom.getNorthDoorAdjective());
		}
		if (currentRoom.getSouthDoorAdjective() != null) {
			
			io.printf("A %s door leads South.\n", currentRoom.getSouthDoorAdjective());
		}
		
		io.print("\n");
	}
	
	public void displayInventory() {
		
		io.print("\n");
		
		if (foundCoffee) {
			
			io.println("You have a cup of delicious coffee.");
		}
		else {
			io.println("YOU HAVE NO COFFEE!");
		}
	
		if (foundCream) {
			
			io.println("You have some fresh cream.");
		} 
		else {
			io.println("YOU HAVE NO CREAM!");
		}
	
		if (foundSugar) {
			
			io.println("You have some tasty sugar.");
		}
		else {
			io.println("YOU HAVE NO SUGAR!");
		}
		
		io.print("\n");
	}

	public void performLook() {
		
		io.println("\n");
		
		Room currentRoom = roomsList.get(location);
		if (currentRoom.hasCoffee() ||
			currentRoom.hasCream() ||
			currentRoom.hasSugar()) {
			
			io.println("There might be something here...");
	
			if (currentRoom.hasCoffee()) {
				foundCoffee = true;
				io.println("You found some caffeinated coffee!");
			}
			
			if (currentRoom.hasCream()) {
				foundCream = true;
				io.println("You found some creamy cream!");
			}
			
			if (currentRoom.hasSugar()) {
				foundSugar = true;
				io.println("You found some sweet sugar!");
			}
		}
		else {
			io.println("You don't see anything out of the ordinary.");
		}
		
		io.print("\n");
	}
	
	public boolean attemptDrink() {
		
		io.print("\n");
		
		if (!foundCoffee && !foundCream && !foundSugar) {
			
			io.println("You drink the air as you have no coffee, sugar, or cream.");
			io.println("The air is invigorating, but not invigorating enough.  You cannot study.");
			io.println("You lose! The void awaits.");
			return false;
		}
		
		if (!foundCoffee && foundCream) {
			
			io.printf("You drink the %s cream, but without caffeine, you cannot study.\n", foundSugar ? "sweetened" : "");
			io.println("You lose! Death is imminent.");
			return false;
		}
		
		if (foundCoffee && !foundSugar) {
			
			io.println("Without sugar, the coffee is too bitter.  You cannot study.");
			io.println("You lose! The gin is almost gone.");
			return false;
		}
		
		if (foundCoffee && !foundCream) {
	
			io.println("Without cream, you get an ulcer and cannot study.");
			io.println("You lose! Death is ever closer.");
			return true;
		}
		
		if (foundCoffee && foundCream && foundSugar) {
	
			io.println("You drink the beverage and are ready to study.");
			io.println("You win!");
			return true;
		}
		
		return false;
	}
	
	public void moveNorth() {
		
		if (location < roomsList.size() - 1) {
			location++;
		}
	}
	
	public void moveSouth() {
		
		if (location > 0) {
			location--;
		}
	}
	
	public int getLocation() {
		
		return location;
	}
	
	private char promptForMove() {
		
		 return io.getValidatedInput("INSTRUCTIONS ", new String [] {"N", "S", "L", "I", "D"}, "What?", true).charAt(0);
	}
	
	private void initRooms() {
		
		roomsList = new ArrayList<Room>();
		roomsList.add(new Room("Small", "sofa", "Quaint", "Magenta", null));
		roomsList.add(new Room("Funny", "record player", "Sad", "Beige", "Massive"));
		roomsList.add(new Room("Refinanced", "pizza", "Tight", "Dead", "Smart"));
		roomsList.add(new Room("Dumb", "energy drink", "Flat", "Vivacious", "Slim"));
		roomsList.add(new Room("Bloodthirsty", "bag of money", "Beautiful", "Purple", "Sandy"));
		roomsList.add(new Room("Rough", "air hockey table", "Perfect", null, "Minimalist"));
		
		roomsList.get(1).setHasCream(true);
		roomsList.get(3).setHasCoffee(true);
		roomsList.get(4).setHasSugar(true);
		
		location = 0;
	}
	
}
