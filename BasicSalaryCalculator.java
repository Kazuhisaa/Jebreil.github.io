import java.util.Scanner;

public class BasicSalaryCalculator {
     public static void main(String[] args){
        System.out.println("Basic Salary Calculator");
        Scanner scanner = new Scanner(System.in);

            System.out.print("How much is your rate per hour? ");
            double rate = scanner.nextDouble();
            System.out.print("How many hours do you work per day? ");
            int hours = scanner.nextInt();
            System.out.print("How many days did you work? ");
            int days = scanner.nextInt();
            System.out.print("How  many hours you have OT? ");
            int ot = scanner.nextInt();
            System.out.println("How  many hours do you work between 10pm to 6am? ");
            int nightdiff = scanner.nextInt();
            
            int totalhours = ( hours * days ) + ot;
            System.out.println("Your Total Hours is: " + totalhours);
            double totalnightdiff = (nightdiff * 0.1);
            double totalsalary = (totalhours * rate) + totalnightdiff;
            System.out.print("Your Total salary is: " + totalsalary);

            double sss = totalsalary * 0.045;
            System.out.printf("Your SSS deduction: %.2f%n", sss);

            double philhealth = totalsalary * 0.0225;
            System.out.printf("Your PhilHealth is: %.2f%n", philhealth);

            double pagibig = totalsalary * 0.02;
            System.out.printf("Your Pag-IBIG is: %.2f%n", pagibig);

            double netpay = totalsalary - (sss + philhealth + pagibig);
            System.out.printf("Your total net pay is: %.2f%n", netpay);
      

        scanner.close();

    }
}
