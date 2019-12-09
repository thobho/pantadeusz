package com.sda;

public class SleepUtil {

    private static final long SLEEP_TIME_MILIS = 1;

    static void sleepThread(){
        try {
            Thread.sleep(SLEEP_TIME_MILIS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
