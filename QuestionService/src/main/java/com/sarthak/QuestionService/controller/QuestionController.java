package com.sarthak.QuestionService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sarthak.QuestionService.model.Question;
import com.sarthak.QuestionService.model.QuestionWrapper;
import com.sarthak.QuestionService.model.Response;
import com.sarthak.QuestionService.service.QuestionService;

@RestController
@RequestMapping("question")
public class QuestionController {
	
	@Autowired
	QuestionService questionService;
	@Autowired
	Environment environment;
	
	@GetMapping("/allQuestions")
	public ResponseEntity<List<Question>> getAllQuestions()
	{
		return new ResponseEntity<>(questionService.getAllQuestions(),HttpStatus.OK);
	}
	@GetMapping("/category/{subject}")
	public ResponseEntity<List<Question>> getQuestionByCategory(@PathVariable String subject)
	{
		return new ResponseEntity<>(questionService.getQuestionBySubject(subject),HttpStatus.OK);
		
	}
	@PostMapping("add")
	public ResponseEntity<Question> addQuestion(@RequestBody Question question)
	{
		List<Question> q=questionService.getAllQuestions();
		question.setId(q.size()+1);
		return questionService.addQuestion(question);
		//return "Question Added successfully";
	}
	// generate
	@GetMapping("generate")
	public ResponseEntity<List<Integer>> getQuestionsForQuiz(@RequestParam String category,@RequestParam Integer noOfQuestions)
	{
		
		return questionService.getQuestionsForQuiz(category,noOfQuestions);
		
	}
	// getQuiestion
	@PostMapping("getQuestions")
	public ResponseEntity<List<QuestionWrapper>> getQuestionFromID(@RequestBody List<Integer> questionIds)
	{
		return questionService.getQuestionsByID(questionIds);
		
		
	}
	//get Score
	@PostMapping("getScore")
	public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses)
	{
		System.out.println(environment.getProperty("local.server.port"));
		return questionService.getScore(responses);
	}

}

