package com.tss.ocp.model;

public class Display {
    private final SimpleInterest interestCalculate;

    public Display(SimpleInterest interestCalculate) {
        this.interestCalculate = interestCalculate;
    }

    public void show() {
        double interest = interestCalculate.calculate();
        double maturedAmount = interestCalculate.getFixedDeposite().getAmount() + interest;

        System.out.println("------ Fixed Deposit Details ------");
        System.out.println("Account Number   : " + interestCalculate.getFixedDeposite().getAccountNo());
        System.out.println("Deposit Amount   : " + interestCalculate.getFixedDeposite().getAmount());
        System.out.println("Duration (Years) : " + interestCalculate.getFixedDeposite().getDuration());
        System.out.println("Interest Rate    : " +
                (interestCalculate.getFixedDeposite().getFestivalOffer().getInterestRate()) + "%");
        System.out.println("Interest Earned  : " + interest);
        System.out.println("Matured Amount   : " + maturedAmount);
        System.out.println("----------------------------------");
    }

}
