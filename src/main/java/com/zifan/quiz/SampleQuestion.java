package com.zifan.quiz;

import java.util.ArrayList;
import java.util.List;

/*
 ** 2024, December 24, Tuesday, 7:36 PM
 */
public class SampleQuestion {
    private String question;
    private final List<String> optionList = new ArrayList<>();
    private int answerKey;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<String> getOptionList() {
        return optionList;
    }

    public void addOption(String option) {
        optionList.add(option);
    }

    public int getAnswerKey() {
        return answerKey;
    }

    public void setAnswerKey(int answerKey) {
        this.answerKey = answerKey;
    }

    @Override
    public String toString() {
        return String.format("Question: %s, Options: %s, Answer: %d", question, optionList, answerKey);
    }
}
