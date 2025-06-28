import java.util.Scanner;

public class Calculatormethod {

    public static void Calculator() {
        Scanner input = new Scanner(System.in);
        double x, y;
        char op;

        
        System.out.println("=========================");
        System.out.println("      CALCULATOR         ");
        System.out.println("=========================");

        System.out.print("Enter first number: ");
        x = input.nextDouble();

        System.out.print("Enter operator (+ - * /): ");
        op = input.next().charAt(0);

        System.out.print("Enter second number: ");
        y = input.nextDouble();

        switch (op) {
            case '+': System.out.println("Result: " + (x + y)); break;
            case '-': System.out.println("Result: " + (x - y)); break;
            case '*': System.out.println("Result: " + (x * y)); break;
            case '/': 
                if (y == 0) {
                    System.out.println("Cannot divide by 0");
                } else {
                    System.out.println("Result: " + (x / y));
                }
                break;
            default:
                System.out.println("Invalid operator.");


        }
        input.close();
    }  
}
