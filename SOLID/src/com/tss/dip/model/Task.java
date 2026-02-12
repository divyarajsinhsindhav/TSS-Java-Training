package com.tss.dip.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Task {

    private Logger primaryLogger;
    private Logger backupLogger;
    private Logger activeLogger;

    public Task(Logger primaryLogger, Logger backupLogger) {
        this.primaryLogger = primaryLogger;
        this.backupLogger = backupLogger;
        this.activeLogger = primaryLogger;
    }

    public void task() throws Exception {
        int currentValue = 0;
        final int STOPPING_VALUE = 8;
        while (currentValue < STOPPING_VALUE) {
            String message = LocalDate.now() + " || " + LocalTime.now();

            try {
                activeLogger.registerLog(message);
            } catch (Exception e) {
                System.out.println("Switching to FileLogger...");
                activeLogger = backupLogger;
                activeLogger.registerLog(message);
            }

            Thread.sleep(1000);
            currentValue++;
        }
    }
}
