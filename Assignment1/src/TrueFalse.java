public class TrueFalse implements Question {
	
	// this makes it easy to change the correct answer that's displayed on the results
	// (if there is a correct answer)
	private char TFanswer = 'T'; 
	
	// Constructor
	public TrueFalse() {}
	
	// implementing Question's setQ() method
	public void displayQuestion() {
		System.out.println("True/False: CS is a difficult major");
		System.out.println("1. Right");
		System.out.println("2. Wrong");
	}
	
	// returns the correct answer for results
	public char correctAnswer() { 
		return TFanswer;
	}
}
