package com.tss.dip.model;

import java.util.ArrayList;
import java.util.List;

public class FileLogger implements Logger {

    private List<String> fileLogger = new ArrayList<>();

    @Override
    public void registerLog(String log) {
        fileLogger.add(log);
    }

    @Override
    public void getLogs() {
        System.out.println("File Logs:");
        fileLogger.forEach(System.out::println);
    }
}
