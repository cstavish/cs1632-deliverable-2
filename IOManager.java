package deliverable_2;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class IOManager {

	protected Scanner scanner;
	protected PrintStream out;
	
	public IOManager(InputStream in, PrintStream out) {
		
		this.scanner = new Scanner(in);
		this.out = out;
	}
	
	public IOManager(Scanner in, PrintStream out) {
		
		this.scanner = in;
		this.out = out;
	}
	
	public IOManager() {
		
		this.scanner = new Scanner(System.in);
		this.out = System.out;
	}
	
	public void print(String text) {
		
		this.out.print(text);
	}
	
	public void println(String text) {
		
		this.out.println(text);
	}
	
	public void printf(String format, Object... args) {
		
		this.out.printf(format, args);
	}
	
	public String getValidatedInput(String prompt, String [] validInputs, String scold, boolean repeatOnFailure) {
		
		boolean validated = false;
		String userInput = null;
		
		print(prompt);
		
		print("(");
		for (int i = 0; i < validInputs.length - 1; i++) {
			
			print(validInputs[i] + ',');
		}
		print(validInputs[validInputs.length - 1]);
		print(") > ");
		
		do {
			
			// at least the second attempt, so previous input was invalid 
			if (userInput != null) {
				
				println(scold);
			}
			
			userInput = this.scanner.next();
			for (String input : validInputs) {
				
				if (input.equals(userInput)) {
					validated = true;
					return userInput;
				}
			}
		} while(!validated && repeatOnFailure);
		
		return null;
	}
	
}
