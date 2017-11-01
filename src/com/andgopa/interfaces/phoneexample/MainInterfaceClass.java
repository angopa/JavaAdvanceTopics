package com.andgopa.interfaces.phoneexample;

/**
 * Created by Andres Gonzalez ====== 10/31/17
 **/
public class MainInterfaceClass {

    public static void main(String[] args) {
        ITelephone myTelephone = new DeskPhone(553885721);
        myTelephone.powerOn();
        myTelephone.callPhone(553885721);
        myTelephone.isRinging();
        myTelephone.answer();

        myTelephone = new MobilePhone(2345);
        myTelephone.powerOn();
        myTelephone.callPhone(2345);
        myTelephone.answer();
    }
}
