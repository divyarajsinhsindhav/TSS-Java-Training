package com.tss.ocp.model;

public class FixedDeposite {
    private int accountNo;
    private int duration;
    private double amount;
    private FestivalOffer festivalOffer;

    public FixedDeposite(int accountNo, int duration, double amount, FestivalOffer festivalOffer) {
        this.accountNo = accountNo;
        this.duration = duration;
        this.amount = amount;
        this.festivalOffer = festivalOffer;
    }

    public int getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(int accountNo) {
        this.accountNo = accountNo;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public FestivalOffer getFestivalOffer() {
        return festivalOffer;
    }

    public void setFestivalOffer(FestivalOffer festivalOffer) {
        this.festivalOffer = festivalOffer;
    }
}
