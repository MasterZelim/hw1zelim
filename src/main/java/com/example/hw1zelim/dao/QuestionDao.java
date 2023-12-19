package com.example.hw1zelim.dao;

import com.example.hw1zelim.model.Question;

import java.util.List;

public interface QuestionDao {

    List<Question> readQuestionsFromSource();
}
