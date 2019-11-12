/**
 * @author: Ramzi Jabali, Date 02/27/2019, Class time: 10AM to 11AM Monday -
 * Thursday
 *
 * @purpose:The @GradeCalc program was created to grab the users input for
 * 5 major components of the CSC110 syllabus that make up the final grade.
 * The program after verifying the users input successfully will calculate
 * the amount of points earned in each of the 5 major components of the
 * CSC110 syllabus and the final grade including the matching letter grade.
 * After processing the user input, the program outputs the points for each
 * component, the final grade, a letter grade, and a message that corresponds
 * to the resulting letter grade.
 */
import java.util.*;

public class GradeCalc {
    public static void main(String[] args) {

        //constants for the weight of each syllabus component
        final double PROGRAMMING_ASSIGNMENTS_WEIGHT = 0.35;
        final double LAB_ASSIGNMENTS_WEIGHT = 0.10;
        final double MPL_HMW_WEIGHT = 0.15;
        final double MID_TERMS_WEIGHT = 0.20;
        final double FINAL_EXAM_WEIGHT = 0.20;
        //Variables used to calculate USERINPUT and CONSTANTS to provide the answers
        double programmingAssignmentPoints;
        double labAssignmentPoints;
        double MplHwPoints;
        double MidtermPoints;
        double finalExamPoints;
        double sumOfPoints;
        //variables that take in UserInput for the percentages they have earned for syllabus component
        int percentageProgrammingAssignments = 0;
        int percentageLabAssignment = 0;
        int percentageMplHw = 0;
        int percentageMidtermExam = 0;
        int percentageFinalExam = 0;
        //Character to hold the Letter grade
        char letterGrade = ' ';
        //flag to terminate code when input is invalid
        boolean hasInputError = false;

        Scanner kb = new Scanner(System.in);

        System.out.println("GradeCalc\n"
                + "This application calculates the letter grade in CSC110 based on the user inputs\n"
                + "  NOTE: All inputs should be in range of 0 to 100, inclusive.\n");

        //START of the INPUT SECTION
        //grabs user INPUT and checks if it's within the wanted guidelines
        System.out.println("Programming Assignment percentage earned:");
        percentageProgrammingAssignments = kb.nextInt();
        if (percentageProgrammingAssignments < 0 || percentageProgrammingAssignments > 100) {
            System.out.println("Input Error: Programming Assignments percentage out of range.");
            hasInputError = true;
        }
        if (!hasInputError) {
            System.out.println("Lab Assignment percentage earned:");
            percentageLabAssignment = kb.nextInt();
            if (percentageLabAssignment < 0 || percentageLabAssignment > 100) {//inner if to check Lab Assignments
                System.out.println("Input Error: Lab Assignments percentage out of range.");
                hasInputError = true;
            }
        }
        if (!hasInputError) {
            System.out.println("MPL Homework percentage earned: ");
            percentageMplHw = kb.nextInt();
            if (percentageMplHw < 0 || percentageMplHw > 100) {
                System.out.println("Input Error: MPL Homework percentage out of range.");
                hasInputError = true;
            }
        }
        if (!hasInputError) {
            System.out.println("Midterm Exam percentage earned: ");
            percentageMidtermExam = kb.nextInt();
            if (percentageMidtermExam < 0 || percentageMidtermExam > 100) {
                System.out.println("Input Error: Midterm Exam percentage out of range.");
                hasInputError = true;
            }
        }
        if (!hasInputError) {
            System.out.println("Final Exam percentage earned: ");
            percentageFinalExam = kb.nextInt();
            if (percentageFinalExam < 0 || percentageFinalExam > 100) {
                System.out.println("Input Error: Final Exam percentage out of range.");
                hasInputError = true;
            }
        }
        //END of the INPUT SECTION

        //START of the PROCESSING SECTION
        //PROCESSING the user INPUT that has been checked or verified
        programmingAssignmentPoints = PROGRAMMING_ASSIGNMENTS_WEIGHT * percentageProgrammingAssignments;
        labAssignmentPoints = LAB_ASSIGNMENTS_WEIGHT * percentageLabAssignment;
        MplHwPoints = MPL_HMW_WEIGHT * percentageMplHw;
        MidtermPoints = MID_TERMS_WEIGHT * percentageMidtermExam;
        finalExamPoints = FINAL_EXAM_WEIGHT * percentageFinalExam;
        //Final grade is stored here
        sumOfPoints = programmingAssignmentPoints + labAssignmentPoints + MplHwPoints + MidtermPoints + finalExamPoints;

        //CHECKING WHICH GRADE CORRESPONdS WITH WHICH LETTER GRADE AND SAVING IT TO the CHAR LETTER GRADE
        if (sumOfPoints < 60 || percentageFinalExam < 60) {
            letterGrade = 'F';
        } else if (sumOfPoints < 69.5) {
            letterGrade = 'D';
        } else if (sumOfPoints < 79.5) {
            letterGrade = 'C';
        } else if (sumOfPoints < 89.5) {
            letterGrade = 'B';
        } else {
            letterGrade = 'A';
        }
        //END of PROCESSING SECTION

        //START of OUTPUT SECTION
        //DISPLAYING USER INPUT SO THE USER COULD SEE WHAT THEY ENTERED AGAIN
        if (!hasInputError) {
            System.out.printf("\nProgramming Assignment percentage:" + "%7d\n", percentageProgrammingAssignments);
            System.out.printf("Lab Assignment percentage:" + "%15d\n", percentageLabAssignment);
            System.out.printf("MPL Homework percentage:" + "%17d\n", percentageMplHw);
            System.out.printf("Midterm exam percentage:" + "%17d\n", percentageMidtermExam);
            System.out.printf("Final exam percentage:" + "%19d\n", percentageFinalExam);

            //DISPLAYING USERS SCORE IN EACH PART OF THE USERS ENTIRE GRADE
            System.out.printf("Programming Assignment points earned:" + "%6.1f\n", programmingAssignmentPoints);
            System.out.printf("Lab Assignment points earned:" + "%14.1f\n", labAssignmentPoints);
            System.out.printf("MPL Homework points earned:" + "%16.1f\n", MplHwPoints);
            System.out.printf("Midterm exams points earned:" + "%15.1f\n", MidtermPoints);
            System.out.printf("Final exam points earned:" + "%18.1f\n", finalExamPoints);
            System.out.printf("Total number of points earned:" + "%13.1f\n", sumOfPoints);
            System.out.printf("Student's letter grade earned:" + "%9s\n", letterGrade);

            switch (letterGrade) {
                case 'A':
                    System.out.println("   Great Job! You will have no problem in CSC205.");
                    break;
                case 'B':
                    System.out.println("   Good Job! You should have little trouble in CSC205.");
                    break;
                case 'C':
                    System.out.println("   Ok, you passed, but you may be challenged in CSC205.");
                    break;
                case 'D':
                    System.out.println("   When you retake this course, you will be able to do much better.");
                    break;
                case 'F':
                    if (percentageFinalExam < 60) {
                        System.out.println("   You did not score enough points on the Final Exam to pass this course.");
                    } else {
                        System.out.println("   You did not put forth enough effort to pass this course.");
                    }
                    break;
                default:
                    break;
            }
        }
        //END  of OUTPUT SECTION
        System.out.println("GradeCalc is now terminating.");//Marking the end of the program
    }
}
