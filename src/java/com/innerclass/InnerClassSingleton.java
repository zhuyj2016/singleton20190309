package com.innerclass;

import java.io.Serializable;

public class InnerClassSingleton implements Serializable {

    private InnerClassSingleton(){}

    public static InnerClassSingleton getInstance(){
        return Handle.innerClassSingleton;
    }

    private static class Handle{
        private static InnerClassSingleton innerClassSingleton = new InnerClassSingleton();
    }


    private Object readResolve(){
        return Handle.innerClassSingleton;
    }
}
