package com.tss.dip.test;

import com.tss.dip.model.*;

import java.util.concurrent.LinkedBlockingQueue;

public class Main {
    public static void main(String[] args) throws Exception {
        Logger dbLogger = new DBLogger();
        Logger fileLogger = new FileLogger();

        Task task = new Task(dbLogger, fileLogger);
        task.task();

        dbLogger.getLogs();
        fileLogger.getLogs();
    }
}
