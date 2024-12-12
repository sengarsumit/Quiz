package com.example.quiz.Quiz.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class QuizSession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int answered;
    private int attempted;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToMany
    @JoinTable(name="quiz_session_question",joinColumns = @JoinColumn(name="quiz_session_id"),inverseJoinColumns = @JoinColumn(name = "question_id"))
    private Set<Questions> questions;

}
