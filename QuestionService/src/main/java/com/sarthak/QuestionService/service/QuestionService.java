package com.sarthak.QuestionService.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sarthak.QuestionService.DAO.QuestionDao;
import com.sarthak.QuestionService.model.Question;
import com.sarthak.QuestionService.model.QuestionWrapper;
import com.sarthak.QuestionService.model.Response;

@Service
public class QuestionService {
	@Autowired
	QuestionDao questionDao;

	public List<Question> getAllQuestions() {
		// TODO Auto-generated method stub
		return questionDao.findAll();
	}

	public List<Question> getQuestionBySubject(String subject) {
		// TODO Auto-generated method stub
		return questionDao.findBycategory(subject);
	}

	public ResponseEntity<Question> addQuestion(Question question) {
		// TODO Auto-generated method stub
		
		try
		{
			return new ResponseEntity<>(questionDao.save(question),HttpStatus.CREATED);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		
	}

	public ResponseEntity<List<Integer>> getQuestionsForQuiz(String category, Integer noOfQuestions) {
		List<Integer> questions=questionDao.findRandomQuestionBycategory(category,noOfQuestions);
		System.out.println("QuizService call");
		System.out.print(questions);
		return new ResponseEntity<>(questions,HttpStatus.CREATED);
	}

	public ResponseEntity<List<QuestionWrapper>> getQuestionsByID(List<Integer> questionIds) {
		List<QuestionWrapper> wrapper=new ArrayList<>();
		List<Question> questions=new ArrayList<>();
		for(Integer i:questionIds)
		{
			questions.add(questionDao.findById(i).get());
		}
		for(Question question:questions)
		{
			QuestionWrapper current=new QuestionWrapper(question.getId(),question.getQuestionTitle(),
					question.getOption1(),question.getOption2(),question.getOption3(),question.getOption4());
			wrapper.add(current);
		}
		
		
		return new ResponseEntity<>(wrapper,HttpStatus.OK);
	}

	public ResponseEntity<Integer> getScore(List<Response> responses) {
		Integer score=0;
		for(Response resp:responses)
		{
			if(resp.getResponse().equals(questionDao.findById(resp.getId()).get().getAnswer()))
			{
				score++;
			}
		}
		
		
		return new ResponseEntity<>(score,HttpStatus.ACCEPTED);
	}

}


