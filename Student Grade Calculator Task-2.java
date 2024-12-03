import java.util.Scanner;

public class Task_2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter 5 subject marks:");

        int m1 = input.nextInt();
        int m2 = input.nextInt();
        int m3 = input.nextInt();
        int m4 = input.nextInt();
        int m5 = input.nextInt();
        int total = m1 + m2 + m3 + m4 + m5;
        float percentage = total / 5.0f; 

        System.out.println("Total: " + total);
        System.out.printf("Percentage: %.2f\n", percentage);  
        if (percentage >= 90) {
            System.out.println("Grade A");
        } else if (percentage >= 80) {
            System.out.println("Grade B");
        } else if (percentage >= 70) {
            System.out.println("Grade C");
        } else if (percentage >= 60) {
            System.out.println("Grade D");
        } else if (percentage >= 50) {
            System.out.println("Grade E");
        } else if (percentage >= 40) {
            System.out.println("Grade is Poor");
        } else {
            System.out.println("Fail");
        }

        input.close(); 
    }
}