package com.tss.dip.model;

import java.util.ArrayList;
import java.util.List;

public class DBLogger implements Logger {

    private final List<String> dbLogger = new ArrayList<>();
    private int failAfter = 3;

    @Override
    public void registerLog(String log) throws Exception {
        if (dbLogger.size() == this.failAfter) {
            throw new Exception("DB Logger stopped!");
        }
        dbLogger.add(log);
    }

    @Override
    public void getLogs() {
        System.out.println("DB Logs:");
        dbLogger.forEach(System.out::println);
    }
}
