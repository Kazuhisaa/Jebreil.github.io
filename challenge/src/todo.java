import java.util.Scanner;
import java.util.ArrayList;

public class todo {
    public static void TodoList() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> tasks = new ArrayList<>();

        while (true) {
            System.out.println("=========================");
            System.out.println("       To-Do List        ");
            System.out.println("=========================");

            System.out.println("Menu:");
            System.out.println("1. Add Task");
            System.out.println("2. View Task");
            System.out.println("3. Mark Task as Done");
            System.out.println("4. Remove Task");
            System.out.println("5. Exit");
            System.out.print("Choose an Option: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    addtask(tasks, scanner);
                    break;
                case 2:
                    viewtask(tasks);
                    break;
                case 3:
                    markdone(tasks,scanner);
                    break;
                case 4:
                    removetask(tasks, scanner);
                    break;
                case 5:
                    System.out.println("Goodbye!"); //
                    return;
                default:
                    break;
            }


            System.out.println();
        }
    }

    public static void addtask(ArrayList<String> tasks, Scanner scanner) {
        while (true) {
            System.out.print("Enter Task: ");
            String task = scanner.nextLine();
            tasks.add(task);
            System.out.println("Task Added!");

            System.out.print("Do you want to add more tasks? (1.Yes | 2.No): ");
            int choose = scanner.nextInt();
            scanner.nextLine();

            if (choose != 1) {
                break;
            }
        }
    }

    public static void viewtask(ArrayList<String> tasks) {
        System.out.println();
        if (tasks.isEmpty()) {
            System.out.println("No Tasks");
        } else {
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    public static void markdone(ArrayList<String> tasks, Scanner scanner){
        System.out.println();
        if (tasks.isEmpty()) {
            System.out.println("No Tasks to Mark as Done");
            return;
        }
        viewtask(tasks);


        System.out.println("Enter number to mark as Done: ");
        int index = scanner.nextInt();
        scanner.nextLine();

        if (index < 1 || index >= tasks.size()) {
            System.out.println("Invalid Index");
            return;

        }
        String oldtask = tasks.get(index - 1);

        if (oldtask.startsWith("[DONE]")) {
            System.out.println("Mark as Done");
            return;
        }

        String updatedTask = "[DONE] " + oldtask;
        tasks.set(index - 1, updatedTask);

        System.out.println("Task marked as done!");

    }


    public static void removetask(ArrayList<String> tasks, Scanner scanner){
        System.out.println();
        if (tasks.isEmpty()) {
            System.out.println("No Tasks to Remove as Done");
            return;
        }
        viewtask(tasks);

        System.out.println("Enter number to remove: ");
        int index = scanner.nextInt();
        scanner.nextLine();

        if (index < 0 || index >= tasks.size()) {
            System.out.println("Invalid Index");
            return;

        }
        String remove =  tasks.remove(index - 1);
        System.out.println("Task removed as done!" + remove);

    }


}

