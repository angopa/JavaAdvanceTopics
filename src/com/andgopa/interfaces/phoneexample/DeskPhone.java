package com.andgopa.interfaces.phoneexample;

/**
 * Created by Andres Gonzalez ====== 10/31/17
 **/
public class DeskPhone implements ITelephone {

    private int myNumber;
    private boolean isRinnging;

    public DeskPhone(int myNumber) {
        this.myNumber = myNumber;
    }

    @Override
    public void powerOn() {
        System.out.println("No action taken, desk phone not have a power button.");
    }

    @Override
    public void dial(int phoneNumber) {
        System.out.println("No ringing " + phoneNumber + " on desktop");
    }

    @Override
    public void answer() {
        if (isRinnging) {
            System.out.println("Answering the desk phone");
            isRinnging = false;
        }
    }

    @Override
    public boolean callPhone(int phoneNumber) {
        if (phoneNumber == myNumber) {
            isRinnging = true;
            System.out.println("Ring ... ring ... ring ...");
        } else {
            isRinnging = false;
        }
        return isRinnging;
    }

    @Override
    public boolean isRinging() {
        return isRinnging;
    }
}
