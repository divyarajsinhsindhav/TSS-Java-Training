package com.tss.creational.singleton;

public class DBMain {
    public static void main(String[] args) {
        DB db1 = DB.getInstance();
        DB db2 = DB.getInstance();
        System.out.println(db1.hashCode());
        System.out.println(db2.hashCode());
        System.out.println(db1.equals(db2));
    }
}
