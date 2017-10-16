package iVoteSimulator;

public class MultChoice implements Question {
	
	// this makes it easy to change the correct answer that's displayed on the results
	private char MCanswer = 'B'; 
	
	// Constructor
	public MultChoice() {}
	
	// implementing Question's setQ() method
	public void displayQuestion() {
		System.out.println("When a class <implements> another class, what is it an example of?");
		System.out.println("A. Polymorphism");
		System.out.println("B. Interface");
		System.out.println("C. Inheritance");
		System.out.println("D. Did we even learn this?");
	}
	
	// returns the correct answer for results
	public char correctAnswer() { 
		return MCanswer;
	}
}
