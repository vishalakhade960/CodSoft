import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class QuizApplication {
    static int score = 0; // To store the user's score
    static boolean answered = false; // To check if the user answered within the time limit
    static Timer timer; // Timer object

    public static void main(String[] args) {
        // Questions, options, and answers
        String[] questions = {
                "What is the capital of France?",
                "Which programming language is platform-independent?",
                "What is the square root of 64?"
        };

        String[][] options = {
                {"1. Rome", "2. Berlin", "3. Paris", "4. Madrid"},
                {"1. Python", "2. C++", "3. Java", "4. JavaScript"},
                {"1. 6", "2. 7", "3. 8", "4. 9"}
        };

        int[] answers = {3, 3, 3}; // Correct options (1-indexed)

        Scanner sc = new Scanner(System.in);

        // Loop through questions
        for (int i = 0; i < questions.length; i++) {
            answered = false; // Reset answered flag
            System.out.println("\nQuestion " + (i + 1) + ": " + questions[i]);

            // Display options
            for (String option : options[i]) {
                System.out.println(option);
            }

            // Start a timer for 10 seconds
            startTimer();

            // Read user's answer
            int userAnswer = -1;
            try {
                userAnswer = sc.nextInt();
                answered = true; // User has answered
            } catch (Exception e) {
                System.out.println("Invalid input!");
                sc.next(); // Clear invalid input
            }

            // Cancel the timer
            timer.cancel();

            // Check the answer if answered on time
            if (answered) {
                if (userAnswer == answers[i]) {
                    System.out.println("Correct!");
                    score++;
                } else {
                    System.out.println("Wrong!");
                }
            } else {
                System.out.println("Time's up! Moving to the next question.");
            }
        }

        // Display the final score
        System.out.println("\nQuiz Over! Your score is: " + score + "/" + questions.length);
        sc.close();
    }

    // Method to start the timer
    public static void startTimer() {
        timer = new Timer();
        timer.schedule(new TimerTask() {
            int seconds = 10; // Time limit for each question

            @Override
            public void run() {
                if (seconds > 0) {
                    System.out.print("\rTime left: " + seconds + " seconds ");
                    seconds--;
                } else {
                    System.out.println("\nTime's up!");
                    answered = false;
                    timer.cancel(); // Stop the timer
                }
            }
        }, 0, 1000);
    }
}