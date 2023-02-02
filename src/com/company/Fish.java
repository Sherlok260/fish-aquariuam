package com.company;

public class Fish extends StaticMethodAndVariables {

    public void test() throws InterruptedException {

        for (int i=0; i<Math.max(numberOfFishMan, numberOfFishWoman); i++) {
            if (i<numberOfFishMan)
                threads.add(new Thread(new FishTemplate("Man", i)));
            if(i<numberOfFishWoman)
                threads.add(new Thread(new FishTemplate("Woman", i)));
        }

        for(int i=0; i < threads.size(); i++) {
            threads.get(i).start();
            threads.get(i).join();
        }
    }
}
