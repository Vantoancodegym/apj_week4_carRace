package model;

public class Car implements Runnable {

    public static final int BEGIN_DISTANCE = 0;
    public static final int END_DISTANCE = 100;
    public static final int STEP = 5;
    private String name;

    public Car(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        int runDistance= BEGIN_DISTANCE;
        long startTime=System.currentTimeMillis();
        while (runDistance< END_DISTANCE){
            try {
            int speed=(int)(Math.random()*20+1);
            runDistance+=speed;
            String log = "|";
            int percentTravel = (runDistance * 100) / END_DISTANCE;
            for (int i = 0; i < END_DISTANCE; i += STEP) {
                if (percentTravel >= i + STEP) {
                    log += "=";
                } else if (percentTravel >= i && percentTravel < i + STEP) {
                    log += "o";
                } else {
                    log += "-";
                }
            }
            log += "|";
            System.out.println("Car" + this.name + ": " + log + " " + Math.min(END_DISTANCE, runDistance) + "KM");
            Thread.sleep(1000);

        } catch (InterruptedException e) {
            System.out.println("Car" + this.name + " broken...");
            break;
        }
            long endTime = System.currentTimeMillis();
            System.out.println("Car" + this.name + " Finish in " + (endTime - startTime) / 1000 + "s");
        }

    }
}
