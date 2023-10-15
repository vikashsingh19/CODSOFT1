import java.util.Scanner;

class GradeCalculator {
    private final String studentName;
    private final int numSubjects;
    private final int[] marks;

    public GradeCalculator(String studentName, int numSubjects) {
        this.studentName = studentName;
        this.numSubjects = numSubjects;
        marks = new int[numSubjects];
    }

    public void inputMarks(Scanner scanner) {
        System.out.println("Enter marks for each subject (out of 100):");
        for (int i = 0; i < numSubjects; i++) {
            int mark;
            do {
                System.out.print("Subject " + (i + 1) + ": ");
                mark = scanner.nextInt();
                if (mark < 0 || mark > 100) {
                    System.out.println("Invalid input! Marks should be between 0 and 100.");
                }
            } while (mark < 0 || mark > 100);
            marks[i] = mark;
        }
    }

    public void calculateResults() {
        int totalMarks = 0;
        for (int mark : marks) {
            totalMarks += mark;
        }

        double averagePercentage = (double) totalMarks / (numSubjects * 100) * 100;
        char grade;
        if (averagePercentage >= 90) {
            grade = 'A';
        } else if (averagePercentage >= 80) {
            grade = 'B';
        } else if (averagePercentage >= 70) {
            grade = 'C';
        } else if (averagePercentage >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }

        System.out.println("\nResults for " + studentName + ":");
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + String.format("%.2f", averagePercentage) + "%");
        System.out.println("Grade: " + grade);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        System.out.print("Enter the number of subjects: ");
        int numSubjects = scanner.nextInt();

        GradeCalculator gradeCalculator = new GradeCalculator(name, numSubjects);
        gradeCalculator.inputMarks(scanner);
        gradeCalculator.calculateResults();

        scanner.close();
    }
}
