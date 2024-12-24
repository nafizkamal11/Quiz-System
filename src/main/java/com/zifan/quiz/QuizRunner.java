package com.zifan.quiz;

import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.Scanner;

/*
 ** 2024, December 24, Tuesday, 7:35 PM
 */
public class QuizRunner {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            QuizService quizService = new QuizService();
            String role = quizService.login();
            if ("admin".equals(role))
                quizService.adminWorkflow();
            else if ("student".equals(role))
                quizService.studentWorkflow();
            else
                System.out.println("System : Login failed!");
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}
