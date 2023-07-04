// Online Java Compiler
// Use this editor to write, compile and run your Java code online

import java.util.Scanner;

public class QuizGame {
    private static final int TIME_LIMIT_SECONDS = 30;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of questions: ");
        int numQuestions = scanner.nextInt();
        scanner.nextLine();

        String[][] quiz = new String[numQuestions][2];

        System.out.println("\nEnter the questions and answers:");

        // User input for questions and answers
        for (int i = 0; i < numQuestions; i++) {
            System.out.println("\nQuestion " + (i + 1) + ": ");
            quiz[i][0] = scanner.nextLine();

            System.out.println("Answer " + (i + 1) + ": ");
            quiz[i][1] = scanner.nextLine();
        }

        int score = 0;
        int questionCount = 0;
        String userAnswer;
        boolean continuePlaying = true;

        while (continuePlaying== true && questionCount < numQuestions) {
            String question = quiz[questionCount][0];
            String answer = quiz[questionCount][1];

            System.out.println("\nQuestion " + (questionCount + 1) + ": " + question);
            System.out.print("Enter your answer: ");

            long startTime = System.currentTimeMillis();
            userAnswer = scanner.nextLine();
            long endTime = System.currentTimeMillis();
            double timeTakenSeconds = (endTime - startTime) / 1000.0;

            if (timeTakenSeconds > TIME_LIMIT_SECONDS) {
                System.out.println("Time's up!");
            } else if (userAnswer.equalsIgnoreCase(answer)) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect!");
            }

            questionCount++;

            if (score >= 10) {
                System.out.println("\nCongratulations! You scored 10 points!");
                break;
            }

            System.out.print("\nDo you want to continue playing? (y/n): ");
            String choice = scanner.nextLine();

            if (choice.equalsIgnoreCase("n")) {
                continuePlaying = false;
            }
        }

        System.out.println("\nQuiz completed!");
        System.out.println("Your score: " + score + "/" + questionCount);

        scanner.close();
    }
}
