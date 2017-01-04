package com.i80.pojo;

public class Question {
	private int questionId;
	private String extQuestionId;
	private QuestionType questionType;
	private String choice1;
	private String choice2;
	private String choice3;
	private String choice4;
	private boolean isChoice1Correct;
	private boolean isChoice2Correct;
	private boolean isChoice3Correct;
	private boolean isChoice4Correct;
	private String answerString;
	
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public String getExtQuestionId() {
		return extQuestionId;
	}
	public void setExtQuestionId(String extQuestionId) {
		this.extQuestionId = extQuestionId;
	}
	public QuestionType getQuestionType() {
		return questionType;
	}
	public void setQuestionType(QuestionType questionType) {
		this.questionType = questionType;
	}
	public String getChoice1() {
		return choice1;
	}
	public void setChoice1(String choice1) {
		this.choice1 = choice1;
	}
	public String getChoice2() {
		return choice2;
	}
	public void setChoice2(String choice2) {
		this.choice2 = choice2;
	}
	public String getChoice3() {
		return choice3;
	}
	public void setChoice3(String choice3) {
		this.choice3 = choice3;
	}
	public String getChoice4() {
		return choice4;
	}
	public void setChoice4(String choice4) {
		this.choice4 = choice4;
	}
	public boolean isChoice1Correct() {
		return isChoice1Correct;
	}
	public void setChoice1Correct(boolean isChoice1Correct) {
		this.isChoice1Correct = isChoice1Correct;
	}
	public boolean isChoice2Correct() {
		return isChoice2Correct;
	}
	public void setChoice2Correct(boolean isChoice2Correct) {
		this.isChoice2Correct = isChoice2Correct;
	}
	public boolean isChoice3Correct() {
		return isChoice3Correct;
	}
	public void setChoice3Correct(boolean isChoice3Correct) {
		this.isChoice3Correct = isChoice3Correct;
	}
	public boolean isChoice4Correct() {
		return isChoice4Correct;
	}
	public void setChoice4Correct(boolean isChoice4Correct) {
		this.isChoice4Correct = isChoice4Correct;
	}
	public String getAnswerString() {
		return answerString;
	}
	public void setAnswerString(String answerString) {
		this.answerString = answerString;
	}
}
