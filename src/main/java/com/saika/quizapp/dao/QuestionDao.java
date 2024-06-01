package com.saika.quizapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.saika.quizapp.model.Questions;


@Repository
public interface QuestionDao extends JpaRepository<Questions,Integer> {

    List<Questions> findByCategory(String category);

    @Query(value =  "Select * from questions as q where q.category=:category order by Rand() limit :num", nativeQuery = true)
    List<Questions> findRandomQuestionsByCategory(String category, int num);

}
