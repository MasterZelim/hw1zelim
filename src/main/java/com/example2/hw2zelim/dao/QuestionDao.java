package com.example2.hw2zelim.dao;

import com.example2.hw2zelim.model.Question;

import java.util.List;

public interface QuestionDao {

    List<Question> readQuestionsFromSource();
}
