/*Class: CMSC203 CRN 20984
 Program: Assignment 3
 Instructor: Ahmed Tarek
 Summary of Description: This program encrypts
 Due Date: 09/19/2023 
 Integrity Pledge: I pledge that I have completed the programming assignment independently.
 I have not copied the code from a student or any source.
 Student Name: Ricardo Hernandez
*/

/**
* This is a utility class that encrypts and decrypts a phrase using two
* different approaches. The first approach is called the Caesar Cipher and is a
* simple “substitution cipher” where characters in a message are replaced by a
* substitute character. The second approach, due to Giovan Battista Bellaso,
* uses a key word, where each character in the word specifies the offset for
* the corresponding character in the message, with the key word wrapping around
* as needed.
*
* @author Farnaz Eivazi
* @version 7/16/2022
*/
public class CryptoManager {
	
	private static final char LOWER_RANGE = ' ';
	private static final char UPPER_RANGE = '_';
	private static final int RANGE = UPPER_RANGE - LOWER_RANGE + 1;
	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes
	 * according to the LOWER_RANGE and UPPER_RANGE characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	public static boolean isStringInBounds (String plainText) {
		Boolean stringInBounds = true;
		//Scan each character of plainText
		for(int position = 0; position < plainText.length(); position++) {
			//If a scanned character is out of bounds, set stringInBounds to false
			if (plainText.charAt(position) < LOWER_RANGE || plainText.charAt(position) > UPPER_RANGE) {
				stringInBounds = false;
			}
		}
		return stringInBounds;
	}
	/**
	 * Encrypts a string according to the Caesar Cipher. The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String caesarEncryption(String plainText, int key) {
		/*throw new RuntimeException("method not implemented");*/
		StringBuffer buffer = new StringBuffer();
		//wrap key
		while (key > RANGE) {
			key -= RANGE;
		}
		//Add new if that says if the current char being used in math
		//is above UPPER_RANGE, start from LOWER_RANGE
		//Take key and subtract MAX-pos char at. This is how many
		//more needs to be done for next char
		//newKey = key - (MAX - poscharat) 

		for(int position = 0; position < plainText.length(); position++) {
			if((plainText.charAt(position) + key) > UPPER_RANGE) {
				buffer.append((char)(LOWER_RANGE + (key - (UPPER_RANGE + 1 - plainText.charAt(position)))));
			}
			else {
			buffer.append((char)(plainText.charAt(position) + key));
			}
		}

		return (buffer.toString());
	}
	
	/**
	 * Encrypts a string according the Bellaso Cipher. Each character in plainText is offset
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	public static String bellasoEncryption (String plainText, String bellasoStr) {
		/*throw new RuntimeException("method not implemented");*/
		String newText = "";
		String key = bellasoStr;
		String newKey;
		int offsetValue = 0;
		int position = 0;
		StringBuffer sb = new StringBuffer();
		while (sb.length() < plainText.length()) {
			sb.append(bellasoStr.charAt(position));
			position++;
			if (position >= bellasoStr.length()) {
				position = 0;
			}
		}
		position = 0;
		newKey = sb.toString();
		//CLEAR SB
		sb.delete(0,sb.length());
		int mathME;
		
		while (plainText.length() != sb.length()) {
			if (plainText.charAt(position) + newKey.charAt(position) > UPPER_RANGE) {
				//UPPER_RANGE - plainText.charAt(position)
				//newKey.charAt(position) - ^ That number
				//LOWER_RANGE + ^That number - 1
				//LOWER_RANGE - 1 + ((newKey.charAt(position) - (UPPER_RANGE-plainText.charAt(position)))
				mathME = ((newKey.charAt(position) - (UPPER_RANGE-plainText.charAt(position))));
				while (mathME > RANGE) {
					mathME -= RANGE;
				}
				offsetValue = LOWER_RANGE - 1 + mathME;//((newKey.charAt(position) - (UPPER_RANGE-plainText.charAt(position))));
			}
			else {
				offsetValue = ((plainText.charAt(position)) + (newKey.charAt(position)));
			}
			sb.append((char)(offsetValue));
			position++;
			if (position >= plainText.length()) {
				position = 0;
			}
		}
		newText = sb.toString();
		return newText;
	}
	
	/**
	 * Decrypts a string according to the Caesar Cipher. The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	public static String caesarDecryption (String encryptedText, int key) {
		StringBuffer buffer = new StringBuffer();
		while (key > RANGE) {
			key -= RANGE;
		}
		for(int position = 0; position < encryptedText.length(); position++) {
			if((encryptedText.charAt(position) - key) < LOWER_RANGE) {
				buffer.append((char)(UPPER_RANGE - (key - (encryptedText.charAt(position) - LOWER_RANGE + 1))));
			}
			else {
			buffer.append((char)(encryptedText.charAt(position) - key));
			}
		}
		return (buffer.toString());
	}
	
	/**
	 * Decrypts a string according the Bellaso Cipher. Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText. This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	public static String bellasoDecryption(String encryptedText, String bellasoStr) {
		/*throw new RuntimeException("method not implemented");*/
		String newText = "";
		String key = bellasoStr;
		String newKey;
		int offsetValue = 0;
		int position = 0;
		StringBuffer sb = new StringBuffer();
		while (sb.length() < encryptedText.length()) {
			sb.append(bellasoStr.charAt(position));
			position++;
			if (position >= bellasoStr.length()) {
				position = 0;
			}
		}
		position = 0;
		newKey = sb.toString();
		//CLEAR SB
		sb.delete(0,sb.length());
		while (encryptedText.length() != sb.length()) {
			if (encryptedText.charAt(position) - newKey.charAt(position) < LOWER_RANGE) {
				//LOWER_RANGE + encryptedText.charAt(position)
				//newKey.charAt(position) - ^ That number
				//LOWER_RANGE + ^That number
				offsetValue = (LOWER_RANGE * 2) + (encryptedText.charAt(position) - newKey.charAt(position)); 
			}
			else {
				offsetValue = ((encryptedText.charAt(position)) - (newKey.charAt(position)));
			}
			sb.append((char)(offsetValue));
			position++;
			if (position >= encryptedText.length()) {
				position = 0;
			}
		}
		newText = sb.toString();
		return newText;


	}
}

