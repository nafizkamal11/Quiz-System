package com.zifan.quiz;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

/*
 ** 2024, December 24, Tuesday, 7:36 PM
 */
public class QuizService {
    private final Scanner scanner = new Scanner(System.in);
    private final String quizFile = "./src/main/resources/quiz.json";
    private final String usersFile = "./src/main/resources/users.json";


    public String login() throws IOException, ParseException {
        System.out.println("System : Enter your username");
        System.out.print("User   : ");
        String username = scanner.nextLine();

        System.out.println("System : Enter your password");
        System.out.print("User   : ");
        String password = scanner.nextLine();

        try (FileReader fileReader = new FileReader(usersFile)) {
            JSONArray users = (JSONArray) new JSONParser().parse(fileReader);
            for (Object obj : users) {
                JSONObject user = (JSONObject) obj;
                if (username.equals(user.get("username")) && password.equals(user.get("password")))
                    return (String) user.get("role");
            }
        }

        return "";
    }

    public void adminWorkflow() throws IOException, ParseException {
        System.out.println("System : Welcome Admin! Create new questions.");
        String input;
        do {
            saveQuestion(createQuestion());

            System.out.println("Do you want to add more questions? (s to start, q to quit): ");
            System.out.print("Admin  : ");
        } while ((input = scanner.nextLine()).equals("s"));
    }

    public void studentWorkflow() throws IOException, ParseException {
        System.out.println("System : Welcome to the quiz!");
        System.out.println("System : We will throw you 10 questions. Each MCQ mark is 1 and no negative marking.");
        System.out.println("System : Are you ready? Press 's' for start.");
        System.out.print("Student: ");
        String input;
        while ((input = scanner.nextLine()).equals("s")) {
            displayGrade(conductQuiz());

            System.out.println("System : Would you like to start again? (s to start, q to quit): ");
            System.out.print("Student: ");
        }
    }

    private SampleQuestion createQuestion() {
        SampleQuestion question = new SampleQuestion();

        System.out.println("System : Enter the question:");
        System.out.print("Admin  : ");
        question.setQuestion(scanner.nextLine());

        for (int i = 1; i <= 4; i++) {
            System.out.printf("System : Enter option %d:%n", i);
            System.out.print("Admin  : ");
            question.addOption(scanner.nextLine());
        }

        System.out.println("System : Enter the correct option number (1-4):");
        System.out.print("Admin  : ");
        question.setAnswerKey(scanner.nextInt());
        scanner.nextLine();

        return question;
    }

    private void saveQuestion(SampleQuestion sampleQuestion) throws IOException, ParseException {
        JSONArray jsonArray;
        try (FileReader fileReader = new FileReader(quizFile)) {
            jsonArray = (JSONArray) new JSONParser().parse(fileReader);
        } catch (FileNotFoundException e) {
            jsonArray = new JSONArray();
        }

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("question", sampleQuestion.getQuestion());
        for (int i = 0; i < sampleQuestion.getOptionList().size(); i++) {
            jsonObject.put("option " + (i + 1), sampleQuestion.getOptionList().get(i));
        }
        jsonObject.put("answerkey", sampleQuestion.getAnswerKey());
        jsonArray.add(jsonObject);

        try (FileWriter fileWriter = new FileWriter(quizFile)) {
            fileWriter.write(jsonArray.toJSONString());
        }

        System.out.print("System : Question saved successfully!");
    }

    private int conductQuiz() throws IOException, ParseException {
        int marks = 0;
        JSONArray jsonArray;

        try (FileReader fileReader = new FileReader(quizFile)) {
            jsonArray = (JSONArray) new JSONParser().parse(fileReader);
        }

        Random random = new Random();
        for (int i = 1; i <= 10; i++) {
            JSONObject jsonObject = (JSONObject) jsonArray.get(random.nextInt(jsonArray.size()));
            System.out.printf("System : [Question %d] %s%n", i, jsonObject.get("question"));
            for (int j = 1; j <= 4; j++) {
                System.out.printf("\t\t\t%d. %s%n", j, jsonObject.get("option " + j));
            }

            System.out.print("Student: ");
            int answer = scanner.nextInt();
            scanner.nextLine();

            if (answer == Integer.parseInt(jsonObject.get("answerkey").toString())) {
                marks++;
            }
        }

        return marks;
    }

    private void displayGrade(int marks) {
        if (marks >= 8) {
            System.out.printf("System : Excellent! You have got %d out of 10.\n", marks);
        } else if (marks >= 5) {
            System.out.printf("System : Good. You have got %d out of 10.\n", marks);
        }else if (marks >= 2) {
            System.out.printf("System : Very poor! You have got %d out of 10.\n", marks);
        } else {
            System.out.printf("System : Very sorry you are failed. You have got %d out of 10.\n", marks);
        }
    }
}
