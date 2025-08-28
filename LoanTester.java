import java.util.Scanner;

public class LoanTester {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter cost, monthly payment and interest rate");
        double cost = input.nextDouble();
        double monthlyPayment = input.nextDouble();
        double interestRate = input.nextDouble();

        LoanAmount loan = new LoanAmount(cost, interestRate, monthlyPayment);

        System.out.println();
        System.out.println(loan.toString());

        input.close();
    }
}
