package com.andgopa.interfaces.phoneexample;

/**
 * Created by Andres Gonzalez ====== 10/31/17
 **/
public interface ITelephone {

    void powerOn();

    void dial(int phoneNumber);

    void answer();

    boolean callPhone(int phoneNumber);

    boolean isRinging();
}
