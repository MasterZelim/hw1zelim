package com.example1.hw1zelim.dao;

import com.example1.hw1zelim.model.Question;

import java.util.List;

public interface QuestionDao {

    List<Question> readQuestionsFromSource();
}
