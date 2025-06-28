import java.util.Scanner;
import java.util.ArrayList;


public class grademethod {
    public static void Grade(){
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> subjectname = new ArrayList<>();
        ArrayList<Double> subjectgrades = new ArrayList<>();
         ArrayList<Integer> units = new ArrayList<>();
             
        System.out.println("=========================");
        System.out.println("    GRADES CALCULATOR    ");
        System.out.println("=========================");
            

        System.out.println("Enter Student Name: ");
         scanner.nextLine();
        System.out.println("Enter Student's Number ");
        scanner.nextLine();
        System.out.println("How many Subjects? ");
        int subjects = scanner.nextInt();

        for(int i = 1; i <= subjects; i++){
                System.out.println("Subjects "+ i + ":");
                scanner.nextLine();
                String subject = scanner.nextLine();
            subjectname.add(subject);

            System.out.print("Enter grade for " + subject + ": ");
            double grade = scanner.nextDouble();
            subjectgrades.add(grade);

             System.out.println(subject + " Units: ");
                int Units = scanner.nextInt();
            units.add(Units);

         System.out.println();
    
        }

        for (int i = 0; i < subjects; i++) {
            System.out.println(subjectname.get(i) +"| Units: "+ units.get(i) + "| Grade: " + subjectgrades.get(i));
        }   

       double totalWeighted = 0;
        int totalUnits = 0;

        for (int i = 0; i < subjects; i++) {
            totalWeighted += subjectgrades.get(i) * units.get(i);
            totalUnits += units.get(i);
        }

        double average = totalWeighted / totalUnits;

        System.out.println("\nTotal Weighted Grades: " + totalWeighted);
        System.out.println("Total Units: " + totalUnits);
        System.out.printf("Average (GWA): %.2f\n", average);


        scanner.close();
    }
}
