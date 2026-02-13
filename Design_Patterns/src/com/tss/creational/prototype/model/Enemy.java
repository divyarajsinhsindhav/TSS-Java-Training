package com.tss.creational.prototype.model;

public class Enemy implements Prototype{

    private int health;
    private String weapon;
    private int speed;
    private int x, y; // position

    public Enemy(int health, String weapon, int speed) {
        this.health = health;
        this.weapon = weapon;
        this.speed = speed;
    }

    public Enemy clone() {
        return new Enemy(health, weapon, speed);
    };

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Enemy{" +
                "health=" + health +
                ", weapon='" + weapon + '\'' +
                ", speed=" + speed +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}
