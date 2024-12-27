# 📝 Quiz Runner

## Table of Contents

1. [📝 Overview](#-overview)  
2. [🛠️ Features](#️-features)  
   - [Admin Role](https://github.com/zfnkml/SalmanRahman-SDET-Simple-Project-on-Java-Quiz-System/tree/main?tab=readme-ov-file#admin-role--executing-as-admin)  
   - [Student Role](#student-role)  
   - [Data Management](#data-management)  
3. [🖥️ Technologies Used](#️-technologies-used)  
4. [🔒 Prerequisites](#-prerequisites)  
5. [🏗️ Project Structure](#️-project-structure)  
6. [🚀 How to Run](#-how-to-run)  
7. [📋 JSON File Structure](#-json-file-structure)  
   - [users.json](#usersjson)  
   - [quiz.json](#quizjson)  
8. [📡 Future Enhancements](#-future-enhancements)

---

## 💭 Overview

The **Quiz Runner** project is an interactive quiz application that allows two types of users: 

1. **Admin** : can create and save quizzes
2. **Student :** can take the quiz and get graded based on their performance. 

This application adheres to Object-Oriented Programming (OOP) principles and modern Java practices.

## 🛠️ Features

### Admin Role : [Executing as Admin](https://go.screenpal.com/watch/cZltltnelC2)
- Add new quiz questions, options, and correct answers.
- Save questions into a JSON file for persistence.

### Student Role : [Executing as Student](https://go.screenpal.com/watch/cZlt6ynelus)
- Attempt 10 randomly selected quiz questions.
- Receive feedback and grading based on performance.
https://go.screenpal.com/watch/cZlt6ynelus

### Data Management
- All questions and user information are stored and retrieved from JSON files.

## 🖥️ Technologies Used

- Java
- JSON (using `org.json.simple` library for JSON parsing and writing)
- Object-Oriented Design
- IntelliJ IDEA

## 🔒 Prerequisites

- JDK 17 or above
- IntelliJ IDEA or any Java-supported IDE

## 🏗️ Project Structure

```
QuizRunner/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── QuizRunner.java
│   │   │   ├── SampleQuestion.java
│   │   │   ├── QuizService.java
│   │   ├── resources/
│   │   │   ├── quiz.json
│   │   │   ├── users.json
├── README.md

```

## 🚀 How to Run

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

## 📋 JSON File Structure

### users.json

Stores user credentials and roles:
    
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

### quiz.json

Stores quiz questions:
    
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

## 📡 Future Enhancements

- Add support for multiple-choice answers.
- Implement a web interface for better user experience.
- Use a database for better scalability.
