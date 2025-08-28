
public class LoanAmount {
    private double loanAmount;
    private double annualInterestRate;
    private double monthlyPayment;

    public LoanAmount(double loanAmount, double annualInterestRate, double monthlyPayment) {
        setLoanAmount(loanAmount);
        setAnnualInterestRate(annualInterestRate);
        setMonthlyPayment(monthlyPayment);
    }

    public void setLoanAmount(double amount) {
        if (amount > 0) {
            this.loanAmount = amount;
        }
    }

    public void setAnnualInterestRate(double rate) {
        if (rate >= 0) {
            this.annualInterestRate = rate;
        }
    }

    public void setMonthlyPayment(double payment) {
        if (payment > 0) {
            this.monthlyPayment = payment;
        }
    }


    public double getMonthlyInterestRate() {
        return annualInterestRate / 12 / 100;
    }

    public double calculateInterest(double loanBalance) {
        return loanBalance * getMonthlyInterestRate();
    }

    // Update loan balance
    public double updateLoanBalance(double loanBalance, double interestPaid) {
        return loanBalance - (monthlyPayment - interestPaid);
    }


    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        double balance = loanAmount;
        int month = 0;

        output.append("Loan Amount: $" + loanAmount + "\n");
        output.append("Annual Interest Rate, in percent: " + annualInterestRate + "%\n");
        output.append("Monthly Payment: $" + monthlyPayment + "\n");
        output.append("------------------------------------------------------------\n");
        output.append("Months\tLoan\t\tInterest Paid\n");
        output.append("============================================================\n");

        while (balance > 0) {
            month++;
            double interest = calculateInterest(balance);
            if (monthlyPayment <= interest) {
                output.append("Error: Payment is too low to cover monthly interest.\n");
                break;
            }

            if (balance < monthlyPayment) {
                // Last partial payment
                interest = calculateInterest(balance);
                output.append(month + "\t" + String.format("%.2f", balance) + "\t\t" + String.format("%.2f", interest) + "\n");
                balance = 0;
                break;
            }

            output.append(month + "\t" + String.format("%.2f", balance) + "\t\t" + String.format("%.2f", interest) + "\n");

            balance = updateLoanBalance(balance, interest);
        }

        return output.toString();
    }
}
