import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import acm.program.ConsoleProgram;
import acm.util.RandomGenerator;
import acmx.export.java.io.FileReader;

public class FirstPart extends ConsoleProgram {
	private HangmanCanvas canvas;
	List<String> wordList;

	int countOfWordSelectedFromTheList; // the length of string
	public static final int NUMBEROFTURNS = 8;
	String word;
	String inputString = "";

	private RandomGenerator rgen1 = RandomGenerator.getInstance();
	// int lengthOfInput ;

	public void init() {
		wordList = new ArrayList<>();
		canvas = new HangmanCanvas();
		add(canvas);
	}

	public void run() {

		// = countOfWordSelectedFromTheList;
		GetWordFromHangManLexicon();

		int index = rgen1.nextInt(0, wordList.size() - 1);
		word = wordList.get(index);
		countOfWordSelectedFromTheList = word.length();// take word from Class
														// HangManLexicon
		welcomeMassage(); // First two msgs
		canvas.drawFirstPart();
		createUnderscore(); // Black spaces of word count
		guessTheLetter(); // Calculates how many guesses are left and maintain
							// counter for the guesses
	}

	private void welcomeMassage() {
		print(" \n Welcome to HangMan : ");

	}

	private void createUnderscore() {

		inputString = "";
		print(" \n The word now looks like this : ");
		for (int i = 1; i <= countOfWordSelectedFromTheList; i++) {
			inputString += " _";
		}
		print(inputString);
	}

	// take word from Class HangManLexicon
	public void GetWordFromHangManLexicon() {
		BufferedReader read = openFile("HangmanLexicon.txt ");
		try {
			while (true) {
				String st;

				st = read.readLine();
				wordList.add(st);
				if (st == null) {
					break;
				}
			}
			read.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private BufferedReader openFile(String str) {
		BufferedReader read = null;
		while (read == null) {
			// String wordList = readLine(str);
			try {
				read = new BufferedReader(new FileReader(str));
			} catch (FileNotFoundException e) {
				println(" No word found");
			}
		}
		return read;
	}
	// create blank spaces of word count

	private void guessTheLetter() {
		int i = NUMBEROFTURNS;
		char replacement = 0;
		int temp = 0;
		while (i > 0 && inputString.contains("_")) {
			// createUnderscore1(temp , replacement);
			print(" \n You have " + i + "  guesses left.");
			String ch1 = readLine(" \n  Your Guess ");
			if (ch1.equals("")) {
				continue;
			}
			char ch = ch1.charAt(0);
			boolean charFound = false;
			for (int j = 0; j < countOfWordSelectedFromTheList; j++) {
				if (ch == (word.charAt(j))) {
					println(" That guess is correct ");

					charFound = true;
					inputString = replaceChar(ch, (2 * j + 1));
				}
			}
			if (!charFound) {
				i--;
				println(" There are no " + ch + "'s in the word.");

				canvas.noteIncorrectGuess(ch);
				;
			}

			print(" \n The word now looks like this : ");
			print(inputString);
		}
		if (!inputString.contains("_")) {
			println(" \nYou Win");
			println(" output  " + inputString);
		} else {
			println(" \n You lose");
			canvas.displayWord1(word);
			canvas.displayWord(inputString);
		}
	}

	private String replaceChar(char ch, int j) {
		return (inputString.substring(0, j) + ch + inputString.substring(j + 1));
	}

	private void createUnderscore1(int temp, char replacement) {

		String str = " _";
		print(" \n The word now looks like this : ");
		for (int i = 1; i <= countOfWordSelectedFromTheList; i++) {
			if (i == temp) {
				inputString.replace(inputString.charAt(temp), replacement);

			}
			print(inputString);

		}

		print(inputString);

	}

	RandomGenerator rgen = RandomGenerator.getInstance();
}
