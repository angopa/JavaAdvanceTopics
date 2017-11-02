package com.andgopa.innerclass;

/**
 * Created by Andres Gonzalez ====== 11/2/17
 **/
public class MainInnerClass {

    public static void main(String[] args) {
        GearBox mcLaren = new GearBox(6);
        mcLaren.addGear(1, 5.3);
        mcLaren.addGear(2, 10.6);
        mcLaren.addGear(3, 15.9);
        mcLaren.operateCluch(true);
        mcLaren.changeGear(1);
        mcLaren.operateCluch(false);
        System.out.println(mcLaren.wheelSpeed(1000));
        mcLaren.changeGear(2);
        System.out.println(mcLaren.wheelSpeed(3000));
        mcLaren.operateCluch(true);
        mcLaren.changeGear(3);
        mcLaren.operateCluch(false);
        System.out.println(mcLaren.wheelSpeed(6000));
    }
}
