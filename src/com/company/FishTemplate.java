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
