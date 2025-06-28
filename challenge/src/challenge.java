import java.util.Scanner;

public class challenge {
     public static void main(String[] args){
                Scanner input = new Scanner(System.in);
        
        System.out.println("=========================");
        System.out.println("JAVA FUNDAMENTAL PROJECTS");
        System.out.println("=========================");

        System.out.println("1. Calculator");
        System.out.println("2. Student Grade Calculator");
        System.out.println("3. To-do List");
        System.out.println("4. Number Guessing Game");
        System.out.println("5. Basic Salary Calulator");
        System.out.println("6. Exit");
         System.out.println("Choose an option: ");

        int option = input.nextInt();
        switch (option){
            case 1: Calculatormethod.Calculator();
                break;
            case 2: grademethod.Grade();
                break;
            case 3:todo.TodoList();
                break;
            case 4:guessing.number();
                break;
            case 5:salary.calculator();
                break;
             case 6:System.out.println("6.Exiting...");
                break;
    
        }
   input.close();
    }
   

}
