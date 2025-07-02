
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("Menu:");
            System.out.println("1. Add student");
            System.out.println("2. View students");
            System.out.println("3. Search student");
            System.out.println("4. Delete student");
            System.out.println("5. Edit student details");
            System.out.println("6. Sort students");
            System.out.println("7. Filter students");
            System.out.println("8. Exit");
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {

                case 1:
                    studentManager.addStudent(studentManager.students, scanner);
                    break;
                case 2:studentManager.viewStudent(studentManager.students);
                    break;
                case 3:studentManager.searchStudent(studentManager.students, scanner);
                    break;
                case 4:studentManager.deleteStudent(studentManager.students, scanner);
                    break;
                case 5:studentManager.editStudent(studentManager.students, scanner);
                    break;
                case 6:studentManager.sortStudent(studentManager.students, scanner);
                    break;
                case 7:studentManager.filterStudent(studentManager.students, scanner);
                    break;
                case 8:
                    System.out.println("Exiting.....");
                    break;

            }
        }  while(choice != 8);




        }


    }





