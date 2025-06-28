import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class guessing {
    public static void number(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("=========================");
        System.out.println("  NUMBER GUESSING GAME   ");
        System.out.println("=========================");


        System.out.println("Choose Difficulty: ");
        System.out.println("1. Easy\n2. Medium\n3. Hard\n4. Exit");
        int choice = scanner.nextInt();

        switch(choice){
            case 1: easy(scanner);
                break;
            case 2: medium(scanner);
                break;
            case 3:hard(scanner);
                break;
            case 4: System.exit(0);
                break;
                default:
                    break;
        }

    }

    public static void easy(Scanner scanner) {
        Random rand = new Random();
        int num = rand.nextInt(20) + 1;

        int attempts = 0;
        int guess;

        do {
            System.out.println("What is the number? ");
            guess = scanner.nextInt();
            attempts++;

            if (guess < num) {
                System.out.println("Too Low");
            } else if (guess > num) {
                System.out.println("Too High");
            } else if (guess == num) {
                System.out.println("Correct");
                System.out.println("Your Attempts: " + attempts);

            }

        } while (guess != num);
        again(scanner);
    }


    public static void medium(Scanner scanner) {
        Random rand = new Random();
        int num = rand.nextInt(100) + 1;

        int attempts = 0;
        int guess;

        do {
            System.out.println("What is the number? ");
            guess = scanner.nextInt();
            attempts++;

            if (guess < num) {
                System.out.println("Too Low");
            } else if (guess > num) {
                System.out.println("Too High");
            } else if (guess == num) {
                System.out.println("Correct");
                System.out.println("Your Attempts: " + attempts);

            }
        } while (guess != num);
            again(scanner);
    }

    public static void hard(Scanner scanner) {
        Random rand = new Random();
        int num = rand.nextInt(1000) + 1;

        int attempts = 0;
        int guess;

        do {
            System.out.println("What is the number? ");
            guess = scanner.nextInt();
            attempts++;

            if (guess < num) {
                System.out.println("Too Low");
            } else if (guess > num) {
                System.out.println("Too High");
            } else if (guess == num) {
                System.out.println("Correct");
                System.out.println("Your Attempts: " + attempts);
            }


        } while (guess != num);
        again(scanner);

    }
    public static void again(Scanner scanner) {
        System.out.println("Do You want to guess again? 1/yes | 2. no");
        scanner.nextLine();
        String choice = scanner.nextLine();
        if (choice.equals("1")) {
            number();
        }else{
            System.out.println("Thanks for playing!");
        }
    }

}

