package com.tss.dip.model;

public interface Logger {
    void registerLog(String log) throws Exception;
    void getLogs();
}
