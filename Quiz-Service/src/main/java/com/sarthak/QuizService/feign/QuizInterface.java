package com.sarthak.QuizService.feign;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.sarthak.QuizService.model.QuestionWrapper;
import com.sarthak.QuizService.model.Response;



@FeignClient("QUESTIONSERVICE")
public interface QuizInterface {
	
	// generate
	@GetMapping("question/generate")
	public ResponseEntity<List<Integer>> getQuestionsForQuiz(@RequestParam String category,@RequestParam Integer noOfQuestions);
	
	// getQuiestion
	@PostMapping("question/getQuestions")
	public ResponseEntity<List<QuestionWrapper>> getQuestionFromID(@RequestBody List<Integer> questionIds);
	
	//get Score
	@PostMapping("question/getScore")
	public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses);
	

}
