package com.tss.creational.singleton;

public class DB {
//    private static DB db;
//
//    private DB() {
//
//    }
//
//    public static DB getInstance() {
//        if (db == null) {
//            db = new DB();
//        }
//        return db;
//    }
    private static class SingletonHolder {
        public static final DB INSTANCE = new DB();
    }

    public static DB getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
