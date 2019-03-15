package com.hungry;

public class HungrySingleton2 {

    private static final HungrySingleton2 hungrySingleton;
    static {
        hungrySingleton = new HungrySingleton2();
    }
    private HungrySingleton2(){

    }
    public static HungrySingleton2 getInstance(){
        return hungrySingleton;
    }
}
