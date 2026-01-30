package com.tss.Exception;

public class MinimumBalanceException extends RuntimeException {
    public MinimumBalanceException(double MINIMUM_BALANCE) {
        super("Minium balance must be " + MINIMUM_BALANCE);
    }
}
