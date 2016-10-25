/*
 * File: HangmanCanvas.java
 * ------------------------
 * This file keeps track of the Hangman display.
 */

import java.awt.Canvas;
import java.awt.Color;

import javax.print.attribute.standard.PrinterLocation;

import acm.graphics.*;

public class HangmanCanvas extends GCanvas {

/** Resets the display so that only the scaffold appears */
	
	public void reset() 
	{
		drawFirstPart();
	}

/**
 * Updates the word on the screen to correspond to the current
 * state of the game.  The argument string shows what letters have
 * been guessed so far; unguessed letters are indicated by hyphens.
 */
	public void displayWord(String word)
	{
			
			GLabel printword = new GLabel( word , (LENGHT_FROM_LEFTWALL), ( LENGHT_FROM_TOPWALL  + SCAFFOLD_HEIGHT + 30 ) );
			add(printword);
		
	}
	
	public void displayWord1(String word)
	{
			GLabel printword = new GLabel( word , (LENGHT_FROM_LEFTWALL), ( LENGHT_FROM_TOPWALL  + SCAFFOLD_HEIGHT + 50 ) );
			add(printword);
		
	}

/**
 * Updates the display to correspond to an incorrect guess by the
 * user.  Calling this method causes the next body part to appear
 * on the scaffold and adds the letter to the list of incorrect
 * guesses that appears at the bottom of the window.
 */
	public void noteIncorrectGuess(char letter) 
	{			
			switch (key) {
				case 1:
						headDraw();
						key++;
					break;
					
				case 2:
					    bodyDraw();
					    key++;
				break;
				
				case 3:
					leftArmDraw();
					key++;
				break;
				
				case 4:
				    rightArmDraw();
				    key++;
				break;
				
				case 5:
					leftLegDraw();
					key++;
				break;
				
				case 6:
				    rightLegDraw();
				    key++;
				break;
				
				case 7:
					leftFootDraw();
					key++;
				break;
				
				case 8:
				    rightFootDraw();
				    key++;
			    break;

			default:
				break;
			}
			
	}


public void drawFirstPart()
{
		int x1 =  (LENGHT_FROM_LEFTWALL);
		int y1 =  ( LENGHT_FROM_TOPWALL  + SCAFFOLD_HEIGHT );
		
		int x2 =  x1 ;
		int y2 =  ( LENGHT_FROM_TOPWALL );
		GLine line = new GLine( x1 ,y1 ,x2,y2 ); 
		
		add(line);
		
		
		int x3 = x2 + BEAM_LENGTH ;
		int y3 =  y2;
		GLine line2 = new GLine(x2, y2, x3, y3);
		add( line2);
		
		
		int x4 = x3  ;
		int y4 = y3 + ROPE_LENGTH;
		GLine line3 = new GLine(x3, y3, x4, y4);
		add( line3);
	
	
}

public void headDraw() 
{
		int x1 =  ( LENGHT_FROM_LEFTWALL + BEAM_LENGTH) - HEAD_RADIUS;
		int y1 = LENGHT_FROM_TOPWALL + ROPE_LENGTH ;
		
		GOval face = new GOval(x1, y1 , ( 2 * HEAD_RADIUS) , ( 2 * HEAD_RADIUS)) ; 
		face.setFilled(true);
		//face.setColor(Color.WHITE);
		add(face);
	
}

public void bodyDraw()
{
		int x1 =  ( LENGHT_FROM_LEFTWALL + BEAM_LENGTH);
		int y1 =  LENGHT_FROM_TOPWALL + ROPE_LENGTH + ( 2 * HEAD_RADIUS);
	
		int x2 =  x1 ;
		int y2 =  y1 + BODY_LENGTH;
		GLine line = new GLine( x1 ,y1 ,x2,y2 ); 
	
		add(line);
	
}

public void leftArmDraw() 
{
		int x1 =  ( LENGHT_FROM_LEFTWALL + BEAM_LENGTH) ;
		int y1 =  LENGHT_FROM_TOPWALL + ROPE_LENGTH + ( 2 * HEAD_RADIUS) + ARM_OFFSET_FROM_HEAD;
		int x2 =  x1 - UPPER_ARM_LENGTH;
		int y2 =  LENGHT_FROM_TOPWALL + ROPE_LENGTH + ( 2 * HEAD_RADIUS) + ARM_OFFSET_FROM_HEAD;
		GLine line = new GLine( x1 ,y1 ,x2,y2 ); 
	
		add(line);
		
		int x3 =  x2 ;
		int y3 =  LENGHT_FROM_TOPWALL + ROPE_LENGTH + ( 2 * HEAD_RADIUS) + ARM_OFFSET_FROM_HEAD + LOWER_ARM_LENGTH;
		
		GLine line1 = new GLine( x2 ,y2 ,x3,y3 ); 
	
		add(line1);
}


public void rightArmDraw() {
		int x1 =  ( LENGHT_FROM_LEFTWALL + BEAM_LENGTH) ;
		int y1 =  LENGHT_FROM_TOPWALL + ROPE_LENGTH + ( 2 * HEAD_RADIUS) + ARM_OFFSET_FROM_HEAD;
		int x2 =  x1 + UPPER_ARM_LENGTH;
		int y2 =  LENGHT_FROM_TOPWALL + ROPE_LENGTH + ( 2 * HEAD_RADIUS) + ARM_OFFSET_FROM_HEAD;
		GLine line = new GLine( x1 ,y1 ,x2,y2 ); 

		add(line);	
		
		int x3 =  x2 ;
		int y3 =  LENGHT_FROM_TOPWALL + ROPE_LENGTH + ( 2 * HEAD_RADIUS) + ARM_OFFSET_FROM_HEAD + LOWER_ARM_LENGTH;
		
		GLine line1 = new GLine( x2 ,y2 ,x3,y3 ); 
	
		add(line1);
	
}


public void leftLegDraw()
{
		int x1 =  ( LENGHT_FROM_LEFTWALL + BEAM_LENGTH);
		int y1 =  LENGHT_FROM_TOPWALL + ROPE_LENGTH + ( 2 * HEAD_RADIUS) + BODY_LENGTH;
		int x2 =  x1 - HIP_WIDTH;
		int y2 =  y1;
		
		GLine line = new GLine( x1 ,y1 ,x2,y2 ); 

		add(line);	
		
		int x3 =  x2 ;
		int y3 =  LENGHT_FROM_TOPWALL + ROPE_LENGTH + ( 2 * HEAD_RADIUS) + BODY_LENGTH + LEG_LENGTH;
		
		GLine line1 = new GLine( x2 ,y2 ,x3,y3 ); 
	
		add(line1);
}


public void rightLegDraw()
{
		int x1 =  ( LENGHT_FROM_LEFTWALL + BEAM_LENGTH);
		int y1 =  LENGHT_FROM_TOPWALL + ROPE_LENGTH + ( 2 * HEAD_RADIUS) + BODY_LENGTH;
		int x2 =  x1 + HIP_WIDTH;
		int y2 =  y1;
	
		GLine line = new GLine( x1 ,y1 ,x2,y2 ); 

		add(line);	
	
	
		int x3 =  x2 ;
		int y3 =  LENGHT_FROM_TOPWALL + ROPE_LENGTH + ( 2 * HEAD_RADIUS)  + BODY_LENGTH + LEG_LENGTH;
	
		GLine line1 = new GLine( x2 ,y2 ,x3,y3 ); 

		add(line1);
	
}




public void leftFootDraw()
{
		int x1 =  ( LENGHT_FROM_LEFTWALL + BEAM_LENGTH) - HIP_WIDTH;
		int y1 =  LENGHT_FROM_TOPWALL + ROPE_LENGTH + ( 2 * HEAD_RADIUS) + BODY_LENGTH + LEG_LENGTH;
		int x2 =  x1 - FOOT_LENGTH;
		int y2 =  y1;
		
		GLine line = new GLine( x1 ,y1 ,x2,y2 ); 
		add(line);	
}



public void rightFootDraw()
{
		int x1 =  ( LENGHT_FROM_LEFTWALL + BEAM_LENGTH) + HIP_WIDTH;
		int y1 =  LENGHT_FROM_TOPWALL + ROPE_LENGTH + ( 2 * HEAD_RADIUS) + BODY_LENGTH + LEG_LENGTH;
		int x2 =  x1  +  FOOT_LENGTH;
		int y2 =  y1;
		GLine line = new GLine( x1 ,y1 ,x2,y2 ); 
		add(line);	
}

	/* Constants for the simple version of the picture (in pixels) */
	int key = 1;
	private static final int LENGHT_FROM_LEFTWALL = 100;
	private static final int LENGHT_FROM_TOPWALL = 100;
	private static final int SCAFFOLD_HEIGHT = 360;
	private static final int BEAM_LENGTH = 144;
	private static final int ROPE_LENGTH = 18;
	private static final int HEAD_RADIUS = 36;
	private static final int BODY_LENGTH = 144;
	private static final int ARM_OFFSET_FROM_HEAD = 28;
	private static final int UPPER_ARM_LENGTH = 72;
	private static final int LOWER_ARM_LENGTH = 44;
	private static final int HIP_WIDTH = 36;
	private static final int LEG_LENGTH = 108;
	private static final int FOOT_LENGTH = 28;
	
	

}
