package iVoteSimulator;

import java.text.*;
import java.util.*;

public class iVoteService {
	
	MultChoice mc = new MultChoice();
	
	public iVoteService() {}

	public void results(HashMap<Integer, Character> studAnswers, int type) {
		if(type == 1) { // question is multiple choice
			int answerA = 0, answerB = 0, answerC = 0, answerD = 0;
			
			for (Character x : studAnswers.values()) {
				switch (x) {
					case 'A': // student chose option A
						answerA++;
						break;
					case 'B': // student chose option B
						answerB++;
						break;
					case 'C': // student chose option C
						answerC++;
						break;
					default: // student chose option D
						answerD++;
						break;
				}
			}
			
			System.out.println("\nResults");
			System.out.println("A: " + answerA);
			System.out.println("B: " + answerB);
			System.out.println("C: " + answerC);
			System.out.println("D: " + answerD);
			
			NumberFormat formatter = new DecimalFormat("#0.00");
			System.out.print("Correct Answer is " + mc.correctAnswer() + ". ");
			System.out.println(formatter.format((answerB / 28.0)*100) + "% of the class got it right." );
			System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - -");
		}
		else { // question is true false
			int answerRight = 0, answerWrong = 0;
			
			for (Character x : studAnswers.values()) {
				if (x == '1') // student answered true
					answerRight++;
				else // student answered false
					answerWrong++;
			}
			
			System.out.println("\nResults");
			System.out.println("1. Right: " + answerRight);
			System.out.println("2. Wrong: " + answerWrong);
		}
	}
}
