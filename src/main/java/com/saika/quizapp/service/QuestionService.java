package com.saika.quizapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.saika.quizapp.model.Questions;
import com.saika.quizapp.dao.QuestionDao;

/*Written service just because its in the service layer */

@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<List<Questions>> getAllQuestions(){

       /*System.out.println("<---------Inside getAllQuestion Function------------>");*/
        List<Questions> result = questionDao.findAll();

        System.out.println(result);

        try{
            return new ResponseEntity<>(result,HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
        }
          return new ResponseEntity<>(new ArrayList<>(),HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public List<Questions> getQuestionsByCategory(String category){

        List<Questions> result = questionDao.findByCategory(category);

       // System.out.println(result);

        return result;
    }

    public String addQuestion(Questions question){
        /*System.out.println("<---------Inside addQuestion Function------------>");*/
        System.out.println(question);
        questionDao.save(question);
        return "success";
    }
}
