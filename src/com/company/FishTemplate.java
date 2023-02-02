package com.company;
//import java.util.concurrent.
public class FishTemplate extends StaticMethodAndVariables implements Runnable {
    private final String gender;
    private final int numberOfFish;
    private String condition = "living";
    public  int positionX;
    public  int positionY;
    public  int positionZ;

    public FishTemplate(String gender, int numberOfFish) {
        this.gender = gender;
        this.numberOfFish = numberOfFish;
    }
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
    @Override
    public void run() {
        liveTime = liveTime();
        for (int i=0; i<=liveTime; i++) {
            positionX = positionX();
            positionY = positionY();
            positionZ = positionZ();
            try {
//                Thread.sleep(2000);
                check(gender, positionX, positionY, positionZ, numberOfFish);
//                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(i == liveTime) {
                condition = "dead";
                positionX = -1;
                positionY = -1;
                positionZ = -1;
                System.out.println(
                        "Fish number is: " + numberOfFish
                                +"\tgender:" + gender + "\tpositon: null"
                                +"\tcondition: " + condition + "\tlive_time: " + i + "/" + liveTime
                ); break;
            } // if tugadi
            System.out.println(
                    "Fish number is: " + numberOfFish
                            + "\tgender:" + gender + (gender=="Man"?"\t":"") + "\tpositon: xyz(" + positionX + ":" + positionY + ":" + positionZ + ")"
                            +"\tcondition: " + condition + "\tlive_time: " + i + "/" + liveTime
            );
            oldGender = gender;
            oldPositionX = positionX;
            oldPositionY = positionY;
            oldPositionZ = positionZ;
            oldNumber = numberOfFish;
        }
    }
}
