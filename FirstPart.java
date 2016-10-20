import java.io.IOException;

import acm.program.ConsoleProgram;
import acm.util.RandomGenerator;


public class FirstPart extends ConsoleProgram
{
	int countOfWordSelectedFromTheList;                              // the length of string 
	public static final int NUMBEROFTURNS = 8;
	String word;
	String inputString="";
	//int lengthOfInput ;
	public void run()
	{
		
		// = countOfWordSelectedFromTheList;
		GetWordFromHangManLexicon();     
		countOfWordSelectedFromTheList = word.length();//take word from Class HangManLexicon
		welcomeMassage();                                                 // First two msgs
		createUnderscore();                                               //Black spaces of word count
		guessTheLetter();												// Calculates how many guesses are left and maintain counter for the guesses
	}

	


	private void welcomeMassage()
	{
		print(" \n Welcome to HangMan : ");
	                
	}
	
	private void createUnderscore() {
		
		inputString = "" ;
		print(" \n The word now looks like this : ");
		for (int i = 1; i <= countOfWordSelectedFromTheList; i++)
		{
			 inputString += " _";
		}
		
		
		 print(inputString );  
	}
		 
	 //take word from Class HangManLexicon
	private void GetWordFromHangManLexicon() {
		HangmanLexicon TheWord = new HangmanLexicon();
		int random = rgen.nextInt( 0 , TheWord.getWordCount() -1);
	    word = TheWord.getWord( random );
		


	}
	
	// create blank spaces of word count 

	

	private void guessTheLetter() {
	
		
		int i = NUMBEROFTURNS;
		char replacement = 0;
		int temp = 0;
		while ( i > 0 && inputString.contains("_"))
		{
			//createUnderscore1(temp , replacement);
			print( " \n You have " +i+  "  guesses left.");
		    String ch1 = readLine(" \n  Your Guess ");
		    if( ch1.equals("") )
		    {
		    	continue;
		    }
		    char ch = ch1.charAt(0);
		    boolean charFound = false;
		    for (int j = 0; j < countOfWordSelectedFromTheList; j++)
		    {
		    	if(ch == (word.charAt(j)))
		    	{
		    		println( " That guess is correct ");
		    	
		    		charFound = true;
		    		
		    		
		    		inputString = replaceChar( ch , (2 *j +1) );
		    	}
		    
		    	 
		    }
		    if(!charFound)
		    {
		    	i--;
		    println( " There are no " +ch+ "'s in the word.");
		    }
		    
		    print(" \n The word now looks like this : ");
		    print(inputString );  
		}
		
		  
	    if( !inputString.contains("_"))
	    {
	    	println(" \nYou Win");
	    	println(" output  "  +inputString);
	    }
	    else
	    {
	    	println(" \n You lose");
	    }
	}
	private String replaceChar(char ch, int j)
	{
		return(inputString.substring(0, j) + ch + inputString.substring(j+1) );
	
	}




	private void createUnderscore1( int temp, char replacement) {
		
		String str= " _" ;
		print(" \n The word now looks like this : ");
		for (int i = 1; i <= countOfWordSelectedFromTheList; i++)
		{
			if(i == temp)
			{
				inputString.replace(inputString.charAt(temp), replacement);
				
			}
			 print(inputString );  
			   
		}
		
		
		 print(inputString );  
		 
		 
	}
	RandomGenerator rgen = RandomGenerator.getInstance();
}
