package encryptDecrypt;

import java.util.Arrays;
import java.util.Scanner;

public class Decrypt {

	public static void main(String[] args) {
		char[] myCipher = { 'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p', 'a', 's', 'd', 'f', 'g', 'h', 'j', 'k',
				'l', 'z', 'x', 'c', 'v', 'b', 'n', 'm', ' ', '.' };
		char[] theAlphaBet = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
				's', 't', 'u', 'v', 'w', 'x', 'y', 'z', ' ', '.' };

		String computerOutput;
		String decryptedOutput;
		boolean wordIsValid = false;
		String userInput;

		Scanner keyboard = new Scanner(System.in);
		do {
			System.out.println("Please enter what you would like to encrypt");
			System.out.println("Please do not enter Special Characters or Numbers.");
			System.out.println();
			userInput = keyboard.nextLine();

			wordIsValid = wordIsValid(userInput);

		} while (wordIsValid);

		int arraylength = userInput.length();

		char[] encryptedWord = new char[userInput.length()];
		encryptedWord = new char[arraylength];
		char[] wordToEncrypt = new char[userInput.length()];

		wordToEncrypt = userInput.toLowerCase().toCharArray();

		while (!(wordIsValid)) {
			String choice = null;
			System.out.println();
			System.out.println("Would you like to: \n" + "Encrypt (1) \n" + "Decrypt (2)\n" + "Exit (3)");
			System.out.println();
			System.out.println();
			choice = keyboard.nextLine();
			switch (choice) {
			case "1":
				myEncrypt(myCipher, theAlphaBet, userInput, encryptedWord, wordToEncrypt);
				computerOutput = String.valueOf(encryptedWord);
				System.out.println("Here is the Encrypted sentence: ");
				System.out.println(computerOutput);
				System.out.println();
				wordIsValid = false;
				break;

			case "2":
				try {
					char[] wordToDecrypt = new char[userInput.length()];
					myDecryptor(myCipher, theAlphaBet, userInput, encryptedWord, wordToDecrypt);

					decryptedOutput = String.valueOf(wordToDecrypt);
					System.out.println("Here is the Decrypted Sentence:");
					System.out.println(decryptedOutput);
					System.out.println();
					wordIsValid = false;
				} catch (IndexOutOfBoundsException e) {
					e.getStackTrace();
				}
				break;

			case "3":

				System.out.println("Thank You for using our app!");
				System.out.println("Goodbye");
				System.exit(0);
				break;

			default:
				break;
			}

		}

	}

	private static void myDecryptor(char[] myCipher, char[] theAlphaBet, String userInput, char[] encryptedWord,
			char[] wordToDecrypt) {
		for (int i = 0; i < userInput.length(); i++) {

			char compare = encryptedWord[i];
			for (int j = 0; j < myCipher.length; j++) {
				if (compare == myCipher[j]) {
					wordToDecrypt[i] = theAlphaBet[j];

				}
			}

		}
	}

	public static boolean wordIsValid(String someStringWithNoNumber) {

		if (someStringWithNoNumber.matches(".*\\d+.*")) {

			return true;

		} else {
			return false;
		}
	}

	private static void myEncrypt(char[] myCipher, char[] theAlphaBet, String userInput, char[] encryptedWord,
			char[] wordToEncrypt) {
		for (int i = 0; i < userInput.length(); i++) {

			char compare = wordToEncrypt[i];
			for (int j = 0; j < theAlphaBet.length; j++) {
				if (compare == theAlphaBet[j]) {

					encryptedWord[i] = myCipher[j];

				}
			}

		}
	}

}
