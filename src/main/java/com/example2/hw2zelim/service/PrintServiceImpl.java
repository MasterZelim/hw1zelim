package com.example2.hw2zelim.service;

import com.example2.hw2zelim.dao.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrintServiceImpl implements PrintService {

    private final QuestionDao questionDao;

    @Autowired
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
