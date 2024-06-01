package com.saika.quizapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.saika.quizapp.model.Questions;
import com.saika.quizapp.service.QuestionService;;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("/allQuestions")
    public ResponseEntity<List<Questions>> getAllQuestions(){
        ResponseEntity<List<Questions>> result = questionService.getAllQuestions();

        System.out.println(result);
        return result;
    }
    
    @GetMapping("/category/{category}")
    public List<Questions> getQuestionsByCategory(@PathVariable String category){
        List<Questions> result = questionService.getQuestionsByCategory(category);

        System.out.println(result);
        return result;
    }
    
    @PostMapping("/add")
    public String addQuestion(@RequestBody Questions question){
        return questionService.addQuestion(question);
    }
}
