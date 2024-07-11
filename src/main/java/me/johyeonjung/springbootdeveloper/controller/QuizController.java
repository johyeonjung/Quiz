package me.johyeonjung.springbootdeveloper.controller;


import org.springframework.ui.Model;
import me.johyeonjung.springbootdeveloper.Service.QuizService;
import me.johyeonjung.springbootdeveloper.domain.Article;
import me.johyeonjung.springbootdeveloper.domain.Quiz;
import me.johyeonjung.springbootdeveloper.dto.ArticleViewResponse;
import me.johyeonjung.springbootdeveloper.repository.QuizRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;
@Controller

public class QuizController {
    private final QuizRepository quizRepository;

    public QuizController(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    @GetMapping("/quiz/{category}")
    public String getQuizByCategory(@PathVariable Long category, Model model) {
        List<Quiz> quiz = quizRepository.findByCategoryId(category);
        model.addAttribute("quiz", quiz);
        return "quizList";
    }



}
