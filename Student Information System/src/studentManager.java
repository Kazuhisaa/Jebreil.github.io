
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


public class studentManager {
    static ArrayList<student> students = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);


    public static void addStudent(ArrayList<student> students, Scanner scanner) {
        System.out.println("++++++++++++++++++++");
        System.out.println("+ STUDENT DATABASE +");
        System.out.println("++++++++++++++++++++");


        System.out.print("Enter Student Name: ");
        String studentName = scanner.nextLine();

        System.out.print("Enter Student Age: ");
        int studentAge = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Student Grade Level: ");
        String studentGrade = scanner.nextLine();


        student student = new student(studentName, studentAge, studentGrade);
        students.add(student);
        System.out.println("Student added successfully");


    }

    public static void viewStudent(ArrayList<student> students) {
        System.out.println("++++++++++++++++++++");
        System.out.println("+ STUDENT DATABASE +");
        System.out.println("++++++++++++++++++++");

        if (students.isEmpty()) {
            System.out.println("Student list is empty");
            System.out.println("Do you want to add student? (yes | no )");
            String option = scanner.nextLine();
            if (option.equals("yes")) {
                studentManager.addStudent(students, scanner);
            }
        } else {
            for (student student : students) {
                student.displayInfo();
                System.out.println("__________________\n");
            }
        }
    }

    public static void searchStudent(ArrayList<student> students, Scanner scanner) {
        System.out.println("++++++++++++++++++++");
        System.out.println("+ STUDENT DATABASE +");
        System.out.println("++++++++++++++++++++");

        if (students.isEmpty()) {
            System.out.println("Student list is empty");
            System.out.println("Do you want to add student? (yes | no )");
            String option = scanner.nextLine();
            if (option.equals("yes")) {
                studentManager.addStudent(students, scanner);
            }
        }

        while (true) {
            System.out.println("Enter Student Name to Search: ");
            String studentName = scanner.nextLine();

            boolean found = false;
            for (student s : students) {
                if (s.name.toLowerCase().contains(studentName.toLowerCase())) {
                    s.displayInfo();
                    found = true;

                }
            }
            if (!found) {
                System.out.println("Student not found.");
            }

            System.out.print("Do you want to search again? (yes/ no): ");
            String choice = scanner.nextLine().toLowerCase();
            if (!choice.equals("yes")) {
                System.out.println("Search ended.");
                break;
            }

        }


    }

    public static void deleteStudent(ArrayList<student> students, Scanner scanner) {
        System.out.println("++++++++++++++++++++");
        System.out.println("+ STUDENT DATABASE +");
        System.out.println("++++++++++++++++++++");


        if (students.isEmpty()) {
            System.out.println("Student list is empty");
            System.out.println("Do you want to add student? (yes | no )");
            String option = scanner.nextLine();
            if (option.equals("yes")) {
                studentManager.addStudent(students, scanner);
            }
        }

        while (true) {
            System.out.print("Enter Student Name to Delete: ");
            String studentName = scanner.nextLine().toLowerCase();

            ArrayList<student> matches = new ArrayList<>();
            for (student s : students) {
                if (s.name.toLowerCase().contains(studentName)) {
                    matches.add(s);
                }
            }

            if (matches.isEmpty()) {
                System.out.println("No matching student found.");
            } else {
                System.out.println("Found " + matches.size() + " matching student(s):");
                for (int i = 0; i < matches.size(); i++) {
                    System.out.println("[" + (i + 1) + "]");
                    matches.get(i).displayInfo();
                    System.out.println();
                }

                System.out.print("Enter the number of the student to delete: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // consume leftover newline

                if (choice >= 1 && choice <= matches.size()) {
                    student selected = matches.get(choice - 1);
                    students.remove(selected);
                    System.out.println("Student deleted successfully.");
                } else {
                    System.out.println("Invalid selection.");
                }
            }

            System.out.print("Do you want to delete another student? (yes/no): ");
            String again = scanner.nextLine().toLowerCase();
            if (!again.equals("yes")) {
                System.out.println("Ended.");
                break;
            }
        }
    }

    public static void editStudent(ArrayList<student> students, Scanner scanner) {
        System.out.println("++++++++++++++++++++");
        System.out.println("+ STUDENT DATABASE +");
        System.out.println("++++++++++++++++++++");


        if (students.isEmpty()) {
            System.out.println("Student list is empty");
            System.out.print("Do you want to add a student? (yes | no): ");
            String option = scanner.nextLine();
            if (option.equalsIgnoreCase("yes")) {
                studentManager.addStudent(students, scanner);
            }
            return;
        }
        ArrayList<student> matches = new ArrayList<>();

        while (true) {
            matches.clear();
            System.out.print("Enter Student Name to Edit: ");
            String studentName = scanner.nextLine().toLowerCase();

            for (student s : students) {
                if (s.name.toLowerCase().contains(studentName)) {
                    matches.add(s);
                }
            }

            if (matches.isEmpty()) {
                System.out.println("No matching student found.");
            } else {
                System.out.println("Found " + matches.size() + " matching student(s):");
                for (int i = 0; i < matches.size(); i++) {
                    System.out.println("[" + (i + 1) + "]");
                    matches.get(i).displayInfo();
                    System.out.println();
                }

                System.out.print("Enter the number of the student to edit: ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                if (choice >= 1 && choice <= matches.size()) {
                    student selectedStudent = matches.get(choice - 1);

                    System.out.print("Enter new name: ");
                    selectedStudent.name = scanner.nextLine();

                    System.out.print("Enter new age: ");
                    int newAge = scanner.nextInt();
                    scanner.nextLine();
                    selectedStudent.age = newAge;

                    System.out.print("Enter new grade level: ");
                    selectedStudent.gradeLevel = scanner.nextLine();

                    System.out.println("Student info updated successfully.");
                } else {
                    System.out.println("Invalid selection.");
                }
            }

            System.out.print("Do you want to edit another student? (yes/no): ");
            String again = scanner.nextLine().toLowerCase();
            if (!again.equals("yes")) {
                System.out.println("Edit ended.");
                break;
            }
        }
    }

    public static void sortStudent(ArrayList<student> students, Scanner scanner) {
        System.out.println("++++++++++++++++++++");
        System.out.println("+ STUDENT DATABASE +");
        System.out.println("++++++++++++++++++++");
        int choice;

        do {
            System.out.println("Sort Order by: ");
            System.out.println("1. Sort by Name");
            System.out.println("2. Sort by Age");
            System.out.println("3. Sort by Grade Level");
            System.out.println("4. Return to Main Menu");
            choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 1) {
                System.out.println("Sorted by Name");
                Collections.sort(students, Comparator.comparing(student -> student.name.toLowerCase()));
                for (student s : students) {
                    s.displayInfo();
                    System.out.println();
                }

            } else if (choice == 2) {
                System.out.println("Sorted by Age");
                Collections.sort(students, Comparator.comparing(student -> student.age));
                for (student s : students) {
                    s.displayInfo();
                    System.out.println();
                }

            } else if (choice == 3) {
                System.out.println("Sorted by Grade Level");
                Collections.sort(students, Comparator.comparing(student -> student.gradeLevel.toLowerCase()));
                for (student s : students) {
                    s.displayInfo();
                    System.out.println();
                }
            } else if (choice == 4) {
                return;
            } else {
                System.out.println("Invalid selection.");
            }


        } while (choice != 8);

    }

    public static void filterStudent(ArrayList<student> students, Scanner scanner) {
        System.out.println("++++++++++++++++++++");
        System.out.println("+ STUDENT DATABASE +");
        System.out.println("++++++++++++++++++++");


        while (true) {
            System.out.println("Enter Grade Level to Filter: ");
            String grade = scanner.nextLine().toLowerCase();

            ArrayList<student> matches = new ArrayList<>();
            for (student s : students) {
                if (s.gradeLevel.toLowerCase().contains(grade.toLowerCase())) {
                    matches.add(s);
                }
            }

            if (matches.isEmpty()) {
                System.out.println("No matching student found.");

            } else {
                System.out.println("Found " + matches.size() + " matching student(s):");
                for (int i = 0; i < matches.size(); i++) {
                    System.out.println("[" + (i + 1) + "]");
                    matches.get(i).displayInfo();
                    System.out.println();
                }


            }
            System.out.print("Do you want to filter again? (yes/no): ");
            String again = scanner.nextLine().toLowerCase();
            if (!again.equals("yes")) {
                System.out.println("Edit ended.");
                break;
            }
        }
    }
}

