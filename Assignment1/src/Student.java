package iVoteSimulator;

public class Student {
	
	private int studID;

	// Constructor
	public Student() {}
	
	public Student(int id) {
		studID = id;
	}
	
	// Getters & Setters
	public int getID(){
		return studID;
	}

	public void setID(int id){
		studID = id;
	}
}