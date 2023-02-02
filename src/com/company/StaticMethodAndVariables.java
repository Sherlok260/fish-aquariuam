package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StaticMethodAndVariables {

    public static int numberOfFishMan = new Random().nextInt(100)+100;
    public static int numberOfFishWoman = new Random().nextInt(100)+100;
    public static int aquariumSizeX = 3;
    public static int aquariumSizeY = 3;
    public static int aquariumSizeZ = 3;
    public static int liveTime;
    public static String oldGender = "";
    public static int oldPositionX = -1;
    public static int oldPositionY = -1;
    public static int oldPositionZ = -1;
    public static int oldNumber = -1;

    public static List<Thread> threads = new ArrayList<>();



    public static int positionX() {
        return new Random().nextInt(aquariumSizeX);
    }
    public static int positionY() {
        return new Random().nextInt(aquariumSizeY);
    }
    public static int positionZ() {
        return new Random().nextInt(aquariumSizeZ);
    }
    public static int liveTime() {
        return new Random().nextInt(10)+5;
    }

    public static String randGen() {
        return new Random().nextInt(2) == 0? "Woman": "Man";
    }
}
