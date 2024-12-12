package com.example.quiz.Quiz.controller;

import com.example.quiz.Quiz.entities.Questions;
import com.example.quiz.Quiz.entities.QuizSession;
import com.example.quiz.Quiz.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @PostMapping("/start")
    public QuizSession startQuiz(@RequestParam Long userID)
    {
            return quizService.StartNewSession(userID);
    }
    @PostMapping("/question")
    public Questions getRandonQues()
    {
        return quizService.RandomQuestion();
    }
    @PostMapping("/submit")
    public boolean submitAnswer(@RequestParam Long sessionId,@RequestParam Long questionId, @RequestParam String answer)
    {
        return quizService.submitAnswer(sessionId,questionId,answer);
    }
    @GetMapping("/stats")
    public QuizSession stats(@RequestParam Long sessionId)
    {
        return quizService.getStats(sessionId);
    }

}

