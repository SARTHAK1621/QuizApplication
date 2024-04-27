package com.sarthak.QuizService.DAO;

import org.springframework.data.jpa.repository.JpaRepository;


import com.sarthak.QuizService.model.QuizServ;

public interface QuizDAO extends JpaRepository<QuizServ,Integer> {

}
