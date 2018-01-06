/* File name:   Code.java
 *
 * Written by:  Henry Hedden
 *
 * Description: All codes available.
 *              
 * Challenges: None
 *
 * Time Spent: 1.5 hours
 *
 * Revision History:
 * Date:                By:      Action:
 * ---------------------------------------------------
 * 05/12/2017           HH       Created
 * 05/12/2017           HH       Added `toString` method
 */
package encoder;

/**
 * All codes available.
 * @author Henry Hedden
 */
public enum Code {
	
	CAESAR,
	POLYBIUS,
	TRIMETHIUS,
	VIGENERE;
	
	/**
	 * Display code as a String.
	 * @return the name of the code
	 */
	@Override
	public String toString() {
		switch (this) {
			case CAESAR:     return "Caesar";
			case POLYBIUS:   return "Polybius";
			case TRIMETHIUS: return "Trimethius";
			case VIGENERE:   return "Vigenere";
			default:         return null;
		}
	}
	
}
