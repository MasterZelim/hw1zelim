package com.example2.hw2zelim.model;

import java.util.List;

public class Question {

    private int number;
    private String question;
    private List<String> answers;

    public Question(){

    }

    public Question(int number, String question, List<String> answers) {
        this.number = number;
        this.question = question;
        this.answers = answers;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }

    @Override
    public String toString() {
        return "Question{" +
                "number=" + number +
                ", question='" + question + '\'' +
                ", answers=" + answers +
                '}';
    }
}
