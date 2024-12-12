package com.example.quiz.Quiz.repositories;

import com.example.quiz.Quiz.entities.Questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepo extends JpaRepository<Questions, Long> {

}
