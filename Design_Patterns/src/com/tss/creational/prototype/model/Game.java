package com.tss.creational.prototype.model;

public class Game {
    public static void main(String[] args) {
        Enemy enemy = new Enemy(100, "Bow", 10);

        Enemy e1 = enemy.clone();
        e1.setPosition(-10, 20);
        System.out.println(e1);

        Enemy e2 = enemy.clone();
        e2.setPosition(-30, -5);
        System.out.println(e2);
    }
}
