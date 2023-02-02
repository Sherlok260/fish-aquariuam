package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StaticMethodAndVariables {

    public static int numberOfFishMan = 50;
    public static int numberOfFishWoman = 50;
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

    public void check(String new_g, int new_x, int new_y, int new_z, int new_n) throws InterruptedException {
        if(!new_g.equals(oldGender) && new_x == oldPositionX && new_y == oldPositionY && new_z == oldPositionZ) {
            String rGen = randGen();
            System.out.println("New Fish " + rGen + " was born -> " +
                    new_g + "-" + new_n + " position: xyz(" + new_x + ":" + new_y + ":" + new_z + ") and " +
                    oldGender + "-" + oldNumber + " position: xyz(" + oldPositionX + ":" + oldPositionY + ":" + oldPositionZ + ")");
            if(rGen.equals("Woman")) {
                System.out.println("------------------------------------------------------------------------------------------");
                this.threads.add(new Thread(new FishTemplate("Woman",numberOfFishWoman))); numberOfFishWoman+=1;
            } else {
                this.threads.add(new Thread(new FishTemplate("Man",numberOfFishMan))); numberOfFishMan+=1;
            }
        }
    }

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
