package com.i80.pojo;

public enum QuestionType {
	SingleChoice(1), MultipleChoice(2), CodeoutPut(3), FillTheBlanks(4);
	int code;
	
	QuestionType(int code){
		this.code = code;
	}
}
