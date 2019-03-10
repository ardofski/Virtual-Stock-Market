package model;

/**
 * A class which includes a question and the answer of that question.
 * @author Duygu Nur Yaldiz
 * @version 12.09.2018
 */
public class Question {

	//properties
	String question;
	String answer;
	
	//Constructor
	/**
	 * Constructs a new question object with given parameters
	 * @param question the question
	 * @param answer the answer
	 */
	public Question( String question, String answer) {
		this.question = question;
		this.answer = answer;
	}
	
	//Methods
	/**
	 * Checks if the given string matches with the answer
	 * @param answer the string to be checked 
	 * @return true if they are the same, else false
	 */
	public boolean checkAnswer( String answer ) {
		return this.answer.equals(answer);
	}
	
	/**
	 * Returns the question
	 * @return question
	 */
	public String getQuestion() {
		return question;
	}
	
	/**
	 * Returns the answer
	 * @return answer
	 */
	public String getAnswer() {
		return answer;
	}
	

	/**
	 * Sets the question to given parameter
	 * @param question the new question
	 */
	public void setQuestion( String question ) {
		this.question = question;
		
		//TODO set question to database
	}
	
	/**
	 * Sets the answer to given parameter
	 * @param answer the new answer
	 */
	public void setAnswer( String answer ) {
		this.answer = answer;6
		
		//TODO set answer to databae
	}
}
