/* File name:   Encoder.java
 *
 * Written by:  Henry Hedden
 *
 * Description: Provides static methods for encoding and decoding
 *              
 * Challenges: Manipulating char values
 *
 * Time Spent: 10 hours
 *
 * Revision History:
 * Date:                By:      Action:
 * ---------------------------------------------------
 * 05/12/2017           HH       Created
 * 05/12/2017           HH       Added `encode` and `decode` stubs
 * 05/12/2017           HH       Completed `encode` and `decode`
 * 05/12/2017           HH       ...
 * 08/12/2017           HH       Added methods for other ciphers
 * 09/12/2017           HH       Fixed methods for Vigenère
 * 09/12/2017           HH       Added Trimethius cipher
 * 12/12/2017           HH       Removed debugging statements
 */
package encoder;

/**
 * Contains static methods for encoding and decoding.
 * @author Henry Hedden
 */
public class Encoder {
	
	private static final char CAESAR_KEY = 3; // Offset for Caesar cipher
	private static final String VIGENERE_KEY = "CIPHER"; // Default key for Vigenère
	
	/**
	 * Encode a plaintext String.
	 * @param plaintext text to be encoded
	 * @param c the code to use
	 * @return encoded text
	 */
	protected static String encode(String plaintext, Code c) {
		switch (c) {
			case CAESAR:	return encodeCaesar(plaintext);
			case POLYBIUS:	return encodePolybius(plaintext);
			case TRIMETHIUS:	return encodeTrimethius(plaintext);
			case VIGENERE:	return encodeVigenere(plaintext, VIGENERE_KEY);
			default: return null;
		}
	}
	
	/**
	 * Decode an encoded String.
	 * @param codedText text to be decoded
	 * @param c the code to use
	 * @return plaintext
	 */
	protected static String decode(String codedText, Code c) {
		String plaintext = "";
		int a;
		switch (c) {
			case CAESAR:	return decodeCaesar(codedText);
			case POLYBIUS:	return decodePolybius(codedText);
			case TRIMETHIUS:	return decodeTrimethius(codedText);
			case VIGENERE:	return decodeVigenere(codedText, VIGENERE_KEY);
			default: return null;
		}
	}
	
	/**
	 * Uses the Caesar cipher to encode text.
	 * @param plaintext String to be encoded
	 * @return String encoded in Caesar cipher
	 */
	protected static String encodeCaesar(String plaintext) {
		plaintext = plaintext.toUpperCase();
		String codedText = "";
		int a;
		for (int i = 0; i < plaintext.length(); i++)
			if (plaintext.charAt(i) >= 65 && plaintext.charAt(i) <= 90) {
				a = plaintext.charAt(i) + CAESAR_KEY;
				if (a > 90) a -= 26;
				codedText += (char)a;
			} else
				codedText += plaintext.charAt(i);
		return codedText;
	}
	
	/**
	 * Decode text encoded in the Caesar cipher
	 * @param codedText String encoded in Caesar cipher
	 * @return decoded String
	 */
	protected static String decodeCaesar(String codedText) {
		String plaintext = "";
		int a;
		for (int i = 0; i < codedText.length(); i++)
			if (codedText.charAt(i) >= 65 && codedText.charAt(i) <= 90) {
				a = codedText.charAt(i) - CAESAR_KEY;
				if (a < 65) a += 26;
				plaintext += (char)a;
			} else
				plaintext += codedText.charAt(i);
		return plaintext;
	}
	
	protected static String encodePolybius(String plaintext) {
		// This cipher is not yet supported
		throw new UnsupportedOperationException("Not supported yet.");
	}
	
	/**
	 * Encode using Trimethius, a simple polyalphabetic cipher which
	 * iterates over a series of alphabets.
	 * @param plaintext text to be encoded
	 * @return text encoded in Trimethius
	 */
	protected static String encodeTrimethius(String plaintext) {
		plaintext = plaintext.toUpperCase();
		String codedText = "";
		int a;
		for (int i = 0, j = 0; i < plaintext.length(); i++)
			if (plaintext.charAt(i) >= 65 && plaintext.charAt(i) <= 90) {
				a = plaintext.charAt(i) + j;
				if (a > 90) a -= 26;
				if (++j > 25) j = 0;
				codedText += (char)a;
			} else
				codedText += plaintext.charAt(i);
		return codedText;
	}
	
	/**
	 * Encode text using Vigenère, a simple polyaphabetic cipher
	 * which uses a word as a key.
	 * @param plaintext String to be encoded
	 * @param key key word
	 * @return  String encoded in Vigenère cipher
	 */
	protected static String encodeVigenere(String plaintext, String key) {
		plaintext = plaintext.toUpperCase();
		key = key.toUpperCase();
		String codedText = "";
		int a;
		for (int i = 0, j = 0; i < plaintext.length(); i++)
			if (plaintext.charAt(i) >= 65 && plaintext.charAt(i) <= 90) {
				a = plaintext.charAt(i) + (key.charAt(j) - 65);
				if (++j == key.length()) j = 0;
				if (a > 90) a -= 26;
				codedText += (char)a;
			} else
				codedText += plaintext.charAt(i);
		return codedText;
	}
	
	protected static String decodePolybius(String codedText) {
		// This cipher is not yet supported
		throw new UnsupportedOperationException("Not supported yet.");
	}
	
	/**
	 * Decode text encoded in the Trimethius cipher.
	 * @param codedText text encoded in Trimethius
	 * @return decoded String
	 */
	protected static String decodeTrimethius(String codedText) {
		codedText = codedText.toUpperCase();
		String plaintext = "";
		int a;
		for (int i = 0, j = 0; i < codedText.length(); i++)
			if (codedText.charAt(i) >= 65 && codedText.charAt(i) <= 90) {
				a = codedText.charAt(i) - j;
				if (a < 65) a += 26;
				if (++j > 25) j = 0;
				plaintext += (char)a;
			} else
				plaintext += codedText.charAt(i);
		return plaintext;
	}
	
	/**
	 * Decode text encoded in the Vigenère cipher using a key word.
	 * @param codedText String encoded in Vigenère
	 * @param key key word
	 * @return decoded String
	 */
	protected static String decodeVigenere(String codedText, String key) {
		codedText = codedText.toUpperCase();
		key = key.toUpperCase();
		String plainText = "";
		int a;
		for (int i = 0, j = 0; i < codedText.length(); i++)
			if (codedText.charAt(i) >= 65 && codedText.charAt(i) <= 90) {
				a = codedText.charAt(i) - (key.charAt(j) - 65);
				if (++j == key.length()) j = 0;
				if (a < 65) a += 26;
				plainText += (char)a;
			} else
				plainText += codedText.charAt(i);
		return plainText;
	}
	
}
