# Quiz Runner

## Overview

The **Quiz Runner** project is an interactive quiz application that allows two types of users: **Admin** and **Student**. Admin users can create and save quizzes, while Student users can take the quiz and get graded based on their performance. This application adheres to Object-Oriented Programming (OOP) principles and modern Java practices.

## Features

- **Admin Role**:
    - Add new quiz questions, options, and correct answers.
    - Save questions into a JSON file for persistence.
- **Student Role**:
    - Attempt 10 randomly selected quiz questions.
    - Receive feedback and grading based on performance.
- **Data Management**:
    - All questions and user information are stored and retrieved from JSON files.

## Technologies Used

- Java
- JSON (using `org.json.simple` library for JSON parsing and writing)
- Object-Oriented Design
- IntelliJ IDEA

## Prerequisites

- JDK 17 or above
- IntelliJ IDEA or any Java-supported IDE

## Project Structure

```
QuizRunner/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── QuizRunner.java
│   │   │   ├── SampleQuestion.java
│   │   ├── resources/
│   │   │   ├── quiz.json
│   │   │   ├── users.json
├── README.md

```

## How to Run

1. Clone the repository:
    
    ```bash
    git clone https://github.com/zfnkml/SalmanRahman-SDET-Simple-Project-on-Java-Quiz-System.git
    cd QuizRunner
    
    ```
    
2. Open the project in your preferred IDE.
3. Run the `QuizRunner.java` file.
4. Choose your role when prompted:
    - **Admin**: Create quizzes.
    - **Student**: Attempt quizzes.

## JSON File Structure

- `users.json` Stores user credentials and roles:
    
    ```json
    [
      {
        "username": "admin",
        "password": "adminpass",
        "role": "admin"
      },
      {
        "username": "student",
        "password": "studentpass",
        "role": "student"
      }
    ]
    
    ```
    
- `quiz.json` Stores quiz questions:
    
    ```json
    [
      {
        "answerkey": 2,
        "option 3": "A well-designed user interface.",
        "option 4": "Efficient algorithm performance.",
        "question": "5. What does the term 'bug' refer to in software testing?",
        "option 1": "An intentional feature added to the software.",
        "option 2": "An error or flaw in the software."
      }
    ]
    
    ```
    

## Future Enhancements

- Add support for multiple-choice answers.
- Implement a web interface for better user experience.
- Use a database for better scalability.
