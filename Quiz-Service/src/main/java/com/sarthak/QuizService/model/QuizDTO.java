package com.sarthak.QuizService.model;

import lombok.Data;

@Data
public class QuizDTO {
	String category;
	String title;
	int numOfQuestion;
	public QuizDTO(String category, String title, int numOfQuestion) {
		super();
		this.category = category;
		this.title = title;
		this.numOfQuestion = numOfQuestion;
	}
	public QuizDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getNumOfQuestion() {
		return numOfQuestion;
	}
	public void setNumOfQuestion(int numOfQuestion) {
		this.numOfQuestion = numOfQuestion;
	}
	@Override
	public String toString() {
		return "QuizDTO [category=" + category + ", title=" + title + ", numOfQuestion=" + numOfQuestion
				+ ", getCategory()=" + getCategory() + ", getTitle()=" + getTitle() + ", getNumOfQuestion()="
				+ getNumOfQuestion() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

}
