/* File name:   EncoderTerminal.java
 *
 * Written by:  Henry Hedden
 *
 * Description: Encode and decode text using a command line UI.
 *              
 *              
 * Challenges: 
 *
 * Time Spent: 
 *
 * Revision History:
 * Date:                By:      Action:
 * ---------------------------------------------------
 * 05/12/2017           HH       Created
 * 05/12/2017           HH       Created main loop w/ switch
 */
package encoder;

import java.util.Scanner;

/**
 * Driver class using command line.
 * @author Henry Hedden
 */
public class EncoderTerminal {
	
	private static final String HELP = "Options: [E]ncode | [D]ecode | E[X]it | [H]elp";
	private static String input;
	private static char action;
	
	/**
	 * Main method uses a loop to repeatedly prompt user for input,
	 * and a switch to process it.
	 * @param args the command line arguments (unused)
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Encoder/Decoder program\n" + HELP);
		
		do {
			System.out.print("Enter command: ");
			action = sc.next().toUpperCase().charAt(0);
			
			switch (action) {
				case 'D':
					sc.nextLine();
					System.out.print("Enter encoded text: ");
					input = sc.nextLine();
					System.out.printf("Decoded text: %s%n", Encoder.decode(input, Code.CAESAR));
					break;
				case 'E':
					sc.nextLine();
					System.out.print("Enter plaintext: ");
					input = sc.nextLine();
					System.out.printf("Encoded text: %s%n", Encoder.encode(input, Code.CAESAR));
					break;
				case 'H':
					System.out.println(HELP);
					break;
				case 'X':
					System.out.print("Are you sure you want to exit? (Y/N) ");
					action = sc.next().toUpperCase().charAt(0);
					break;
				default:
					System.err.printf("INVALID COMMAND: \"%c\"%n", action);
					System.out.println("Enter \"H\" for help.");
			}
		} while (action != 'Y');
	}
	
}
