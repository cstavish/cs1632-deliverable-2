package deliverable_2;

import static org.junit.Assert.*;

import org.junit.Test;

import static org.mockito.Mockito.*;

import java.io.PrintStream;
import java.util.Scanner;

public class IOManagerTest {

	@Test(expected=RuntimeException.class)
	
	// Test that output is written correctly
	
	public void testPrint() {
		
		PrintStream out = mock(PrintStream.class);
		IOManager io = new IOManager(System.in, out);
		
		doThrow(new RuntimeException()).when(out).print("test string");
	
		io.print("test string");
	}
	
	@Test(expected=RuntimeException.class)
	
	// Test that output is written correctly
	
	public void testPrintln() {

		PrintStream out = mock(PrintStream.class);
		IOManager io = new IOManager(System.in, out);
		
		doThrow(new RuntimeException()).when(out).println("test string");
	
		io.println("test string");
	}

	@Test(expected=RuntimeException.class)
	
	// Test that output is written correctly
	
	public void testPrintf() {
	
		PrintStream out = mock(PrintStream.class);
		IOManager io = new IOManager(System.in, out);
		
		doThrow(new RuntimeException()).when(out).printf("test %s", "string");
	
		io.printf("test %s", "string");
	}

/*
 * Mockito cannot mock/spy class java.util.Scanner
 * 
	@Test
	public void testGetValidatedInputGoodInput() {
	
		Scanner in = mock(Scanner.class);
		PrintStream out = mock(PrintStream.class);
		
		when(in.next()).thenReturn("N");
		
		IOManager io = new IOManager(in, out);
		String input = io.getValidatedInput("INSTRUCTIONS ", new String [] {"N", "S", "L", "I", "D"}, "What?", true);
		
		assertEquals(input, "N");
	}

	@Test
	public void testGetValidatedInputBadInput() {
	
		Scanner in = mock(Scanner.class);
		PrintStream out = mock(PrintStream.class);
		
		when(in.next()).thenReturn("batman symbol", "N");
		
		IOManager io = new IOManager(in, out);
		String input = io.getValidatedInput("INSTRUCTIONS ", new String [] {"N", "S", "L", "I", "D"}, "What?", true);
		
		assertEquals(input, "N");
	}
*/
}
