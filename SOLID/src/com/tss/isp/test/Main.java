package com.tss.isp.test;

import com.tss.isp.model.Human;
import com.tss.isp.model.Robot;

public class Main {
    public static void main(String[] args) {
        Human human = new Human();
        Robot robot = new Robot();

        human.doWork();
        robot.doWork();

        human.eating();
        robot.charging();
    }
}
