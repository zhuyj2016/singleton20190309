package com.hungry;

public class HungrySingleton {

    private static final HungrySingleton hungrySingleton = new HungrySingleton();
    private HungrySingleton(){
        if(hungrySingleton!=null){
            throw new RuntimeException("不允许创建多个实例");
        }
    }
    public static HungrySingleton getInstance(){
        return hungrySingleton;
    }
}
