package com.example.quiz.Quiz.service;

import com.example.quiz.Quiz.entities.Questions;
import com.example.quiz.Quiz.entities.QuizSession;
import com.example.quiz.Quiz.entities.User;
import com.example.quiz.Quiz.repositories.QuestionRepo;
import com.example.quiz.Quiz.repositories.QuizSessionRepo;
import com.example.quiz.Quiz.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class QuizService {
    @Autowired
    private QuestionRepo questionRepo;
    @Autowired
    private QuizSessionRepo quizSessionRepo;
    @Autowired
    private UserRepo userRepo;

    public Questions RandomQuestion() {
        List<Questions> questions = questionRepo.findAll();
        Random random = new Random();
        return questions.get(random.nextInt(questions.size()));
    }
    public QuizSession StartNewSession(Long userId) {
        User user=userRepo.findById(userId).orElseThrow(()->new RuntimeException("User Not Found"));
        QuizSession quizSession=new QuizSession();
        quizSession.setUser(user);
        return quizSessionRepo.save(quizSession);
    }
    public boolean submitAnswer(Long sessionId,Long questionId,String answer) {
        QuizSession quizSession=quizSessionRepo.findById(sessionId).orElseThrow(()->new RuntimeException("Session Not Found"));
        Questions questions=questionRepo.findById(questionId).orElseThrow(()->new RuntimeException("Question Not Found"));
        boolean isCorrect = questions.getAnswer().equalsIgnoreCase(answer);
        if(isCorrect) {
            quizSession.setAnswered(quizSession.getAnswered() + 1);
            quizSession.setAttempted(quizSession.getAttempted() + 1);
        }
        else {
            quizSession.setAttempted(quizSession.getAttempted() + 1);
        }
        quizSessionRepo.save(quizSession);
        return isCorrect;
    }
    public QuizSession getStats(Long sessionId) {
        return quizSessionRepo.findById(sessionId).orElseThrow(()->new RuntimeException("Session Not Found"));
    }
}
