package iVoteSimulator;

import java.util.*;

public class SimulationDriver {
	
	private static Random random = new Random(); // in charge of random number generations
	private final static int NUMSTUDENTS = 28; // there will be 28 students
	private static Student[] students = new Student[NUMSTUDENTS]; // array to keep track of the students
	private static char[] answers = {'1', '2', 'A', 'B', 'C', 'D'}; // only possible answers
	
	public static void main(String[] args) {	

		for (int s = 0; s < NUMSTUDENTS; s++) { // creates the students and their IDs
			int randID = random.nextInt(9000000) + 1000000; // generating random 7-digit Student ID
			Student stud = new Student(randID);
			students[s] = stud; // student is added to the array
		}
		
		iVoteService newSession = new iVoteService(); // starts the round of questions
		
		
		
		printMCQ(); 
		int questionType = 1; // 1 = multiple choice question
		newSession.results(studentSubs(questionType), questionType);
		
		printTFQ(); 
		questionType = 2; // 2 = true/false question
		newSession.results(studentSubs(questionType), questionType);
	}

	public static void printMCQ(){ // displays the multiple choice question
		Question mc = new MultChoice();
		mc.displayQuestion();
	}
	
	public static void printTFQ(){ // displays the true false question
		Question tf = new TrueFalse();
		tf.displayQuestion();
	}

	public static HashMap studentSubs(int questionType){
		System.out.println("\nNow accepting answers...");
		HashMap<Integer, Character> studAnswers = new HashMap<Integer, Character>();
		int randomNum;
		
		if(questionType == 1) { // multiple choice question
			for (int i = 0; i < NUMSTUDENTS; i++) { // each student will answer at least once
				int id = students[i].getID();
				randomNum = random.nextInt(4) + 2;
				char selection = answers[randomNum];
				studAnswers.put(id, selection); // adds the student's id and their answer for the question
			}
			for (int j = 0; j < NUMSTUDENTS; j+=4) { // some students will change their answer
				int id = students[j].getID();
				randomNum = random.nextInt(4) + 2;
				char selection = answers[randomNum];
				studAnswers.put(id, selection); // adds the student's id and their answer for the question
			}
		}
		else { // true false question
			for (int i = 0; i < NUMSTUDENTS; i++) { // each student will answer at least once
				int id = students[i].getID();
				randomNum = random.nextInt(2);
				char selection = answers[randomNum];
				studAnswers.put(id, selection); // adds the student's id and their answer for the question
			}
			for (int j = 0; j < NUMSTUDENTS; j+=7) { // some students will change their answer
				int id = students[j].getID();
				randomNum = random.nextInt(2);
				char selection = answers[randomNum];
				studAnswers.put(id, selection); // adds the student's id and their answer for the question
			}
		}
		
		System.out.println("Submission closed.");
		return studAnswers;
	}
}
