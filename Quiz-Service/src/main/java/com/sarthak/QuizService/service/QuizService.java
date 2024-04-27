package com.sarthak.QuizService.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sarthak.QuizService.DAO.QuizDAO;
import com.sarthak.QuizService.feign.QuizInterface;
import com.sarthak.QuizService.model.QuestionWrapper;
import com.sarthak.QuizService.model.QuizServ;
import com.sarthak.QuizService.model.Response;

@Service
public class QuizService {
	
	@Autowired
	QuizDAO quizDao;
	@Autowired
	QuizInterface quizint;
	
//	@Autowired
//	QuestionDao questionDao;

	public ResponseEntity<String> createQuiz(String category, Integer noOfQuestions, String title) {
		List<Integer> questions=quizint.getQuestionsForQuiz(category, noOfQuestions).getBody();
		QuizServ quiz=new QuizServ();
		List<QuizServ> all=quizDao.findAll();
		quiz.setId(all.size()+1);
		quiz.setTitle(title);
		quiz.setQuestions(questions);

		quizDao.save(quiz);

		return new ResponseEntity<>("Success",HttpStatus.CREATED);
	}

	public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
		QuizServ currentquiz=quizDao.findById(id).get();
		List<Integer> questions=currentquiz.getQuestions();
		System.out.println(questions);
		
		List<QuestionWrapper> questionForUser=quizint.getQuestionFromID(questions).getBody();

		return new ResponseEntity<>(questionForUser,HttpStatus.OK);
	}

	public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {

		int result=quizint.getScore(responses).getBody();

		return new ResponseEntity<>(result,HttpStatus.OK);
	}
	
	

}

