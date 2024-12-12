package com.example.quiz.Quiz.repositories;

import com.example.quiz.Quiz.entities.QuizSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface QuizSessionRepo extends JpaRepository<QuizSession, Long> {

}
