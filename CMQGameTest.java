package deliverable_2;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;

public class CMQGameTest {

	@Test
	
	// Test that an attempt to drink with an empty inventory fails and
	// results in the end of the game
	
	public void testAttemptDrinkEmptyInventory() {
		
		IOManager io = mock(IOManager.class);
		when(io.getValidatedInput("INSTRUCTIONS ", new String [] {"N", "S", "L", "I", "D"}, "What?", true))
			.thenReturn("D");
		
		CMQGame game = new CMQGame(io);
		
		game.play();
		
		assertFalse(game.attemptDrink());
	}
	
	@Test
	
	// Test that an attempt to drink with only cream in the inventory
	// fails and results in the end of the game
	
	public void testAttemptDrinkCreamOnly() {
		
		IOManager io = mock(IOManager.class);
		when(io.getValidatedInput("INSTRUCTIONS ", new String [] {"N", "S", "L", "I", "D"}, "What?", true))
			.thenReturn("L")
			.thenReturn("D");
		
		CMQGame game = new CMQGame(io);
		
		game.play();
		
		assertFalse(game.attemptDrink());
	}
	
	@Test
	
	// Test that an attempt to drink with only sugar in the inventory
	// fails and results in the end of the game
	
	public void testAttemptDrinkSugarOnly() {
		
		IOManager io = mock(IOManager.class);
		when(io.getValidatedInput("INSTRUCTIONS ", new String [] {"N", "S", "L", "I", "D"}, "What?", true))
			.thenReturn("N")
			.thenReturn("N")
			.thenReturn("N")
			.thenReturn("N")
			.thenReturn("N")
			.thenReturn("D");
		
		CMQGame game = new CMQGame(io);
		
		game.play();
		
		assertFalse(game.attemptDrink());
	}
	
	@Test
	
	// Test that an attempt to drink with only cream and sugar in the inventory
	// fails and results in the end of the game
	
	public void testAttemptDrinkCreamAndSugar() {
		
		IOManager io = mock(IOManager.class);
		when(io.getValidatedInput("INSTRUCTIONS ", new String [] {"N", "S", "L", "I", "D"}, "What?", true))
			.thenReturn("N")
			.thenReturn("L")
			.thenReturn("N")
			.thenReturn("N")
			.thenReturn("N")
			.thenReturn("N")
			.thenReturn("L")
			.thenReturn("D");
		
		CMQGame game = new CMQGame(io);
		
		game.play();
		
		assertFalse(game.attemptDrink());
	}
	
	@Test
	
	// Test that an attempt to drink with a full inventory
	// succeeds and results in the end of the game
	
	public void testAttemptDrinkFullInventory() {
		
		IOManager io = mock(IOManager.class);
		when(io.getValidatedInput("INSTRUCTIONS ", new String [] {"N", "S", "L", "I", "D"}, "What?", true))
			.thenReturn("N")
			.thenReturn("L") // get cream
			.thenReturn("N")
			.thenReturn("N")
			.thenReturn("L") // get coffee
			.thenReturn("N")
			.thenReturn("L") // get sugar
			.thenReturn("D");
		
		CMQGame game = new CMQGame(io);
		
		game.play();
		
		assertTrue(game.attemptDrink());
	}
	
	@Test(expected=RuntimeException.class)
	
	// Test that displaying the inventory when there is
	// no coffee informs the user of the missing coffee
	
	public void testInventoryNoCoffee() {
		
		IOManager io = mock(IOManager.class);
		when(io.getValidatedInput("INSTRUCTIONS ", new String [] {"N", "S", "L", "I", "D"}, "What?", true))
			.thenReturn("I")
			.thenReturn("D");
	
		doThrow(new RuntimeException()).when(io).println("YOU HAVE NO COFFEE!");
		
		CMQGame game = new CMQGame(io);
		
		game.play();
	}
	
	@Test(expected=RuntimeException.class)
	
	// Test that displaying the inventory when there is
	// no cream informs the user of the missing cream
	
	public void testInventoryNoCream() {
		
		IOManager io = mock(IOManager.class);
		when(io.getValidatedInput("INSTRUCTIONS ", new String [] {"N", "S", "L", "I", "D"}, "What?", true))
			.thenReturn("I")
			.thenReturn("D");
	
		doThrow(new RuntimeException()).when(io).println("YOU HAVE NO CREAM!");
		
		CMQGame game = new CMQGame(io);
		
		game.play();
	}
	
	@Test(expected=RuntimeException.class)
	
	// Test that displaying the inventory when there is
	// no sugar informs the user of the missing sugar
	
	public void testInventoryNoSugar() {
		
		IOManager io = mock(IOManager.class);
		when(io.getValidatedInput("INSTRUCTIONS ", new String [] {"N", "S", "L", "I", "D"}, "What?", true))
			.thenReturn("I")
			.thenReturn("D");
	
		doThrow(new RuntimeException()).when(io).println("YOU HAVE NO SUGAR!");
		
		CMQGame game = new CMQGame(io);
		
		game.play();
	}

	@Test(expected=RuntimeException.class)
	
	// Test that displaying the inventory when there is
	// coffee informs the user of the present coffee
	
	public void testInventoryCoffee() {
		
		IOManager io = mock(IOManager.class);
		when(io.getValidatedInput("INSTRUCTIONS ", new String [] {"N", "S", "L", "I", "D"}, "What?", true))
			.thenReturn("N")
			.thenReturn("N")
			.thenReturn("N")
			.thenReturn("L") // get coffee
			.thenReturn("I")
			.thenReturn("D");
	
		doThrow(new RuntimeException()).when(io).println("You have a cup of delicious coffee.");
		
		CMQGame game = new CMQGame(io);
		
		game.play();
	}
	
	
	// Test that displaying the inventory when there is
	// cream informs the user of the present cream
	
	@Test(expected=RuntimeException.class)
	public void testInventoryCream() {
		
		IOManager io = mock(IOManager.class);
		when(io.getValidatedInput("INSTRUCTIONS ", new String [] {"N", "S", "L", "I", "D"}, "What?", true))
			.thenReturn("N")
			.thenReturn("L") // get cream
			.thenReturn("I")
			.thenReturn("D");
	
		doThrow(new RuntimeException()).when(io).println("You have some fresh cream.");
		
		CMQGame game = new CMQGame(io);
		
		game.play();
	}
	
	@Test(expected=RuntimeException.class)
	
	// Test that displaying the inventory when there is
	// sugar informs the user of the present sugar
	
	public void testInventorySugar() {
		
		IOManager io = mock(IOManager.class);
		when(io.getValidatedInput("INSTRUCTIONS ", new String [] {"N", "S", "L", "I", "D"}, "What?", true))
			.thenReturn("N")
			.thenReturn("N")
			.thenReturn("N")
			.thenReturn("N")
			.thenReturn("L") // get sugar
			.thenReturn("I")
			.thenReturn("D");
	
		doThrow(new RuntimeException()).when(io).println("You have some tasty sugar.");
		
		CMQGame game = new CMQGame(io);
		
		game.play();
	}

	@Test(expected=RuntimeException.class)
	
	// Test that attempting a look in an empty room
	// correctly informs the user that the room is empty
	
	public void testLookEmpty() {
		
		IOManager io = mock(IOManager.class);
		when(io.getValidatedInput("INSTRUCTIONS ", new String [] {"N", "S", "L", "I", "D"}, "What?", true))
			.thenReturn("L")
			.thenReturn("D");
	
		doThrow(new RuntimeException()).when(io).println("You don't see anything out of the ordinary.");
		
		CMQGame game = new CMQGame(io);
		
		game.play();
	}

	@Test(expected=RuntimeException.class)
	
	// Test that attempting a look in a room with cream
	// correctly informs the user that the room has cream
	
	public void testLookCream() {
		
		IOManager io = mock(IOManager.class);
		when(io.getValidatedInput("INSTRUCTIONS ", new String [] {"N", "S", "L", "I", "D"}, "What?", true))
			.thenReturn("N")
			.thenReturn("L")
			.thenReturn("D");
	
		doThrow(new RuntimeException()).when(io).println("You found some creamy cream!");
		
		CMQGame game = new CMQGame(io);
		
		game.play();
	}

	@Test(expected=RuntimeException.class)
	
	// Test that attempting a look in a room with coffee
	// correctly informs the user that the room has coffee
	
	public void testLookCoffee() {
		
		IOManager io = mock(IOManager.class);
		when(io.getValidatedInput("INSTRUCTIONS ", new String [] {"N", "S", "L", "I", "D"}, "What?", true))
			.thenReturn("N")
			.thenReturn("N")
			.thenReturn("N")
			.thenReturn("L") // get coffee
			.thenReturn("D");
	
		doThrow(new RuntimeException()).when(io).println("You found some caffeinated coffee!");
		
		CMQGame game = new CMQGame(io);
		
		game.play();
	}

	@Test(expected=RuntimeException.class)
	
	// Test that attempting a look in a room with sugar
	// correctly informs the user that the room has sugar
	
	public void testLookSugar() {
		
		IOManager io = mock(IOManager.class);
		when(io.getValidatedInput("INSTRUCTIONS ", new String [] {"N", "S", "L", "I", "D"}, "What?", true))
			.thenReturn("N")
			.thenReturn("N")
			.thenReturn("N")
			.thenReturn("N")
			.thenReturn("L") // get sugar
			.thenReturn("D");
	
		doThrow(new RuntimeException()).when(io).println("You found some sweet sugar!");
		
		CMQGame game = new CMQGame(io);
		
		game.play();
	}
	
	@Test
	
	// Test that moving north updates the player's location correctly
	
	public void testMoveNorth() {
		
		IOManager io = mock(IOManager.class);
		when(io.getValidatedInput("INSTRUCTIONS ", new String [] {"N", "S", "L", "I", "D"}, "What?", true))
			.thenReturn("N")
			.thenReturn("D");
		
		CMQGame game = new CMQGame(io);
			
		game.play();
		
		assertEquals(game.getLocation(), 1);
	}
	
	@Test
	
	// Test that moving north does not update the player location
	// when there is no northern room
	
	public void testMoveNorthAtEnd() {
		
		IOManager io = mock(IOManager.class);
		when(io.getValidatedInput("INSTRUCTIONS ", new String [] {"N", "S", "L", "I", "D"}, "What?", true))
			.thenReturn("N")
			.thenReturn("N")
			.thenReturn("N")
			.thenReturn("N")
			.thenReturn("N")
			.thenReturn("N")
			.thenReturn("N")
			.thenReturn("D");
		
		CMQGame game = new CMQGame(io);
			
		game.play();
		
		assertEquals(game.getLocation(), 5);
	}
	
	@Test
	
	// Test that moving north updates the player's location correctly
	
	public void testMoveSouth() {
		
		IOManager io = mock(IOManager.class);
		when(io.getValidatedInput("INSTRUCTIONS ", new String [] {"N", "S", "L", "I", "D"}, "What?", true))
			.thenReturn("N")
			.thenReturn("S")
			.thenReturn("D");
		
		CMQGame game = new CMQGame(io);
			
		game.play();
		
		assertEquals(game.getLocation(), 0);
	}
	
	@Test
	
	// Test that moving south does not update the player location
	// when there is no southern room
	
	public void testMoveSouthAtEnd() {
		
		IOManager io = mock(IOManager.class);
		when(io.getValidatedInput("INSTRUCTIONS ", new String [] {"N", "S", "L", "I", "D"}, "What?", true))
			.thenReturn("S")
			.thenReturn("D");
		
		CMQGame game = new CMQGame(io);
			
		game.play();
		
		assertEquals(game.getLocation(), 0);
	}
	
	@Test(expected=RuntimeException.class)
	
	// Test that the program displays output on game start
	
	public void testSetStage() {
		
		IOManager io = mock(IOManager.class);
		
		doThrow(new RuntimeException()).when(io).println(anyString());
		
		CMQGame game = new CMQGame(io);
			
		game.play();		
	}
	
	@Test
	
	// Test that the game ends upon the drink action being performed
	
	public void testPlay() {
		IOManager io = mock(IOManager.class);
		when(io.getValidatedInput("INSTRUCTIONS ", new String [] {"N", "S", "L", "I", "D"}, "What?", true))
			.thenReturn("D");
		
		CMQGame game = new CMQGame(io);
			
		game.play();

		// game ended, pass
	}
}
