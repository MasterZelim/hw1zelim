package com.example.hw1zelim.service;

import com.example.hw1zelim.dao.QuestionDao;

public class PrintServiceImpl implements PrintService {

    private final QuestionDao questionDao;



    public PrintServiceImpl(QuestionDao questionDao) {
        this.questionDao = questionDao;

    }


    @Override
    public void print() {

        System.out.println("print start");
        questionDao.readQuestionsFromSource().forEach(System.out::println);
        System.out.println("print end");
    }
}
